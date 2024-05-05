package com.project.sportstore.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author thang
 */
@Controller
public class TestAdminController {
    @RequestMapping("/logon")
    public String logon() {
        return "admin/logon";
    }
}
