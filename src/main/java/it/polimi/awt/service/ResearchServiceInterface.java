package it.polimi.awt.service;

import it.polimi.awt.domain.ListSavedMountain;
import it.polimi.awt.domain.Mountain;
import it.polimi.awt.domain.SavedMountain;

import java.util.ArrayList;

import com.flickr4java.flickr.FlickrException;

public interface ResearchServiceInterface {
	
	ListSavedMountain getSavedMountain(Mountain research) throws FlickrException;

}
