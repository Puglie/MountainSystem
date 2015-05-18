package it.polimi.awt.controller;

import it.polimi.awt.model.Research;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes
public class ResearchController {
	
	@RequestMapping("/mountainResearch")
	public ModelAndView mountainResearch(){
		return new ModelAndView ("mountainResearch", "command", new Research());
	}
	
	@RequestMapping(value="/resultView", method=RequestMethod.POST)
	public ModelAndView databaseResult(@ModelAttribute("research") Research research, BindingResult result ){
		
		
		return new ModelAndView("resultView", "result", research);
		
	}
	
	/*@RequestMapping("/addMountain")
	public String addMountain(Research research){
		
	}*/

}
