package ua.boardshop.controller;

import javax.validation.Valid;
import static ua.boardshop.service.utils.ParamBuilder.getParams;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
import ua.boardshop.dto.filter.ShopFilter;
import ua.boardshop.dto.form.CommodityForm;
import ua.boardshop.editor.CategoryEditor;
import ua.boardshop.editor.ColorEditor;
import ua.boardshop.editor.DeckEditor;
import ua.boardshop.editor.ProducerEditor;
import ua.boardshop.editor.TruckEditor;
import ua.boardshop.editor.WheelEditor;
import ua.boardshop.entity.Category;
import ua.boardshop.entity.Color;
import ua.boardshop.entity.Commodity;
import ua.boardshop.entity.Deck;
import ua.boardshop.entity.Producer;
import ua.boardshop.entity.Truck;
import ua.boardshop.entity.User;
import ua.boardshop.entity.Wheel;
import ua.boardshop.service.CategoryService;
import ua.boardshop.service.ColorService;
import ua.boardshop.service.CommodityService;
import ua.boardshop.service.DeckService;
import ua.boardshop.service.ProducerService;
import ua.boardshop.service.TruckService;
import ua.boardshop.service.UserService;
import ua.boardshop.service.WheelService;
import ua.boardshop.validator.CommodityValidator;

@Controller
@RequestMapping("/admin/commodity")
@SessionAttributes("commodity")
public class CommodityController {

	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ColorService colorService;
	
	@Autowired
	private DeckService deckService;
	
	@Autowired
	private TruckService truckService;
	
	@Autowired
	private WheelService wheelService;
	
	@InitBinder("commodity")
	protected void bind(WebDataBinder binder){
		binder.registerCustomEditor(Producer.class, new ProducerEditor(producerService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
		binder.registerCustomEditor(Deck.class, new DeckEditor(deckService));
		binder.registerCustomEditor(Truck.class, new TruckEditor(truckService));
		binder.registerCustomEditor(Wheel.class, new WheelEditor(wheelService));
		binder.setValidator(new CommodityValidator(commodityService));
	}
	
	@ModelAttribute("commodity")
	public CommodityForm getForm(){
		return new CommodityForm(); 
	}
	
	@ModelAttribute("filter")
	public BasicFilter getBasicFilter(){
		return new BasicFilter();
	}
	
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", commodityService.findAll(filter, pageable));
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("decks", deckService.findAll());
		model.addAttribute("trucks", truckService.findAll());
		model.addAttribute("wheels", wheelService.findAll());
		return "admin-commodity";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("commodity", commodityService.findForm(id));
		model.addAttribute("commodities", commodityService.findAll());
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("decks", deckService.findAll());
		model.addAttribute("trucks", truckService.findAll());
		model.addAttribute("wheels", wheelService.findAll());
		return show(model, pageable, filter);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		commodityService.delete(id);
		return "redirect:/admin/commodity"+getParams(pageable, filter);
	}
	
	@RequestMapping("/cancel")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/commodity";
	}
	
	@PostMapping
	public String save(@ModelAttribute("commodity")@Valid CommodityForm form, BindingResult br, Model model, @PageableDefault Pageable pageable, SessionStatus status, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", commodityService.findAll(filter,pageable));
			model.addAttribute("producers", producerService.findAll());
			model.addAttribute("categories", categoryService.findAll());
			model.addAttribute("colors", colorService.findAll());
			model.addAttribute("decks", deckService.findAll());
			model.addAttribute("trucks", truckService.findAll());
			model.addAttribute("wheels", wheelService.findAll());
			return show(model, pageable, filter);
		}
		commodityService.save(form);
		status.setComplete();
		return "redirect:/admin/commodity"+getParams(pageable, filter);
	}
	
}
