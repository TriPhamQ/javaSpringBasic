package com.phamqtri.driverlicense.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/licenses")
public class LicensesController {
	@RequestMapping("/new")
	public String newLicense() {
		return "newLicense";
	}
}
