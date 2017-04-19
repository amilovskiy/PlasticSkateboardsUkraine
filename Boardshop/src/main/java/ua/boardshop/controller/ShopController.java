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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.editor.CategoryEditor;
import ua.boardshop.editor.UserEditor;
import ua.boardshop.entity.Category;
import ua.boardshop.entity.User;
import ua.boardshop.service.CategoryService;
import ua.boardshop.service.UserService;

@Controller
@RequestMapping("/user/shop")
@SessionAttributes("shop")
public class ShopController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@InitBinder("shop")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.registerCustomEditor(User.class, new UserEditor(userService));
	}
	
	@RequestMapping
	public String show(Model model, @PageableDefault(6) Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", categoryService.findAll(filter, pageable));
		model.addAttribute("amount", userService.getAmountCommodities());
		return "user-shop";
	}
	
	@GetMapping("/notUser")
	public String showNotUser(Model model, @PageableDefault(6) Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", categoryService.findAll(filter, pageable));
		return "user-shop";
	}
	
	
}
