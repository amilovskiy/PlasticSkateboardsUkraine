package ua.boardshop.controller;

import static ua.boardshop.service.utils.ParamBuilder.getParams;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.entity.Item;
import ua.boardshop.service.ItemService;
import ua.boardshop.validator.ItemValidator;

@Controller
@RequestMapping("/admin/item")
@SessionAttributes("item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@InitBinder("item")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ItemValidator(itemService));
	}

	@ModelAttribute("item")
	public Item getForm(){
		return new Item();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page",itemService.findAll(filter, pageable));
		return "admin-item";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		itemService.delete(id);
		return "redirect:/admin/item"+getParams(pageable, filter);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("item", itemService.findOne(id));
		model.addAttribute("items", itemService.findAll());
		return show(model, pageable, filter);
	}
	
	@RequestMapping("/cancel")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/item";
	}
	
	@PostMapping
	public String save(@ModelAttribute("item")@Valid Item form, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", itemService.findAll());
			return show(model, pageable, filter);
		}
		itemService.save(form);
		status.setComplete();
		return "redirect:/admin/item"+getParams(pageable, filter);
	}
}
