package it.polimi.awt.service;

import it.polimi.awt.domain.Mountain;
import it.polimi.awt.domain.savedMountain;

import java.util.ArrayList;

import com.flickr4java.flickr.FlickrException;

public interface ResearchServiceInterface {
	
	ArrayList<savedMountain> getSavedMountain(Mountain research) throws FlickrException;

}
