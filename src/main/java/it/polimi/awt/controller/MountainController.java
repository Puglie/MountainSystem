package it.polimi.awt.controller;

import java.util.List;

import it.polimi.awt.domain.Mountain;
import it.polimi.awt.service.MountainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MountainController {
	
	@Autowired
	private MountainService mountainService;
	
	@RequestMapping("/mountains")
	public String getAllMountain(Model model){
		List<Mountain> mountains=mountainService.findAll();
		model.addAttribute("mountains", mountains);
		
		return "mountains";
	}
	

}
