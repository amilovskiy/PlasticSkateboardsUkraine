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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.editor.CategoryEditor;
import ua.boardshop.editor.CommodityEditor;
import ua.boardshop.editor.ItemEditor;
import ua.boardshop.editor.UserEditor;
import ua.boardshop.entity.Category;
import ua.boardshop.entity.Commodity;
import ua.boardshop.entity.Item;
import ua.boardshop.entity.User;
import ua.boardshop.service.CategoryService;
import ua.boardshop.service.CommodityService;
import ua.boardshop.service.ItemService;
import ua.boardshop.service.UserService;

@Controller
@RequestMapping("/user/shop")
@SessionAttributes("shop")
public class ShopController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CommodityService commodityService;
	
//	@ModelAttribute("filter")
//	public BasicFilter getFilter(){
//		return new BasicFilter();
//	}
	
	@InitBinder("shop")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Item.class, new ItemEditor(itemService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.registerCustomEditor(Commodity.class, new CommodityEditor(commodityService));
		binder.registerCustomEditor(User.class, new UserEditor(userService));
	}
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("items", itemService.findAll());
		model.addAttribute("page", commodityService.findAll(filter, pageable));
		return "user-shop";
	}
	
	@GetMapping("{id}")
	public String showSelectCategory(@PathVariable Long id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("items", itemService.findAll());
		model.addAttribute("commodities", commodityService.findAll(id));
		return "user-selectCategory";
	}
	
}
