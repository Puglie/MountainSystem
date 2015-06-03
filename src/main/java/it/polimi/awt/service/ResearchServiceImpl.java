package it.polimi.awt.service;

import it.polimi.awt.domain.ListSavedMountain;
import it.polimi.awt.domain.Mountain;
import it.polimi.awt.domain.SavedMountain;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photos.SearchParameters;

@Service
public class ResearchServiceImpl implements ResearchServiceInterface{

	@Override
	public ListSavedMountain getSavedMountain(Mountain research) throws FlickrException {
		String apiKey = "033e35849e5c7266413f18c0e18d0700";
		String sharedSecret = "21bec8e11859220e";
		// Create a Flickr instance with your data. No need to authenticate
	    Flickr flickr = new Flickr(apiKey, sharedSecret, new REST());

	    // Set the wanted search parameters (I'm not using real variables in the example)
	    SearchParameters searchParameters = new SearchParameters();
	    searchParameters.setText(research.getName());;
	   /* searchParameters.setLatitude("46.53");
	    searchParameters.setLongitude("10.52");*/

	    PhotoList<Photo> list = flickr.getPhotosInterface().search(searchParameters, 0, 0);
	    ArrayList<String> url=new ArrayList<String>();
	    ListSavedMountain mountains=new ListSavedMountain();
		int i=0;
		Photo photo=null;
	    Iterator photoIterator = list.iterator();
	    while (photoIterator.hasNext()) {
	        i++;
	        photo = (Photo) photoIterator.next();
	        SavedMountain s=new SavedMountain();
	        s.setUrl(photo.getSmallUrl());
	        s.setName(research.getName());
	        mountains.getMountains().add(s);
	        url.add(photo.getSmallUrl());
	    //    System.out.println(i + " - Description: " + photo.getSmallUrl());

	    }	
	    Iterator urlIt=url.iterator();
	    String urlS=null;
	    while(urlIt.hasNext()){
	    	urlS=urlIt.next().toString();
	    //	System.out.println(urlS);
	    }
		//return url;
	    return mountains;
	}

}
