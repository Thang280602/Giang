package com.project.sportstore.controller.user;

import com.project.sportstore.model.Blog;
import com.project.sportstore.model.Category;
import com.project.sportstore.model.Product;
import com.project.sportstore.service.BlogService;
import com.project.sportstore.service.CategorySevice;
import com.project.sportstore.service.ProductSevice;
import com.project.sportstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

/**
 * @author thang
 */
@Controller
public class CategoryController {
    @Autowired
    private CategorySevice categorySevice;
    @Autowired
    private ProductSevice productSevice;
    @Autowired
    private UserService userService;
    @Autowired
    private BlogService blogService;

    @RequestMapping("")
    public String home(Model model, Principal principal) {
        List<Category> categories = categorySevice.findByCategoryStatus(true);
        model.addAttribute("listCate", categories);
        List<Category> categories1 = categorySevice.getAll();
        model.addAttribute("cate1", categories1);
        List<Product> productAll = productSevice.getAll();
        model.addAttribute("productALL", productAll);
        model.addAttribute("principal", principal);
        String userName = "User";
        if (principal != null) {
            userName = principal.getName();
        }
        model.addAttribute("userName", userName);


        List<Blog> blog=this.blogService.getAll();
        model.addAttribute("blog", blog);
        return "index";
    }
    @RequestMapping("/getAllProduct")
    public String getAllProduct(Model model){
        List<Product> productAll1 = productSevice.getAll();
        model.addAttribute("productALL1", productAll1);
        return "redirect:/index";
    }


    @PostMapping("/searchCate")
    public String SearchCate(Model model, @Param("keyword") String keyword) {
        List<Product> pro6 = this.productSevice.searchCategory(keyword);
        List<Category> categories = categorySevice.getAll();
        model.addAttribute("listCate", categories);
        model.addAttribute("pro6", pro6);

        return "/index2";
    }


    @RequestMapping("/user/aboutus")
    public String AboutUs(){
        return "/user/about";
    }
}
