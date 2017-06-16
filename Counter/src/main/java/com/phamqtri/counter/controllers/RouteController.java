package com.phamqtri.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouteController {
    @RequestMapping("/")
    public String index(HttpSession session) {
    	if(session.getAttribute("counter") == null) {
			session.setAttribute("counter", 1);
		}
    	else {
    		int current = Integer.parseInt(session.getAttribute("counter").toString()) + 1;
    		session.setAttribute("counter", current);
    	}
    	System.out.println(session.getAttribute("counter"));
		return "index";
    }
    @RequestMapping("/counter")
    public String counter(HttpSession session, Model model) {
    	model.addAttribute("counter", session.getAttribute("counter"));
    	return "counter";
    }
    @RequestMapping("/reset")
    public String reset(HttpSession session) {
    	session.setAttribute("counter", 0);
    	return "redirect:/";
    }
}
