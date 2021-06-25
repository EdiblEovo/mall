package com.edible.mallweb;

import com.edible.mallmodel.Admin;
import com.edible.mallmodel.Member;
import com.edible.mallmodel.Shop;
import com.edible.mallservice.AdminService;
import com.edible.mallservice.MemberService;
import com.edible.mallservice.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private AdminService adminService;

    @RequestMapping(value="/admin", method = RequestMethod.POST)
    @ResponseBody
    public Map adminLogin(HttpServletRequest request) {
        Map<String, String> result = new HashMap<String, String>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin = adminService.login(username, password);

        if(admin == null) {
            result.put("result", "usernameOrPasswordWrong");
        }
        else {
            HttpSession session = request.getSession(true);
            session.setAttribute("admin", admin);
            session.setAttribute("adminId", admin.getAdminId());
            result.put("result", "success");
        }
        return result;
    }

    @RequestMapping(value="/member", method=RequestMethod.POST)
    @ResponseBody
    public Map memberLogin(HttpServletRequest request) {
        Map<String, String> result = new HashMap<String, String>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Member member = memberService.login(username, password);

        if(member == null) {
            result.put("result", "usernameOrPasswordWrong");
        }
        else if (member.getStatus() == 2){
            result.put("result", "userBanned");
        }
        else {
            HttpSession session = request.getSession(true);
            session.setAttribute("member", member);
            session.setAttribute("memberId", member.getMemberId());
            result.put("result", "success");
        }
        return result;
    }

    @RequestMapping(value="/shop", method=RequestMethod.POST)
    @ResponseBody
    public Map shopLogin(HttpServletRequest request) {
        Map<String, String> result = new HashMap<String, String>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Shop shop = shopService.login(username, password);

        if(shop == null) {
            result.put("result", "usernameOrPasswordWrong");
        }
        else if (shop.getStatus() == 2){
            result.put("result", "shopNotPass");
        }
        else if (shop.getStatus() == 0){
            result.put("result", "shopRejected");
        }
        else {
            HttpSession session = request.getSession(true);
            session.setAttribute("shop", shop);
            session.setAttribute("shopId", shop.getShopId());
            result.put("result", "success");
        }
        return result;
    }

    @RequestMapping(value="/register/member", method=RequestMethod.POST)
    @ResponseBody
    public Map memberRegister(@RequestBody Member inputData, HttpServletRequest request) {
        Map<String, String> result = new HashMap<String, String>();
        if(memberService.checkEmail(inputData.getEmail())){
            result.put("result", "emailExist");
        }
        else if (memberService.checkUsername(inputData.getUsername())){
            result.put("result", "usernameExist");
        }
        else{
            Member member = inputData;
            member.setStatus(1);
            member.setCreatedTime(new Timestamp(new Date().getTime()));
            int resultNum = memberService.register(member);
            result.put("username", member.getUsername());
            result.put("result", "success" + resultNum);
        }
        return result;
    }

    @RequestMapping(value="/register/shop", method=RequestMethod.POST)
    @ResponseBody
    public Map shopRegister(@RequestBody Shop inputData, HttpServletRequest request) {
        Map<String, String> result = new HashMap<String, String>();
        if(shopService.checkShopName(inputData.getShopName())){
            result.put("result", "shopNameExist");
        }
        else if (shopService.checkUsername(inputData.getUsername())){
            result.put("result", "usernameExist");
        }
        else{
            Shop shop = inputData;
            shop.setStatus(2);
            shop.setIncome(BigDecimal.ZERO);
            shopService.register(shop);
            result.put("result", "success");
        }
        return result;
    }
}
