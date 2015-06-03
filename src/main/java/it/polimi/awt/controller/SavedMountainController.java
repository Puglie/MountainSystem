package it.polimi.awt.controller;

import it.polimi.awt.domain.ListSavedMountain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes
public class SavedMountainController {
	
	@RequestMapping(value="/saveImage", method=RequestMethod.POST)
	public String saveImage(ListSavedMountain mountain){
		

	    
		
		return "index";
	}

}
