package it.polimi.awt.service;

import it.polimi.awt.domain.Mountain;
import it.polimi.awt.domain.SavedMountain;
import it.polimi.awt.repository.SaveMountainRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.SearchParameters;

@Service
public class ResearchServiceImpl implements ResearchService {
	
	@Autowired
	private SaveMountainRepository smr;

	@Override
	public ArrayList<SavedMountain> getSavedMountain(Mountain research)
			throws FlickrException {
		String apiKey = "033e35849e5c7266413f18c0e18d0700";
		String sharedSecret = "21bec8e11859220e";
		// Create a Flickr instance with your data. No need to authenticate
		Flickr flickr = new Flickr(apiKey, sharedSecret, new REST());

		// Set the wanted search parameters (I'm not using real variables in the
		// example)
		SearchParameters searchParameters = new SearchParameters();
		searchParameters.setText(research.getName());
		;
		/*
		 * searchParameters.setLatitude("46.53");
		 * searchParameters.setLongitude("10.52");
		 */

		PhotoList<Photo> list = flickr.getPhotosInterface().search(searchParameters, 230, 2);
		ArrayList<String> url = new ArrayList<String>();
		ArrayList<SavedMountain> mountains = new ArrayList<SavedMountain>();
		Photo photo = null;
		Iterator<Photo> photoIterator = list.iterator();
		while (photoIterator.hasNext()) {
			photo = (Photo) photoIterator.next();
			SavedMountain s = new SavedMountain();
			/*s.getMountain().setLatitude(research.getLatitude_decimal());
			s.getMountain().setLongitude(research.getLongitude_decimal());*/
			s.setUrl(photo.getMediumUrl());
			s.setSmallurl(photo.getSmallUrl());
			//s.getMountain().setName(research.getName());
			if(!mountainAlreadySaved(s.getUrl(), smr.findAll())){
				mountains.add(s);
				url.add(photo.getLargeUrl());
			}
			
			// System.out.println(i + " - Description: " + photo.getSmallUrl());

		}
		return mountains;
	}

	@Override
	public boolean mountainAlreadySaved(String url, List<SavedMountain> mountains) {
		boolean isPresent=false;
		for(SavedMountain mountain : mountains){
			if(mountain.getUrl().equals(url)){
				isPresent=true;
			}
		}
		return isPresent;
	}
	
	public Boolean validMountain(Mountain research, List<Mountain> mountains) {
		Mountain mountain;
		boolean isPresent=false;
		Iterator<Mountain> iterator = mountains.iterator();
	    while (iterator.hasNext()) {
	        mountain = (Mountain) iterator.next();
	       // if(research.getName().toUpperCase()..equals(mountain.getName().toUpperCase())){
	        if(mountain.getName().toUpperCase().contains(research.getName().toUpperCase())){
	        	isPresent=true;
	        	
	        }
	    }
		return isPresent;
	}

}
