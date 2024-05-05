package com.project.sportstore.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author thang
 */
@Controller
public class RenameAdminController {
    @GetMapping("/getUsername")
    @ResponseBody
    public String getUsername(Principal principal) {
        String userName = "Guest";
        if (principal != null) {
            userName = principal.getName();
        }
        return userName;
    }

}