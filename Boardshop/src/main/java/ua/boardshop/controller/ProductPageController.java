package ua.boardshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.boardshop.editor.CommodityEditor;
import ua.boardshop.editor.UserEditor;
import ua.boardshop.entity.Commodity;
import ua.boardshop.entity.User;
import ua.boardshop.service.CommodityService;
import ua.boardshop.service.UserService;

@Controller
@RequestMapping("/user/product_page")
@SessionAttributes("productPage")
public class ProductPageController {

	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private UserService userService;
	
	@InitBinder("productPage")
	protected void bind(WebDataBinder binder) {
		binder.registerCustomEditor(Commodity.class, new CommodityEditor(commodityService));
		binder.registerCustomEditor(User.class, new UserEditor(userService));
	}
	
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model){
		model.addAttribute("amount", userService.findAm(userService.getCurrentUser().getId()));
		model.addAttribute("commodity", commodityService.findOne(id));
		model.addAttribute("user", userService.getCurrentUser());
		return "user-productPage";
	}
	
	@GetMapping("/buy/{id}/{userId}")
	public String buy(@PathVariable Long id, @PathVariable Long userId, Model model){
		model.addAttribute("commodity", commodityService.findOne(id));
		model.addAttribute("user", userService.order(id, userId));
		return "redirect:/user/product_page/{id}";
	}
	
}
