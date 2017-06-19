package com.phamqtri.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {
	@RequestMapping("/")
	public String index(@RequestParam(value="q", required=false) String searchQuery, Model model) {
		if (searchQuery == null) {
			searchQuery = "Human";
		}
		model.addAttribute("q", searchQuery);
		return "index";
	}
}
