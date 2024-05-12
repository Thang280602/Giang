package com.project.sportstore.controller.user;

import com.project.sportstore.model.Blog;
import com.project.sportstore.model.Category;
import com.project.sportstore.model.ImageProduct;
import com.project.sportstore.model.Product;
import com.project.sportstore.service.BlogService;
import com.project.sportstore.service.CategorySevice;
import com.project.sportstore.service.ProductSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author thang
 */
@Controller
@RequestMapping("/user")
public class DetailController {
    @Autowired
    private ProductSevice productSevice;
    @Autowired
    private CategorySevice categorySevice;
    @Autowired
    private BlogService blogService;
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model, Principal principal) {
        Product product = this.productSevice.findById(id);
        model.addAttribute("productID", product);
        List<Product> pro = this.productSevice.getAll();
        List<Product> pro1=new ArrayList<Product>();
        List<Category> categories1 = categorySevice.getAll();
        model.addAttribute("cate1", categories1);
        for (Product product2 : pro) {
            if(Double.compare(product2.getPrice(), product.getPrice()) == 0) {
                pro1.add(product2);
            }
        }
        String userName = "User";
        if (principal != null) {
            userName = principal.getName();
        }
        model.addAttribute("userName", userName);
        model.addAttribute("products", pro1);
        List<String> imgDetail = new ArrayList<String>();
        for (ImageProduct imgPro : product.getImageProduct()) {
            imgDetail.add(imgPro.getImage());
        }
        model.addAttribute("imgDetail", imgDetail);
        List<Blog> blog=this.blogService.getAll();
        model.addAttribute("blog", blog);
        return "/user/shop-details";
    }
}
