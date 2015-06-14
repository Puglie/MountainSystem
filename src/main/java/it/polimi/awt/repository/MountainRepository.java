package it.polimi.awt.repository;

import it.polimi.awt.domain.Mountain;

import java.util.List;

public interface MountainRepository {
	
	List<Mountain> findAll();
	Mountain findMountain(String name);
	List<Mountain> findContainedMountain(Mountain m);
	Mountain findByName(String name);

}
