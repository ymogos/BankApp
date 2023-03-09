package com.YohannesApp.BankApplication.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.YohannesApp.BankApplication.model.Account;
import com.YohannesApp.BankApplication.model.User;
import com.YohannesApp.BankApplication.service.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	/*@GetMapping("/")
	public String homePage(Model model) {
	 
		return "index";
	}*/
	@GetMapping("/createNewUser")
	public String createNewUser(Model model) {
	 //create model attribute to bind form data
		User user = new User();
		model.addAttribute("user", user);
		return "new_user";
	}
	@PostMapping("/createUser")
	public String saveUser(@ModelAttribute("user") User user) {
	//save employee to database
		user.setAccounts(null);
		userService.saveUser(user);
		
		return "redirect:/";
	}
	
	
	/*
	 * @GetMapping("/") public String Home(Model model) { //create model attribute
	 * to bind form data //User user = new User(); //model.addAttribute("user",
	 * user); return "index"; }
	 */
	@GetMapping("/")
	public String logIn(Model model) {
		 //create model attribute to bind form data
			User user = new User();
			model.addAttribute("user", user);
			return "login";
		}
	
	
	@PostMapping("/login")
	public String logInpost(@ModelAttribute("user") User user,HttpSession session) {
	 //create model attribute to bind form data
		User Us = userService.login(user);
		session.setAttribute("user", Us);
		//RedirectView redirectView = new RedirectView();
		//redirectView.setUrl("/accounts/account");
		return "redirect:/accounts/account";
	}
	
	
}
