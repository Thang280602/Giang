package com.project.sportstore.controller.user;

import com.project.sportstore.model.Blog;
import com.project.sportstore.model.Category;
import com.project.sportstore.model.Product;
import com.project.sportstore.service.BlogService;
import com.project.sportstore.service.CategorySevice;
import com.project.sportstore.service.ProductSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author thang
 */
@Controller
public class ProductController {
    @Autowired
    private ProductSevice productService;
    @Autowired
    private CategorySevice categorySevice ;
    @Autowired
    private BlogService blogService;
    @GetMapping("/user/index/{categoryName}")
    public String getProductByCategory(@PathVariable String categoryName, Model model) {
            List<Product> products = productService.findProductsByCategoryName(categoryName);
            model.addAttribute("products", products);
        return "index";
    }
    @GetMapping("/user/ListingClassic/Search")
    public String searchProducts(@RequestParam(name = "sortOrder", defaultValue = "asc") String sortOrder,
                                 Model model) {
        if ("asc".equals(sortOrder)) {
            List<Product> products=this.productService.findAllOrderByPriceAsc(sortOrder);
            model.addAttribute("products", products);
            List<Category> categories=categorySevice.getAll();
            model.addAttribute("listCate", categories);

            List<Blog> blog=this.blogService.getAll();
            model.addAttribute("blog", blog);
            return "/user/ListingClassicSX";
        } else if ("desc".equals(sortOrder)) {
            List<Product> productss=this.productService.findAllOrderByPriceDESC(sortOrder);
            model.addAttribute("productss", productss);
            List<Category> categories=categorySevice.getAll();
            model.addAttribute("listCate", categories);

            List<Blog> blog=this.blogService.getAll();
            model.addAttribute("blog", blog);
            return "/user/ListingClassicSX2";
        } else if ("az".equals(sortOrder)) {
            List<Product> productsss=this.productService.getOrderByNew(sortOrder);
            model.addAttribute("productsss", productsss);
            List<Category> categories=categorySevice.getAll();
            model.addAttribute("listCate", categories);
            List<Blog> blog=this.blogService.getAll();
            model.addAttribute("blog", blog);
            return "/user/ListingClassicSX3";
        } else {
            return "redirect:/user/ListingClassic";

        }
    }
}
