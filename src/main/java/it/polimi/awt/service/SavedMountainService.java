package it.polimi.awt.service;

import it.polimi.awt.domain.Mountain;
import it.polimi.awt.domain.SavedPhoto;

import java.util.ArrayList;
import java.util.List;

public interface SavedMountainService {
	
	void saveMountains (ArrayList<SavedPhoto>  mountains);
	List<SavedPhoto> getMountains();
	Mountain getMountain(String name);
	List<List<SavedPhoto>> findAllMountainAndSavedMountain();

}
