package it.polimi.awt.service;

import java.util.List;

import it.polimi.awt.domain.Mountain;

public interface FillMountainService {
	
	Mountain getMountain(Mountain research, List<Mountain> mountains);

}
