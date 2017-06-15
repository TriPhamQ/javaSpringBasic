package com.phamqtri.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {
	@RequestMapping("/")
	public String Home() {
		return "forward:/index.html";
	}
	@RequestMapping("/projects")
	public String projects() {
		return "forward:/views/projects.html";
	}
	@RequestMapping("/me")
	public String me() {
		return "forward:/views/me.html";
	}
}
