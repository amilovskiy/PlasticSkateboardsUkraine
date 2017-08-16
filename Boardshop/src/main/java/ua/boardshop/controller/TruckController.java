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
import ua.boardshop.entity.Truck;
import ua.boardshop.service.ItemService;
import ua.boardshop.service.TruckService;
import ua.boardshop.validator.ItemValidator;
import ua.boardshop.validator.TruckValidator;

@Controller
@RequestMapping("/admin/truck")
@SessionAttributes("truck")
public class TruckController {

	@Autowired
	private TruckService truckService;
	
	@InitBinder("truck")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new TruckValidator(truckService));
	}

	@ModelAttribute("truck")
	public Truck getForm(){
		return new Truck();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page",truckService.findAll(filter, pageable));
		return "admin-truck";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		truckService.delete(id);
		return "redirect:/admin/truck"+getParams(pageable, filter);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("truck", truckService.findOne(id));
		model.addAttribute("trucks", truckService.findAll());
		return show(model, pageable, filter);
	}
	
	@PostMapping
	public String save(@ModelAttribute("truck")@Valid Truck form, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", truckService.findAll());
			return show(model, pageable, filter);
		}
		truckService.save(form);
		status.setComplete();
		return "redirect:/admin/truck"+getParams(pageable, filter);
	}
}
