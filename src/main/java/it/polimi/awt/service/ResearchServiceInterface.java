package it.polimi.awt.service;

import java.util.ArrayList;
import it.polimi.awt.domain.Mountain;
import it.polimi.awt.domain.SavedMountain;

import com.flickr4java.flickr.FlickrException;

public interface ResearchServiceInterface {
	
	ArrayList<SavedMountain> getSavedMountain(Mountain research) throws FlickrException;

}
