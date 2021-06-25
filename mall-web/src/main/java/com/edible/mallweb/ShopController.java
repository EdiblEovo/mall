package com.edible.mallweb;

import com.edible.mallmodel.Order;
import com.edible.mallmodel.Product;
import com.edible.mallmodel.Shop;
import com.edible.mallservice.OrderService;
import com.edible.mallservice.ProductService;
import com.edible.mallservice.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    private boolean notLogin(HttpServletRequest request){
        HttpSession session = request.getSession();
        Shop shop = (Shop) session.getAttribute("shop");
        return shop == null;
    }

    @RequestMapping(value = "/createproduct",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> createProduct(HttpServletRequest request){
        Map<String, String> result = new HashMap<>();
        if(notLogin(request)){result.put("result", "notLogin");}
        else{
            HttpSession session = request.getSession();
            Product product = new Product();
            product.setShopId((Integer) session.getAttribute("shopId"));
            product.setProductName(request.getParameter("productName"));
            BigDecimal productPrice = new BigDecimal(request.getParameter("productPrice"));
            product.setProductPrice(productPrice);
            product.setStock(Integer.valueOf(request.getParameter("stock")));
            product.setAdvertisePrice(BigDecimal.ZERO);
            product.setMonthlySoldQuantity(0);
            product.setSoldQuantity(0);

            productService.createProduct(product);
            result.put("result", "success");
        }
        return result;
    }

    @RequestMapping(value="/order", method = RequestMethod.GET)
    public String getShopOrderList(HttpServletRequest request) {
        if(notLogin(request)) {return "shop";}
        else {
            HttpSession session = request.getSession();
            Shop shop = (Shop) session.getAttribute("shop");
            List<Order> orderList = orderService.getOrderByShopId(shop.getShopId());
            session.setAttribute("orderList", orderList);
        }
        return "shop/order";
    }

    @RequestMapping(value="/order/{orderId}/update", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> updateOrder(@PathVariable("orderId") Integer orderId, HttpServletRequest request){
        Map<String, String> result = new HashMap<>();
        Order order = orderService.getOrderByOrderId(orderId);

        if(notLogin(request)){result.put("result", "notLogin"); return result;}

        HttpSession session = request.getSession();
        Shop shop = (Shop) session.getAttribute("shop");
        if(order.getShopId()!=shop.getShopId()){result.put("result", "wrongShop"); return result;}

        order.setStatus(Integer.valueOf(request.getParameter("orderStatus")));
        order.setPayAmount(new BigDecimal(request.getParameter("payAmount")));
        orderService.updateOrder(order);
        result.put("result", "success");

        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> updateShop(HttpServletRequest request) {
        Map<String, String> result = new HashMap<String, String>();

        if(notLogin(request)){result.put("result", "notLogin"); return result;}

        HttpSession session = request.getSession();
        Shop shop = (Shop) session.getAttribute("shop");

        shop.setShopName(request.getParameter("shopName"));
        shopService.updateShop(shop);
        result.put("result", "success");
        return result;
    }

}
