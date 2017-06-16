package com.phamqtri.displaydate.controllers;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {
	SimpleDateFormat date = new SimpleDateFormat("EEEEEEE, 'the' dd 'of' MMMMMM, yyyy");
	SimpleDateFormat time = new SimpleDateFormat("HH:mm aaa");
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		model.addAttribute("date", date.format(new java.util.Date()));
		return "date";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		model.addAttribute("time", time.format(new java.util.Date()));
		return "time";
	}
}
