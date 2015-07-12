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
	
	/*This method handles the part about new Research of the users.
	 *It adds to the model a new object Mountain for automatically binding the forms to the object.
	 *Finally, it returns mountainResearch view.
	 */
	@RequestMapping("/mountainResearch")
	public String mountainResearch(Model model){
		
		model.addAttribute("command", new Mountain());
		return "mountainResearch";
	}
	
	/*This method handles the part about the results of the research. We have three cases.
	 * 1- The name inserted by the user is present within the database, so it return a list of photos by Flickr.
	 * 2- The name inserted by the user is a part of a name present within the database, so it return a list of possible mountains.
	 * 	  Then, the user has the possibility to click on a mountain and the system will return a list of photos by Flickr.
	 * 3- The name is not present within the database, so the system will remain on the reserach page and the user has the
	 * 	  possibility to insert another name. 
	 * 
	 */
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
