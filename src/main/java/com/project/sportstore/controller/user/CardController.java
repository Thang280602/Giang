package com.project.sportstore.controller.user;

import java.security.Principal;
import java.util.List;

import com.project.sportstore.model.Card;
import com.project.sportstore.model.CardItem;
import com.project.sportstore.model.Category;
import com.project.sportstore.model.CustomUserDetail;
import com.project.sportstore.service.CardItemSevice;
import com.project.sportstore.service.CardSevice;
import com.project.sportstore.service.CategorySevice;
import com.project.sportstore.service.ProductSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CardController {
	@Autowired
	private CardItemSevice cardItemSevice;
	@Autowired
	private CardSevice cardSevice;
	@Autowired
	private ProductSevice productSevice;
	@Autowired
	private CategorySevice categorySevice;
//	@Autowired
////	private BlogService blogService;
	@GetMapping("/user/card")
	public String showCart(Principal principal, Model model) {
		if (principal == null) {

			return "/user/login";
		}
		CustomUserDetail customUserDetails = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Card card = this.cardSevice.findByUser(customUserDetails.getUser());
		model.addAttribute("tottal",card.totalPrice());
		model.addAttribute("listCard", card);
		List<Category> categories1=categorySevice.getAll();
		model.addAttribute("cate1", categories1);
//		List<Blog> blog=this.blogService.getAll();
//		model.addAttribute("blog", blog);
		return "/user/cart";
	}

	@PostMapping("/user/card")
	public String addCart(Model model,@RequestParam("id") Integer idProduct,@RequestParam("quantity") Integer quantity, Principal principal) {
		if (principal == null) {
			return "/user/login";
		}

		CustomUserDetail customUserDetails = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		// Kiểm tra ID của User
		if (customUserDetails != null && customUserDetails.getUser() != null) {
			// Kiểm tra xem User đã có Card chưa
			if (this.cardSevice.check(customUserDetails.getUser().getId()) == 0) {
				Card card = new Card();
				card.setUser(customUserDetails.getUser());
				this.cardSevice.addCard(card);
			}

			Card card1 = this.cardSevice.findByUser(customUserDetails.getUser());

			CardItem cardItem = new CardItem();

			cardItem.setCard(card1);
			CardItem checkCardItem = this.cardItemSevice.checkCardItem(cardItem.getCard().getId(), idProduct);
			if (checkCardItem != null) {
				checkCardItem.setQuantity(checkCardItem.getQuantity() + quantity);
				this.cardItemSevice.add(checkCardItem);
			} else {
				cardItem.setProduct(this.productSevice.findById(idProduct));
				cardItem.setQuantity(quantity);
				this.cardItemSevice.add(cardItem);
			}

			return "redirect:/user/card";
		}
		return "/user/login";
	}

	@RequestMapping("/user/card-delete")
	public String deleteCartItem(@RequestParam("id") Integer id) {
		this.cardItemSevice.delete(id);
		return "redirect:/user/cart";
	}
	@GetMapping("/user/cardMy")
	public String showCart1(Principal principal, Model model) {
		if (principal == null) {

			return "/user/login";
		}
		CustomUserDetail customUserDetails = (CustomUserDetail) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Card card = this.cardSevice.findByUser(customUserDetails.getUser());
		model.addAttribute("listCard", card);
		List<Category> categories1=categorySevice.getAll();
		model.addAttribute("cate1", categories1);
//		List<Blog> blog=this.blogService.getAll();
//		model.addAttribute("blog", blog);
		return "/user/cart";
	}

}
