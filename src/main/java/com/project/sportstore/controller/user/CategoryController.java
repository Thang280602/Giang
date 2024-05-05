package com.project.sportstore.controller.user;

import com.project.sportstore.model.Category;
import com.project.sportstore.model.Product;
import com.project.sportstore.service.CategorySevice;
import com.project.sportstore.service.ProductSevice;
import com.project.sportstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
//    @Autowired
//    private BlogService blogService;
//    @Autowired
//    private CommentSevice commentSevice;
    @RequestMapping("")
    public String home(Model model) {
        List<Category> categories = categorySevice.findByCategoryStatus(true);
        model.addAttribute("listCate", categories);
        List<Category> categories1 = categorySevice.getAll();
        model.addAttribute("cate1", categories1);
        List<Product> productAll = productSevice.getAll();
        model.addAttribute("productALL", productAll);
//        List<String> models = this.productSevice.findAllDistinctModels();
//        model.addAttribute("model", models);
//        List<String> productAddress = this.productSevice.findProductAddress();
//        model.addAttribute("productAddress", productAddress);
//        model.addAttribute("searchModel", new SearchModel());
//        List<Blog> blog=this.blogService.getAll();
//        model.addAttribute("blog", blog);
        return "index";
    }
    @RequestMapping("/getAllProduct")
    public String getAllProduct(Model model){
        List<Product> productAll1 = productSevice.getAll();
        model.addAttribute("productALL1", productAll1);
        return "redirect:/index";
    }

//    @PostMapping("/fillProduct")
//    public String SearchProduct(Model model, @ModelAttribute("searchModel") SearchModel searchModel) {
//        List<Product> listProduct = this.productSevice.SearchProduct(searchModel);
//        model.addAttribute("product1", listProduct);
//        List<Category> categories = categorySevice.getAll();
//        model.addAttribute("listCate", categories);
//        List<Product> productAll = productSevice.getAll();
//        model.addAttribute("productALL", productAll);
//        List<String> models = this.productSevice.findAllDistinctModels();
//        model.addAttribute("model", models);
//        List<String> productAddress = this.productSevice.findProductAddress();
//        model.addAttribute("productAddress", productAddress);
//        List<Blog> blog=this.blogService.getAll();
//        model.addAttribute("blog", blog);
//        return "/user/indexSearch";
//    }
//
//    @PostMapping("/searchCate")
//    public String SearchCate(Model model, @Param("keyword") String keyword) {
//        List<Product> pro6 = this.productSevice.searchCategory(keyword);
//        List<Category> categories = categorySevice.getAll();
//        model.addAttribute("listCate", categories);
//        model.addAttribute("pro6", pro6);
//
//        return "/index2";
//    }
//
//    @RequestMapping("/user/service")
//    public String Service(Model model) {
//        List<Category> categories = categorySevice.getAll();
//        model.addAttribute("listCate", categories);
//        List<Blog> blog=this.blogService.getAll();
//        model.addAttribute("blog", blog);
//        return "/user/service";
//    }
//
//    @RequestMapping("/user/comingup")
//    public String Comingup(Model model) {
//        List<Category> categories = categorySevice.getAll();
//        model.addAttribute("listCate", categories);
//        return "/user/Comingup";
//    }

//    @GetMapping("/user/profileSetting")
//    public String profileSetting(Model model, Principal principal) {
//        List<Category> categories = categorySevice.getAll();
//        model.addAttribute("listCate", categories);
//        List<Blog> blog=this.blogService.getAll();
//        model.addAttribute("blog", blog);
//        if (principal == null) {
//            return "/user/login";
//        }
//        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
//                .getPrincipal();
//        User user = customUserDetails.getUser();
//        model.addAttribute("user", user);
//        return "/user/ProfileSetting";
//    }

//    @PostMapping("/user/profileSetting")
//    public String FixprofileSetting(Model model, @ModelAttribute("user") User user, Principal principal) {
//        List<Category> categories = categorySevice.getAll();
//        model.addAttribute("listCate", categories);
//        List<Blog> blog=this.blogService.getAll();
//        model.addAttribute("blog", blog);
//        this.userService.updateUserById(user.getId(),user.getFullName(), user.getEmail(), user.getTelephone(), user.getAddress());
//        return "redirect:/user/profileSetting";
//    }
//    @RequestMapping("/user/blog/{id}")
//    public String blog(@PathVariable("id") Integer id, Model model) {
//        List<Comment> comments=this.commentSevice.getAll();
//        model.addAttribute("comment", comments);
//        List<Blog> blog=this.blogService.getAll();
//        model.addAttribute("blog1", blog);
//        List<Category> categories=categorySevice.getAll();
//        model.addAttribute("listCate1", categories);
//        List<Product> product=productSevice.getAll();
//        model.addAttribute("pro", product);
//        Blog blog1=this.blogService.findById(id);
//        model.addAttribute("blog", blog1);
//        return "/user/Blog";
//    }
}
