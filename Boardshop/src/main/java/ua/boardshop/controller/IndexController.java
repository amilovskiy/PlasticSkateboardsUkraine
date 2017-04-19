package ua.boardshop.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.boardshop.entity.User;
import ua.boardshop.service.UserService;
import ua.boardshop.validator.RegistrationValidator;

@Controller
@SessionAttributes("user")
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@InitBinder("user")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new RegistrationValidator(userService));
	}
	
	@ModelAttribute("user")
	public User getForm(){
		return new User(); 
	}
	
	@RequestMapping("/")
	public String index(Principal principal){
		if(principal!=null){
			System.out.println(principal.getName());
		}
		return "user-index";
	}
	
	@GetMapping("/registration")
	public String registration(Model model){
		model.addAttribute("user", new User());
		return "user-registration";
	}
	
	@PostMapping("/registration")
	public String save(@ModelAttribute("user")@Valid User user, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()) return "user-registration";
		userService.save(user);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login(){
		return "user-login";
	}
}