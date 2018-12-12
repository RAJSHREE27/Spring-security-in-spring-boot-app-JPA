//public static String toString(JSON json)

package com.example.ex6.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.raj.ex6.utils.WebUtils;



@Controller
public class MainController {
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		
		 model.addAttribute("title", "Home");
	     model.addAttribute("message", "Home page!");
	     return "home";
	     
	}
	
	 @RequestMapping(value = "/hello", method = RequestMethod.GET)
	  public String hello(Model model, Principal principal) {
	 
	        String userId = principal.getName();
	 
	        System.out.println("User Name: " + userId);
	 
	        User loginedUser = (User) ((Authentication) principal).getPrincipal();
	 
	        String userData = WebUtils.toString(loginedUser);
	        model.addAttribute("user_data", userData);
	 
	        return "hello";
	    }
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	  public String loginPage(Model model) {
	 
	        return "login";
	 }
	 
	 
	 @RequestMapping(value = "/403", method = RequestMethod.GET)
	    public String accessDenied(Model model, Principal principal) {
	 
	        if (principal != null) {
	            User loginedUser = (User) ((Authentication) principal).getPrincipal();
	 
	            String userInfo = WebUtils.toString(loginedUser);
	 
	            model.addAttribute("userInfo", userInfo);
	 
	            String message = "Hi " + principal.getName() //
	                    + "<br> You do not have permission to access this page!";
	            model.addAttribute("message", message);
	 
	        }
	 
	        return "403page";
	    }
	 
}
