package ua.boardshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.boardshop.editor.CommodityEditor;
import ua.boardshop.editor.UserEditor;
import ua.boardshop.entity.Commodity;
import ua.boardshop.entity.User;
import ua.boardshop.service.CommodityService;
import ua.boardshop.service.UserService;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommodityService commodityService;
	
	@InitBinder("cart")
	protected void bind(WebDataBinder binder) {
		binder.registerCustomEditor(User.class, new UserEditor(userService));
		binder.registerCustomEditor(Commodity.class, new CommodityEditor(commodityService));
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("user", userService.getCurrentUser());
//		model.addAttribute("same", userService.findSame(userService.getCurrentUser().getId()));
		model.addAttribute("commodities", commodityService.findList(userService.getCurrentUser().getId()));
		model.addAttribute("price", commodityService.findTotalPrice(userService.getCurrentUser().getId()));
		return "user-cart";
	}
	
	@GetMapping("/delete")
	public String delete(Model model){
		commodityService.findListAndDelete(userService.getCurrentUser().getId());
		return "redirect:/cart";
	}
	
	@GetMapping("/confirm")
	public String confirm(Model model){
		userService.sendMail("Confirm order", userService.getCurrentUser().getEmail(), "Riders on the Storm");
		commodityService.findListAndDelete(userService.getCurrentUser().getId());
		return "user-confirmOrder";
	}
}
