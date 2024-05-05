package com.project.sportstore.controller.admin;

/**
 * @author thang
 */import java.util.List;

import com.project.sportstore.model.Order;
import com.project.sportstore.model.OrderDetail;
import com.project.sportstore.service.OrderDetailService;
import com.project.sportstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/admin")
public class OrderAdminController {
    @Autowired
    private OrderService orderSevice;
    @Autowired
    private OrderDetailService orderDetail;

    @RequestMapping("/order")
    public String orders(Model model) {
        List<Order> order = this.orderSevice.getAll();
        model.addAttribute("orders", order);
        return "admin/order/index";
    }

    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer idCart) {
        Order order = this.orderSevice.findById(idCart);
        List<OrderDetail> list = this.orderDetail.getByOrderId(order);
        model.addAttribute("order", order);
        model.addAttribute("list", list);
        return "admin/order/detail";
    }

    @RequestMapping("/updateOrder")
    public String update(@RequestParam("id") Integer idOrder, @RequestParam("status") Integer status) {
        Order order = this.orderSevice.findById(idOrder);
        order.setStatus(status);
        this.orderSevice.create(order);

        return "redirect:/admin/order";
    }
}
