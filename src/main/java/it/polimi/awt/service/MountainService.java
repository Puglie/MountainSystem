package it.polimi.awt.service;

import it.polimi.awt.domain.Mountain;

import java.util.List;

public interface MountainService {
	
	public List<Mountain> findAll();
	public Mountain findByName(String name);

}
