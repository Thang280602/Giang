package com.project.sportstore.controller.user;

import com.project.sportstore.model.Blog;
import com.project.sportstore.model.User;
import com.project.sportstore.service.BlogService;
import com.project.sportstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author thang
 */
@Controller
public class UserLoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private BlogService blogService;
    @RequestMapping("/login")
    public String login( Model model) {
        List<Blog> blog=this.blogService.getAll();
        model.addAttribute("blog", blog);
        return "/user/login";
    }
    @RequestMapping("/register")
    public String register(Model model) {
        User user=new User();
        model.addAttribute("user", user);
        List<Blog> blog=this.blogService.getAll();
        model.addAttribute("blog", blog);
        ;		return "/user/register";
    }
    @PostMapping("/register")
    public String doRegister(@ModelAttribute("user") User user) {
        String hasPass= new BCryptPasswordEncoder().encode(user.getPassWord());
        user.setPassWord(hasPass);
        user.setEnabled(true);
        this.userService.create(user);

        return "/user/login";
    }
}
