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
	
	@RequestMapping(value="/saveImage", method=RequestMethod.POST)
	public String saveImage(@RequestParam(value="url[]", required= false) String[] url, @RequestParam(value="name[]", required= false) String[] name,
			@RequestParam(value="latitude[]", required= false) String[] latitude, @RequestParam(value="longitude[]", required= false) String[] longitude, Model model){
		
		ArrayList<SavedMountain> mountains=new ArrayList<SavedMountain>();
		SavedMountain mountain=new SavedMountain();
		for(int i=0; i<url.length; i++){
			mountain.setLatitude(latitude[i]);
			mountain.setLongitude(longitude[i]);
			mountain.setName(name[i]);
			mountain.setUrl(url[i]);
			mountains.add(mountain);
			System.out.println(name[i]+" "+url[i]+" "+latitude[i]+" "+longitude[i]);
		}
		sms.saveMountains(mountains);
		return "index";
	}

}
