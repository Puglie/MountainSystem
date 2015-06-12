package it.polimi.awt.service;

import it.polimi.awt.domain.Mountain;
import it.polimi.awt.domain.SavedMountain;

import java.util.ArrayList;
import java.util.List;

public interface SavedMountainService {
	
	void saveMountains (ArrayList<SavedMountain>  mountains);
	List<SavedMountain> getMountains();
	Mountain getMountain(String name);
	List<List<SavedMountain>> findAllMountainAndSavedMountain();

}
