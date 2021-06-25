package com.edible.mallweb;

import com.edible.mallmodel.Member;
import com.edible.mallmodel.Order;
import com.edible.mallservice.MemberService;
import com.edible.mallservice.OrderService;
import com.edible.mallservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    public boolean memberLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");
        return member!=null;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Map updateMember(HttpServletRequest request) {
        Map<String, String> result = new HashMap<String, String>();
        if(!memberLogin(request)) {result.put("result", "notLogin");}
        else {
            String nickname = request.getParameter("nickname");
            HttpSession session = request.getSession();
            Member member = (Member) session.getAttribute("member");
            member.setNickname(nickname);
            memberService.updateMember(member);
            result.put("result", "success");
        }
        return result;
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    @ResponseBody
    public Map changePassword(HttpServletRequest request) {
        Map<String, String> result = new HashMap<>();
        if(!memberLogin(request)) {result.put("result", "notLogin");}
        else {
            HttpSession session = request.getSession();
            Member member = (Member) session.getAttribute("member");

            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");

            if (oldPassword.equals(member.getPassword())) {
                member.setPassword(newPassword);
                result.put("result", "success");
            } else {
                result.put("result", "wrongPassword");
            }
        }
        return result;
    }

    @RequestMapping(value="/order", method = RequestMethod.GET)
    public String getMemberOrderList(HttpServletRequest request) {
        if(!memberLogin(request)) {return "member";}
        else {
            HttpSession session = request.getSession();
            Member member = (Member) session.getAttribute("member");
            List<Order> orderList = orderService.getOrderByMemberId(member.getMemberId());
            session.setAttribute("orderList", orderList);
        }
        return "member/order";
    }
}
