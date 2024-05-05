package com.project.sportstore.controller.user;

import com.project.sportstore.model.Product;
import com.project.sportstore.service.ProductSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author thang
 */
@Controller
public class ProductController {
    @Autowired
    private ProductSevice productService;

    @GetMapping("/user/index/{categoryName}")
    public String getProductByCategory(@PathVariable String categoryName, Model model) {
            List<Product> products = productService.findProductsByCategoryName(categoryName);
            model.addAttribute("products", products);
        return "index";
    }
}
