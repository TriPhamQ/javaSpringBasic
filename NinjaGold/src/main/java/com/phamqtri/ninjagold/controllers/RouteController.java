package com.phamqtri.ninjagold.controllers;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.phamqtri.ninjagold.models.LootModel;

@Controller
public class RouteController {
	LootModel lootHistory = new LootModel();
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);			
		}
		return "index";
	}
	@RequestMapping(path="/", method=RequestMethod.POST)
	public String raid(@RequestParam(value="place") String place, HttpSession session, Model model) {
		int raidLoot = 0;
		switch (place) {
			case "farm":
				raidLoot = (int) Math.floor(Math.random() * (21 - 10)) + 10;
				break;
			case "cave":
				raidLoot = (int) Math.floor(Math.random() * (11 - 5)) + 5;
				break;
			case "house":
				raidLoot = (int) Math.floor(Math.random() * (6 - 2)) + 2;
				break;
			case "casino":
				if (Math.random() >= 0.5) {
					raidLoot = (int) Math.floor(Math.random() * 51);
				}
				else {
					raidLoot = (int) Math.floor(-Math.random() * 51);
				}
				break;
		
			default:
				break;
		}
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		else {
			session.setAttribute("loot", raidLoot);
			session.setAttribute("place", place);
			session.setAttribute("gold", Integer.parseInt(session.getAttribute("gold").toString()) + raidLoot);
			String[] addHistory = new String[2];
			addHistory[0] = place;
			addHistory[1] = session.getAttribute("gold").toString();
			this.lootHistory.add(addHistory);
			for (String[] loot : this.lootHistory.getLootHistory()) {
				System.out.println(Arrays.toString(loot));
			}
			model.addAttribute("history", this.lootHistory.getLootHistory());
			session.setAttribute("history", this.lootHistory.getLootHistory());
		}
		return "index";
	}
	
}
