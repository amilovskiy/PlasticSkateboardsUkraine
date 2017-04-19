package ua.boardshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.editor.CommodityEditor;
import ua.boardshop.editor.UserEditor;
import ua.boardshop.entity.Commodity;
import ua.boardshop.entity.User;
import ua.boardshop.service.CommodityService;
import ua.boardshop.service.UserService;

@Controller
@RequestMapping("/shop/productList")
@SessionAttributes("productList")
public class ProductListController {

	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@InitBinder("productList")
	protected void bind(WebDataBinder binder) {
		binder.registerCustomEditor(Commodity.class, new CommodityEditor(commodityService));
		binder.registerCustomEditor(User.class, new UserEditor(userService));
	}
	
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("commodities", commodityService.findAll(id));
		model.addAttribute("amount", userService.getAmountCommodities());
		return "user-productList";
	}
	
}
