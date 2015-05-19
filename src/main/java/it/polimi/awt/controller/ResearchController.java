package it.polimi.awt.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;









import javax.swing.text.Element;
import javax.xml.transform.Source;

import it.polimi.awt.model.Research;

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
	
	@RequestMapping("/mountainResearch")
	public String mountainResearch(Model model){
		
		model.addAttribute("command", new Research());
		return "mountainResearch";
	}
	
	@RequestMapping(value="/resultView", method=RequestMethod.POST)
	public String databaseResult(Research research){
		
		
		return "resultView";
		
	}
	
	@RequestMapping("connect")
	public String connetcToFlickr(Model model) throws FlickrException{
		String apiKey = "033e35849e5c7266413f18c0e18d0700";
		String sharedSecret = "21bec8e11859220e";
		

	    // Create a Flickr instance with your data. No need to authenticate
	    Flickr flickr = new Flickr(apiKey, sharedSecret, new REST());

	    // Set the wanted search parameters (I'm not using real variables in the example)
	    SearchParameters searchParameters = new SearchParameters();
	    searchParameters.setText("Monte Bianco");;

	    PhotoList<Photo> list = flickr.getPhotosInterface().search(searchParameters, 0, 0);
	    ArrayList<String> url=new ArrayList<String>();
		int i=0;
		Photo photo=null;
	    Iterator photoIterator = list.iterator();
	    while (photoIterator.hasNext()) {
	        i++;
	        photo = (Photo) photoIterator.next();
	        url.add(photo.getSmallUrl());
	        System.out.println(i + " - Description: " + photo.getSmallUrl());

	    }	
	    Iterator urlIt=url.iterator();
	    String urlS=null;
	    while(urlIt.hasNext()){
	    	urlS=urlIt.next().toString();
	    	System.out.println(urlS);
	    }
	    
	    model.addAttribute("url", url);
		
		return "connect";
	}
	
	/*@RequestMapping("/addMountain")
	public String addMountain(Research research){
		
	}*/

}
