package com.project.sportstore.controller.user;

import com.project.sportstore.model.Product;
import com.project.sportstore.service.ProductSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

/**
 * @author thang
 */
@Controller
public class ShopDetailController {
    @Autowired
    public ProductSevice productSevice;
    @RequestMapping("/user/shop-detail")
    public String detail(Principal principal, Model model){
        List< Product> products = this.productSevice.getAll();
        model.addAttribute("productAll",products);
        String userName = "User";
        if (principal != null) {
            userName = principal.getName();
        }
        model.addAttribute("userName", userName);
        return "/user/shop-sidebar-3-column";
    }
}
