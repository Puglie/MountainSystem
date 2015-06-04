package it.polimi.awt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes
public class SavedMountainController {
	
	@RequestMapping(value="/saveImage", method=RequestMethod.POST)
	public String saveImage(@RequestParam(value="url[]", required= false) String[] url, @RequestParam(value="name[]", required= false) String[] name,
			@RequestParam(value="latitude[]", required= false) String[] latitude, @RequestParam(value="longitude[]", required= false) String[] longitude, Model model){
		
		for(int i=0; i<url.length; i++){
			if(url[i]==null){
				System.out.println("Ciao");
			}else{
				System.out.println(name[i]+" "+url[i]+" "+latitude[i]+" "+longitude[i]);
			}
		}
		return "index";
	}

}
