package org.hgu.controller;

import java.util.Locale;

import org.hgu.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class HomeController {
	@Setter(onMethod_ = @Autowired)
	private HomeService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.");
		
		// 커뮤니티 추천글
		model.addAttribute("list1", service.getList1());
		// Q&A 추천글
		model.addAttribute("list2", service.getList2());
		
		return "home";
	}

}