package com.Banking.BankManagement.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Banking.BankManagement.Entity.Details;
import com.Banking.BankManagement.Service.BankService;

@Controller
//@RequestMapping("/Bank")
public class BankController {
	@Autowired
	BankService BS;
	
	ModelAndView mv=new ModelAndView();
	
	@RequestMapping("/")
	public ModelAndView login() {
		mv.setViewName("index");
		return mv;
	}
	//Create New Account
	@RequestMapping("registration")
	ModelAndView registration() {
		mv.setViewName("registration");
		return mv;
		}

	
	@RequestMapping("check")
	public ModelAndView CheckAccount(Details detailsFromBrowser) {
		Details datailsFromdatabase=BS.AllList(detailsFromBrowser);
		if(datailsFromdatabase!=null) {	
			if(detailsFromBrowser.getPassword().equals(datailsFromdatabase.getPassword()))
			{
				mv.setViewName("welcome");
				mv.addObject("message", datailsFromdatabase.getName()); 
				}
			else
			{
				mv.setViewName("index");
				mv.addObject("message", "wrong password");
			}
			}
			else
			{
				mv.setViewName("index");
				mv.addObject("message", "Wrong Account Number or Password");
			}
			return mv;
			}

	// for Logout profile
	@RequestMapping("logout")
	public ModelAndView logout() {
		
		mv.addObject("message", "Logout Successful");
		mv.setViewName("index");
		return mv;
		
	}
	
	// For Registration
	@RequestMapping("savedata")
	public ModelAndView CreateAccount(Details details) {
		BS.CreateAccount(details);
		mv.addObject("message", "Registration Successful");
		mv.setViewName("index");
		return mv;
		
	}
	

	@RequestMapping("ProfileCheck")
	public ModelAndView ProfileCheck() {
		mv.setViewName("ProfileCheck");
		return mv;
	}
	
	@RequestMapping("Alldetail")
	public ModelAndView Alldetail(Details detailsFromBrowser){
		Details datailsFromdatabase=BS.AllList(detailsFromBrowser);
		List<Details>list=new ArrayList<>();

		if(detailsFromBrowser.getPassword().equals(datailsFromdatabase.getPassword()))
		{
			list.add(datailsFromdatabase);

			mv.setViewName("welcome");
			mv.addObject("data", list); 
			return mv;
			}
		else
		{
			mv.setViewName("welcome");
			mv.addObject("message", "wrong password");
			}
		return mv;
		}

}
