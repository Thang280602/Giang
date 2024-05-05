package com.project.sportstore.controller.user;

import com.project.sportstore.model.*;
import com.project.sportstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
//    @Autowired
//    private BlogService blogService;
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
        Order order = new Order();
        order.setUser(customUserDetails.getUser());
        model.addAttribute("order", order);
//        List<Blog> blog=this.blogService.getAll();
//        model.addAttribute("blog", blog);
        return "/user/checkout";
    }

    @PostMapping("/postCheckout")
    public String postCheckout(Model model, Principal principal, @ModelAttribute("order") Order order) {
        if (principal == null) {
            return "/user/login";
        }
        CustomUserDetail customUserDetails = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Card card = this.cardSevice.findByUser(customUserDetails.getUser());
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
        List<Category> categories1=categorySevice.getAll();
        model.addAttribute("cate1", categories1);
        this.cardItemSevice.deleteByCardId(card.getId());
//        List<Blog> blog=this.blogService.getAll();
//        model.addAttribute("blog", blog);
        return "index";
    }
}
