package it.polimi.awt.controller;

import java.util.List;

import it.polimi.awt.domain.Mountain;
import it.polimi.awt.domain.SavedPhoto;
import it.polimi.awt.service.FillMountainService;
import it.polimi.awt.service.MountainService;
import it.polimi.awt.service.ResearchService;
import it.polimi.awt.service.ResearchServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.flickr4java.flickr.FlickrException;



@Controller
@SessionAttributes
public class ResearchController {
	@Autowired
	ResearchService rs;
	@Autowired
	MountainService ms;
	@Autowired
	FillMountainService fmi;
	@Autowired
	ResearchServiceImpl rsi;
	
	@RequestMapping("/mountainResearch")
	public String mountainResearch(Model model){
		
		model.addAttribute("command", new Mountain());
		return "mountainResearch";
	}
	
	@RequestMapping(value="/resultView", method=RequestMethod.POST)
	public String databaseResult(Mountain research, Model model, @RequestParam(value="research", required=false) String mont) throws FlickrException{
		if(mont==null){
			if(rsi.validMountain(research, ms.findAll())){
				research=fmi.getMountain(research, ms.findAll());
				List<SavedPhoto> savedMountain= rs.getSavedMountain(research);
				if(savedMountain.size()==0){
					return "photoNotFound";
				}else{
					model.addAttribute("mountain", rs.getSavedMountain(research));
					model.addAttribute("research", research);
					System.out.println(savedMountain.size()+" ");
					return "resultView";
				}
			}else if(rsi.containedMountain(research, ms.findAll())){
				model.addAttribute("correctmountain", rsi.findListMountain(research));
				return "showList";
			}else{
				model.addAttribute("command", new Mountain());
				return "mountainResearch";
			}
		}else{
			research=fmi.getMountain(ms.findByName(mont), ms.findAll());
			List<SavedPhoto> savedMountain= rs.getSavedMountain(research);
			if(savedMountain.size()==0){
				return "photoNotFound";
			}else{
				model.addAttribute("mountain", rs.getSavedMountain(research));
				model.addAttribute("research", research);
				System.out.println(savedMountain.size()+" ");
				return "resultView";
			}
		}
		
		
	}
	
	
/*	@RequestMapping(value="/map")
	public String map(Model model){
		return "map";
	}*/

}
