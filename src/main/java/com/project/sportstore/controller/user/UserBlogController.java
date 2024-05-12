package com.project.sportstore.controller.user;

import com.project.sportstore.model.Blog;
import com.project.sportstore.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @author thang
 */
@Controller
public class UserBlogController {
    @Autowired
    private BlogService blogService;
    @RequestMapping("/user/blog/{id}")
    public String blog(@PathVariable("id") Integer id, Model model) {
        List<Blog> blog = this.blogService.getAll();
        model.addAttribute("blog", blog);
        Blog blog1 = this.blogService.findById(id);
        model.addAttribute("blog1", blog1);
        return "/user/blog-details";
    }
}
