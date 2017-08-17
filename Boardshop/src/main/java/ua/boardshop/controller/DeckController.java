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
import ua.boardshop.entity.Deck;
import ua.boardshop.service.DeckService;
import ua.boardshop.validator.DeckValidator;

@Controller
@RequestMapping("/admin/deck")
@SessionAttributes("deck")
public class DeckController {

	@Autowired
	private DeckService deckService;
	
	@InitBinder("deck")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new DeckValidator(deckService));
	}

	@ModelAttribute("deck")
	public Deck getForm(){
		return new Deck();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", deckService.findAll(filter, pageable));
		return "admin-deck";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		deckService.delete(id);
		return "redirect:/admin/deck"+getParams(pageable, filter);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("deck", deckService.findOne(id));
		model.addAttribute("decks", deckService.findAll());
		return show(model, pageable, filter);
	}
	
	@RequestMapping("/cancel")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/deck";
	}
	
	@PostMapping
	public String save(@ModelAttribute("deck")@Valid Deck form, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", deckService.findAll());
			return show(model, pageable, filter);
		}
		deckService.save(form);
		status.setComplete();
		return "redirect:/admin/deck"+getParams(pageable, filter);
	}
}
