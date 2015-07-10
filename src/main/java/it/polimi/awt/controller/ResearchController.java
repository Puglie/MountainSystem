package it.polimi.awt.controller;

import java.util.List;

import it.polimi.awt.domain.Mountain;
import it.polimi.awt.domain.SavedPhoto;
import it.polimi.awt.service.FillMountainService;
import it.polimi.awt.service.MountainService;
import it.polimi.awt.service.ResearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flickr4java.flickr.FlickrException;



@Controller
public class ResearchController {
	@Autowired
	private ResearchService rs;
	@Autowired
	private MountainService ms;
	@Autowired
	private FillMountainService fmi;
	
	@RequestMapping("/mountainResearch")
	public String mountainResearch(Model model){
		
		model.addAttribute("command", new Mountain());
		return "mountainResearch";
	}
	
	@RequestMapping(value="/resultView", method=RequestMethod.POST)
	public String researchResult(Mountain research, Model model, @RequestParam(value="research", required=false) String mont) throws FlickrException{
		if(mont==null){
			if(rs.validMountain(research, ms.findAll())){
				research=fmi.getMountain(research, ms.findAll());
				List<SavedPhoto> savedMountain= rs.getSavedMountain(research);
				if(savedMountain.size()==0){
					return "photoNotFound";
				}else{
					model.addAttribute("mountain", savedMountain);
					model.addAttribute("research", research);
					System.out.println(savedMountain.size()+" ");
					return "resultView";
				}
			}else if(rs.containedMountain(research, ms.findAll())){
				model.addAttribute("correctmountain", rs.findListMountain(research));
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
				model.addAttribute("mountain", savedMountain);
				model.addAttribute("research", research);
				System.out.println(savedMountain.size()+" ");
				return "resultView";
			}
		}
		
		
	}

}
