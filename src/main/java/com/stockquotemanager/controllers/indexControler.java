package com.stockquotemanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexControler {
	@RequestMapping("/W")
	public String index(){
		return "index";
	}
	

}
