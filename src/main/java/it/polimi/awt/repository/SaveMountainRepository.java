package it.polimi.awt.repository;

import java.util.ArrayList;
import java.util.List;

import it.polimi.awt.domain.SavedPhoto;

public interface SaveMountainRepository {
	
	void saveMountain(ArrayList<SavedPhoto> mountain);
	List<SavedPhoto> findAll();
	List<List<SavedPhoto>> findAllMountainAndSavedMountain();

}
