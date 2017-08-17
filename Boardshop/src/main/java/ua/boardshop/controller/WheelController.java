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
import ua.boardshop.entity.Wheel;
import ua.boardshop.service.WheelService;
import ua.boardshop.validator.WheelValidator;

@Controller
@RequestMapping("/admin/wheel")
@SessionAttributes("wheel")
public class WheelController {

	@Autowired
	private WheelService wheelService;
	
	@InitBinder("wheel")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new WheelValidator(wheelService));
	}

	@ModelAttribute("wheel")
	public Wheel getForm(){
		return new Wheel();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", wheelService.findAll(filter, pageable));
		return "admin-wheel";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		wheelService.delete(id);
		return "redirect:/admin/wheel"+getParams(pageable, filter);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("wheel", wheelService.findOne(id));
		model.addAttribute("wheels", wheelService.findAll());
		return show(model, pageable, filter);
	}
	
	@RequestMapping("/cancel")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/wheel";
	}
	
	@PostMapping
	public String save(@ModelAttribute("wheel")@Valid Wheel form, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", wheelService.findAll());
			return show(model, pageable, filter);
		}
		wheelService.save(form);
		status.setComplete();
		return "redirect:/admin/wheel"+getParams(pageable, filter);
	}

}
