package com.edible.mallweb;

import com.edible.mallservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private ProductService productService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;
}
