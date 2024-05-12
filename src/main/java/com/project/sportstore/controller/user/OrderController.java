package com.project.sportstore.controller.user;

import com.project.sportstore.model.*;
import com.project.sportstore.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * @author thang
 */
@Controller
public class OrderController {
    @Autowired
    private CardItemSevice cardItemSevice;
    @Autowired
    private CardSevice cardSevice;
    @Autowired
    private ProductSevice productSevice;
    @Autowired
    private OrderService orderSevice;
    @Autowired
    private OrderDetailService orderDetailSevice;
    @Autowired
    private CategorySevice categorySevice;
    @Autowired
    private BlogService blogService;
    @RequestMapping("/checkout")
    public String checkout(Principal principal, Model model) {
        if (principal == null) {
            return "/user/login";
        }
        CustomUserDetail customUserDetails = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Card card = this.cardSevice.findByUser(customUserDetails.getUser());
        model.addAttribute("user", customUserDetails.getUser());
        model.addAttribute("total",card.totalPrice()) ;
        model.addAttribute("listCard", card);
        List<Category> categories1=categorySevice.getAll();
        model.addAttribute("cate1", categories1);
        String userName = "User";
        if (principal != null) {
            userName = principal.getName();
        }
        model.addAttribute("userName", userName);
        Order order = new Order();
        order.setUser(customUserDetails.getUser());
        model.addAttribute("order", order);
        List<Blog> blog=this.blogService.getAll();
        model.addAttribute("blog", blog);
        return "/user/checkout";
    }


    @PostMapping("/postCheckout")
    public String postCheckout(Model model, Principal principal, @ModelAttribute("order") Order order , @RequestParam("paymentMethod") String paymentMethod ) {
        if (principal == null) {
            return "/user/login";
        }
        CustomUserDetail customUserDetails = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Card card = this.cardSevice.findByUser(customUserDetails.getUser());
        model.addAttribute("total",card.totalPrice());
        order.setUser(customUserDetails.getUser());
        order.setCreateAt(new Date());
        order.setStatus(0);
        if (this.orderSevice.create(order)) {
            for (CardItem cardItem : card.getCardItems()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrder(order);
                orderDetail.setPrice(cardItem.getProduct().getPrice());
                orderDetail.setProduct(cardItem.getProduct());
                orderDetail.setQuantity(cardItem.getQuantity());
                this.orderDetailSevice.add(orderDetail);

            }
        }
        model.addAttribute("checkstatus",getStatusText(order.getStatus()));
        model.addAttribute("card",card);
        List<Category> categories1=categorySevice.getAll();
        model.addAttribute("cate1", categories1);
        this.cardItemSevice.deleteByCardId(card.getId());
        List<Blog> blog=this.blogService.getAll();
        model.addAttribute("blog", blog);
        if (paymentMethod.equals("online")) {
            return "redirect:/pay/" + order.getId();
        } else {
            return "user/bill2";
        }
    }
    @RequestMapping("/bill/{id}")
    public String Build1(@PathVariable("id") Integer id , Model model,Principal principal){
        Order order = this.orderSevice.findById(id);

        List<OrderDetail> orderDetail = this.orderDetailSevice.getByOrderId(order);
        Double total = 0.0;
        for(OrderDetail orderDetail1: orderDetail){
            total+=orderDetail1.getPrice();
        }
        String userName = "User";
        if (principal != null) {
            userName = principal.getName();
        }
        model.addAttribute("userName", userName);
        model.addAttribute("total",total);
        model.addAttribute("checkstatus",getStatusText(order.getStatus()));
        model.addAttribute("order",order);
        model.addAttribute("orderDetail",orderDetail);
        return "/user/bill";
    }
    public String getStatusText(int statusCode) {
        switch (statusCode) {
            case 0:
                return "Chờ xác nhận";
            case 1:
                return "Đã duyệt";
            case 2:
                return "Đang giao";
            case 3:
                return "Giao hàng thành công";
            default:
                return "Unknown";
        }
    }
}
