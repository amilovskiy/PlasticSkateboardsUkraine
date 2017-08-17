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
import ua.boardshop.entity.Color;
import ua.boardshop.service.ColorService;
import ua.boardshop.validator.ColorValidator;

@Controller
@RequestMapping("/admin/color")
@SessionAttributes("color")
public class ColorController {

	@Autowired
	private ColorService colorService;
	
	@InitBinder("color")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ColorValidator(colorService));
	}

	@ModelAttribute("color")
	public Color getForm(){
		return new Color();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", colorService.findAll(filter, pageable));
		return "admin-color";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		colorService.delete(id);
		return "redirect:/admin/color"+getParams(pageable, filter);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("color", colorService.findOne(id));
		model.addAttribute("colors", colorService.findAll());
		return show(model, pageable, filter);
	}
	
	@RequestMapping("/cancel")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/color";
	}
	
	@PostMapping
	public String save(@ModelAttribute("color")@Valid Color form, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", colorService.findAll());
			return show(model, pageable, filter);
		}
		colorService.save(form);
		status.setComplete();
		return "redirect:/admin/color"+getParams(pageable, filter);
	}
}
