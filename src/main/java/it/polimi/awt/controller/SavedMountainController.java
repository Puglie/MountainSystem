package it.polimi.awt.controller;

import it.polimi.awt.domain.Mountain;
import it.polimi.awt.domain.SavedPhoto;
import it.polimi.awt.service.FillMountainService;
import it.polimi.awt.service.MountainService;
import it.polimi.awt.service.ResearchService;
import it.polimi.awt.service.SavedMountainService;

import java.util.ArrayList;
import java.util.List;

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
public class SavedMountainController {

	@Autowired
	private SavedMountainService sms;
	@Autowired
	private ResearchService rs;
	@Autowired
	private FillMountainService fmi;
	@Autowired
	private MountainService ms;

	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	public String saveImage(
			@RequestParam(value = "url[]", required = false) String[] url,
			@RequestParam(value = "smallurl[]", required = false) String[] smallurl,
			@RequestParam(value = "name", required = false) String name,
			Model model) throws FlickrException {
		if(url == null){
		/*	Mountain research=new Mountain();
			research.setName(name);
			research=fmi.getMountain(research, ms.findAll());
			List<SavedPhoto> savedMountain= rs.getSavedMountain(research);
			model.addAttribute("mountain", savedMountain);
			model.addAttribute("research", research);
			return "resultView";*/
			return "redirect:/index";
			
		}else{
			ArrayList<SavedPhoto> mountains = new ArrayList<SavedPhoto>();
			for (int i = 0; i < url.length; i++) {
				SavedPhoto mountain = new SavedPhoto();
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

}
