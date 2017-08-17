package ua.boardshop.controller;

import javax.validation.Valid;
import static ua.boardshop.service.utils.ParamBuilder.getParams;

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
import ua.boardshop.entity.Producer;
import ua.boardshop.service.ProducerService;
import ua.boardshop.validator.ProducerValidator;

@Controller
@RequestMapping("/admin/producer")
@SessionAttributes("producer")
public class ProducerController {

	@Autowired
	private ProducerService producerService;
	
	@InitBinder("producer")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ProducerValidator(producerService));
	}
	
	@ModelAttribute("producer")
	public Producer getForm(){
		return new Producer();
	} 
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", producerService.findAll(filter, pageable));
		return "admin-producer";
	}
	
	@RequestMapping("/delete/{id}")
	// @PathVariable (id з інпута форми буде автоматично підставлено в атрибут метода delete)  
	public String delete(@PathVariable Long id, @ModelAttribute("filter") BasicFilter filter, @PageableDefault Pageable pageable){
		producerService.delete(id);
		return "redirect:/admin/producer"+getParams(pageable, filter);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, @ModelAttribute("filter") BasicFilter filter, Model model, @PageableDefault Pageable pageable){
		model.addAttribute("producer", producerService.findOne(id));
		model.addAttribute("producers", producerService.findAll());
		return show(model, pageable, filter);
	}
	
	@RequestMapping("/cancel")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/producer";
	}
	
	@PostMapping
	public String save(@ModelAttribute("producer")@Valid Producer form, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", producerService.findAll());
			return show(model, pageable, filter);
		}
		producerService.save(form);
		status.setComplete();
		return "redirect:/admin/producer"+getParams(pageable, filter);
	}
	
}
