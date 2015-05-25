package it.polimi.awt.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;












import javax.swing.text.Element;
import javax.xml.transform.Source;

import it.polimi.awt.domain.Mountain;
import it.polimi.awt.service.ResearchServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.DOMException;

import java.awt.image.BufferedImage;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.SearchParameters;
import com.sun.corba.se.impl.orbutil.graph.Node;



@Controller
@SessionAttributes
public class ResearchController {
	@Autowired
	ResearchServiceInterface rsi;
	
	@RequestMapping("/mountainResearch")
	public String mountainResearch(Model model){
		
		model.addAttribute("command", new Mountain());
		return "mountainResearch";
	}
	
	@RequestMapping(value="/resultView", method=RequestMethod.POST)
	public String databaseResult(Mountain research, Model model) throws FlickrException{
		
	    
	    model.addAttribute("url", rsi.getUrl(research));
		
		return "resultView";
		
	}
	
	/*@RequestMapping("/addMountain")
	public String addMountain(Research research){
		
	}*/

}
