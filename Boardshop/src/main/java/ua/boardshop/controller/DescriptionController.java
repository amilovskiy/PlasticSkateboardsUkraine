package ua.boardshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.boardshop.editor.CategoryEditor;
import ua.boardshop.editor.ColorEditor;
import ua.boardshop.editor.ProducerEditor;
import ua.boardshop.entity.Category;
import ua.boardshop.entity.Color;
import ua.boardshop.entity.Commodity;
import ua.boardshop.entity.Producer;
import ua.boardshop.service.CategoryService;
import ua.boardshop.service.ColorService;
import ua.boardshop.service.CommodityService;
import ua.boardshop.service.ProducerService;

@Controller
@RequestMapping("/admin/commodity/description/{id}")
@SessionAttributes("description")
public class DescriptionController {
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ColorService colorService;
	
	@InitBinder("description")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Producer.class, new ProducerEditor(producerService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
	}
	
	@ModelAttribute("description")
	public Commodity getForm(){
		return new Commodity(); 
	}
	
	@GetMapping
	public String show(@PathVariable Long id, Model model){
		model.addAttribute("commodity", commodityService.findOne(id));
		return "admin-description";
	}
}