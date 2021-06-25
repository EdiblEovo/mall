package com.edible.mallweb;

import com.github.pagehelper.PageInfo;
import com.edible.mallmodel.Product;
import com.edible.mallservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private ShopService shopService;

    @RequestMapping("")
    @ResponseBody
    public Map<String, String> getProductList(HttpServletRequest request) {
        Map<String, String> result = new HashMap<>();
        List<Product> productList = productService.getAllProduct(1,10);
        PageInfo<Product> productPageInfo = new PageInfo<Product>(productList);
        HttpSession session = request.getSession();
        session.setAttribute("productPageInfo", productPageInfo);
        return result;
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    @ResponseBody
    public String getProduct(@RequestParam("id")String id, HttpServletRequest request) {
        Product product = productService.getProductByProductId(Integer.valueOf(id));
        HttpSession session = request.getSession();
        session.setAttribute("product", product);
        return "/product/item";
    }
}
