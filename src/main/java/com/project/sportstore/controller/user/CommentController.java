package com.project.sportstore.controller.user;

/**
 * @author thang
 */
import java.security.Principal;
import java.util.List;

import com.project.sportstore.model.Comment;
import com.project.sportstore.model.CustomUserDetail;
import com.project.sportstore.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CommentController {
    @Autowired
    private CommentService commentSevice;

    @RequestMapping("/user/comment")
    private String indexComment(Principal principal, Model model) {
        if (principal == null) {
            return "redirect:/user/login";
        }
        CustomUserDetail customUserDetails = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Comment comment1 = new Comment();
        comment1.setUser(customUserDetails.getUser());
        model.addAttribute("comment", comment1);

        return "/user/Comment";
    }

    @PostMapping("/user/commentSeach")
    private String Comment(@ModelAttribute("comment") Comment comment, Principal principal) {
        if (principal == null) {
            return "redirect:/user/login";
        }
        CustomUserDetail customUserDetails = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        comment.setUser(customUserDetails.getUser());
        this.commentSevice.create(comment);
        return "redirect:/user/comment";
    }
}
