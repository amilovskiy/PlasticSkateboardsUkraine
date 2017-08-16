package ua.boardshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.boardshop.editor.CommodityEditor;
import ua.boardshop.entity.Commodity;
import ua.boardshop.service.CommodityService;

@Controller
@RequestMapping("/user/simple_product_page")
@SessionAttributes("productPage")
public class ProductPageNotUserController {

	@Autowired
	private CommodityService commodityService;
	
	@InitBinder("productPage")
	protected void bind(WebDataBinder binder) {
		binder.registerCustomEditor(Commodity.class, new CommodityEditor(commodityService));
	}
	
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model){
		model.addAttribute("commodity", commodityService.findOne(id));
		return "user-productPageNotUser";
	}
}
