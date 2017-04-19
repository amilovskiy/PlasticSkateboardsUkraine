package ua.boardshop.controller;

import javax.validation.Valid;
import static ua.boardshop.service.utils.ParamBuilder.getParams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.editor.ItemEditor;
import ua.boardshop.entity.Category;
import ua.boardshop.entity.Item;
import ua.boardshop.service.CategoryService;
import ua.boardshop.service.ItemService;
import ua.boardshop.validator.CategoryValidator;

@Controller
@RequestMapping("/admin/category")
@SessionAttributes("category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;	
	
	@Autowired
	private ItemService itemService;	
	
	@InitBinder("category")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Item.class, new ItemEditor(itemService));
		binder.setValidator(new CategoryValidator(categoryService));
	}
	
	@ModelAttribute("category")
	public Category getForm(){
		return new Category();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page",categoryService.findAll(filter, pageable));
		model.addAttribute("items",itemService.findAll());
		return "admin-category";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		categoryService.delete(id);
		return "redirect:/admin/category"+getParams(pageable, filter);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("category", categoryService.findOne(id));
		model.addAttribute("items",itemService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		return show(model, pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("category")@Valid Category form, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", categoryService.findAll());
			model.addAttribute("items",itemService.findAll());
			return show(model, pageable, filter);
		}
		categoryService.save(form);
		status.setComplete();
		return "redirect:/admin/category"+getParams(pageable, filter);
	}

}
