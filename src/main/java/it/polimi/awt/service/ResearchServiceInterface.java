package it.polimi.awt.service;

import it.polimi.awt.model.Research;

import java.util.ArrayList;

import com.flickr4java.flickr.FlickrException;

public interface ResearchServiceInterface {
	
	ArrayList<String> getUrl(Research research) throws FlickrException;

}
