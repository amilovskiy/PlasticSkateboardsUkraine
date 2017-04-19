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

import ua.boardshop.dto.filter.BasicFilter;
import ua.boardshop.editor.CommodityEditor;
import ua.boardshop.entity.Commodity;
import ua.boardshop.service.CommodityService;

@Controller
@RequestMapping("/user/shop/productList/notUser")
@SessionAttributes("productList")
public class ProductListNotUserController {

	@Autowired
	private CommodityService commodityService;
	
	@InitBinder("productList")
	protected void bind(WebDataBinder binder) {
		binder.registerCustomEditor(Commodity.class, new CommodityEditor(commodityService));
	}
	
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("commodities", commodityService.findAll(id));
		return "user-productList";
	}
	
}
