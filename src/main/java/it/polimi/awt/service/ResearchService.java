package it.polimi.awt.service;

import java.util.ArrayList;
import java.util.List;

import it.polimi.awt.domain.Mountain;
import it.polimi.awt.domain.SavedPhoto;

import com.flickr4java.flickr.FlickrException;

public interface ResearchService {
	
	ArrayList<SavedPhoto> getSavedMountain(Mountain research) throws FlickrException;
	boolean mountainAlreadySaved (String url, List<SavedPhoto>mountains);
	List<Mountain> findListMountain(Mountain m);

}
