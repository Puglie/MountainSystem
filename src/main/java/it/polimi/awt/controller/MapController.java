package it.polimi.awt.controller;

import it.polimi.awt.domain.Mountain;
import it.polimi.awt.domain.SavedPhoto;
import it.polimi.awt.service.SavedMountainService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {

	@Autowired
	private SavedMountainService sms;

	@RequestMapping(value = "/map")
	public String getMap(Model model) {
		List<List<SavedPhoto>> mountainMatrix;
		mountainMatrix = sms.findAllMountainAndSavedMountain();
		model.addAttribute("mountainMatrix", mountainMatrix);
		model.addAttribute("command", new Mountain());
		return "map";
	}
	
	@RequestMapping("/index")
	public String getIndex(){
		return "index";
	}

}
