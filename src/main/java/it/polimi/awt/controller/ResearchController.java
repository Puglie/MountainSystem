package it.polimi.awt.controller;

import it.polimi.awt.domain.Mountain;
import it.polimi.awt.service.FillMountainService;
import it.polimi.awt.service.MountainService;
import it.polimi.awt.service.ResearchService;
import it.polimi.awt.service.StringValidationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.flickr4java.flickr.FlickrException;



@Controller
@SessionAttributes
public class ResearchController {
	@Autowired
	ResearchService rsi;
	@Autowired
	StringValidationService svsi;
	@Autowired
	MountainService ms;
	@Autowired
	FillMountainService fmi;
	
	@RequestMapping("/mountainResearch")
	public String mountainResearch(Model model){
		
		model.addAttribute("command", new Mountain());
		return "mountainResearch";
	}
	
	@RequestMapping(value="/resultView", method=RequestMethod.POST)
	public String databaseResult(Mountain research, Model model) throws FlickrException{
		if(svsi.validMountain(research, ms.findAll())){
			research=fmi.getMountain(research, ms.findAll());
			model.addAttribute("mountain", rsi.getSavedMountain(research));
			return "resultView";
		}else{
			model.addAttribute("command", new Mountain());
			return "mountainResearch";
		}
		
	}
	
	
	@RequestMapping(value="/map")
	public String map(Model model){
		return "map";
	}

}
