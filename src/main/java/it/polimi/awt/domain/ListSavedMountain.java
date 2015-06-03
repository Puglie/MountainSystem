package it.polimi.awt.domain;

import java.util.ArrayList;
import java.util.List;

public class ListSavedMountain {
	
	private ArrayList<SavedMountain> mountains;
	
	public ListSavedMountain(){
		mountains=new ArrayList<SavedMountain>();
	}

	public List<SavedMountain> getMountains() {
		return mountains;
	}

	public void setMountains(ArrayList<SavedMountain> mountains) {
		this.mountains = mountains;
	}
	
	

}
