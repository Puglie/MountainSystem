package it.polimi.awt.controller;

import java.util.Iterator;

import it.polimi.awt.domain.ListSavedMountain;
import it.polimi.awt.domain.SavedMountain;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.flickr4java.flickr.photos.Photo;

@Controller
@SessionAttributes
public class SavedMountainController {
	
	@RequestMapping(value="/saveImage", method=RequestMethod.POST)
	public String saveImage(ListSavedMountain mountain){
		

	    
		
		return "index";
	}

}
