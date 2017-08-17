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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.boardshop.dto.filter.ShopFilter;
import ua.boardshop.editor.CategoryEditor;
import ua.boardshop.editor.ColorEditor;
import ua.boardshop.editor.DeckEditor;
import ua.boardshop.editor.ItemEditor;
import ua.boardshop.editor.ProducerEditor;
import ua.boardshop.editor.TruckEditor;
import ua.boardshop.editor.UserEditor;
import ua.boardshop.editor.WheelEditor;
import ua.boardshop.entity.Category;
import ua.boardshop.entity.Color;
import ua.boardshop.entity.Deck;
import ua.boardshop.entity.Item;
import ua.boardshop.entity.Producer;
import ua.boardshop.entity.Truck;
import ua.boardshop.entity.User;
import ua.boardshop.entity.Wheel;
import ua.boardshop.service.CategoryService;
import ua.boardshop.service.ColorService;
import ua.boardshop.service.CommodityService;
import ua.boardshop.service.DeckService;
import ua.boardshop.service.ItemService;
import ua.boardshop.service.ProducerService;
import ua.boardshop.service.TruckService;
import ua.boardshop.service.UserService;
import ua.boardshop.service.WheelService;

@Controller
@RequestMapping("/user/shop")
@SessionAttributes("shop")
public class ShopController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CommodityService commodityService;
	
	@Autowired
	private ColorService colorService;
	
	@Autowired
	private DeckService deckService;
	
	@Autowired
	private WheelService wheelService;
	
	@Autowired
	private TruckService truckService;
	
	@Autowired
	private ProducerService producerService;
	
//	@ModelAttribute("filter")
//	public BasicFilter getFilter(){
//		return new BasicFilter();
//	}
	
	@InitBinder("shop")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Item.class, new ItemEditor(itemService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
		binder.registerCustomEditor(Deck.class, new DeckEditor(deckService));
		binder.registerCustomEditor(Wheel.class, new WheelEditor(wheelService));
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
		binder.registerCustomEditor(Truck.class, new TruckEditor(truckService));
		binder.registerCustomEditor(Producer.class, new ProducerEditor(producerService));
		binder.registerCustomEditor(User.class, new UserEditor(userService));
	}
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ShopFilter filter){
		model.addAttribute("amount", userService.findAm(userService.getCurrentUser().getId()));
		model.addAttribute("items", itemService.findAll());
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("decks", deckService.findAll());
		model.addAttribute("wheels", wheelService.findAll());
		model.addAttribute("trucks", truckService.findAll());
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("page", commodityService.findAll(filter, pageable));
		return "user-shop";
	}
	
	@RequestMapping("/cancel")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/user/shop";
	}
	
	@GetMapping("{id}")
	public String showSelectCategory(@PathVariable Long id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ShopFilter filter){
		model.addAttribute("amount", userService.findAm(userService.getCurrentUser().getId()));
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("decks", deckService.findAll());
		model.addAttribute("wheels", wheelService.findAll());
		model.addAttribute("trucks", truckService.findAll());
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("page", commodityService.findAll(filter, pageable));
		model.addAttribute("items", itemService.findAll());
		model.addAttribute("commodities", commodityService.findAll(id));
		return "user-selectCategory";
	}
	
}
