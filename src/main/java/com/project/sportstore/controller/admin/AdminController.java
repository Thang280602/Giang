package com.project.sportstore.controller.admin;



import com.project.sportstore.model.Order;
import com.project.sportstore.model.User;
import com.project.sportstore.service.OrderService;
import com.project.sportstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserService service;
	@Autowired
	private OrderService orderSevice;
	@GetMapping
	public String index(Model model) {
		List<Order> order = this.orderSevice.getAll();
		model.addAttribute("orders", order);
		return "admin/index";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin/index";
	}
	@RequestMapping("/account")
	public String Accout(Model model) {
		List<User> user=this.service.getALL();
		model.addAttribute("user", user);
		return "admin/account/index";
	}

}
