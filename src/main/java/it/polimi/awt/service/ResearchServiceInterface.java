package it.polimi.awt.service;

import it.polimi.awt.domain.Mountain;

import java.util.ArrayList;

import com.flickr4java.flickr.FlickrException;

public interface ResearchServiceInterface {
	
	ArrayList<String> getUrl(Mountain research) throws FlickrException;

}
