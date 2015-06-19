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
		List<SavedPhoto> mountains;
		mountains = sms.getMountains();
		List<List<SavedPhoto>> mountainMatrix;
		mountainMatrix = sms.findAllMountainAndSavedMountain();
		for (SavedPhoto mountain : mountains) {
			System.out.println(mountain.getMountain().getLatitude() + " "
					+ mountain.getMountain().getLongitude());
		}
		model.addAttribute("mountains", mountains);
		model.addAttribute("mountainMatrix", mountainMatrix);
		model.addAttribute("command", new Mountain());


		return "map";
	}
	
	@RequestMapping("/index")
	public String getIndex(){
		return "index";
	}

}
