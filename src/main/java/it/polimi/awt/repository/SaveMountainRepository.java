package it.polimi.awt.repository;

import java.util.ArrayList;
import java.util.List;

import it.polimi.awt.domain.SavedMountain;

public interface SaveMountainRepository {
	
	void saveMountain(ArrayList<SavedMountain> mountain);
	List<SavedMountain> findAll();
	List<List<SavedMountain>> findAllMountainAndSavedMountain();

}
