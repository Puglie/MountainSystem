package it.polimi.awt.controller;

import it.polimi.awt.domain.SavedMountain;
import it.polimi.awt.service.SavedMountainService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes
public class SavedMountainController {

	@Autowired
	private SavedMountainService sms;

	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public String saveImage(
			@RequestParam(value = "url[]", required = false) String[] url,
			@RequestParam(value = "smallurl[]", required = false) String[] smallurl,
			@RequestParam(value = "name", required = false) String name,
			Model model) {
		ArrayList<SavedMountain> mountains = new ArrayList<SavedMountain>();
		for (int i = 0; i < url.length; i++) {
			SavedMountain mountain = new SavedMountain();
			mountain.setMountain(sms.getMountain(name));
			mountain.setUrl(url[i]);
			mountain.setSmallurl(smallurl[i]);
			mountains.add(mountain);
			System.out.println(mountain.getMountain().getName() + " " + url[i] + " " + mountain.getMountain().getLatitude() + " "
					+ mountain.getMountain().getLongitude());
		}
		sms.saveMountains(mountains);
		return "redirect:/map";
	}

}
