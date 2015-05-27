package it.polimi.awt.service;

import java.util.ArrayList;

import it.polimi.awt.domain.Mountain;

public interface StringValidationServiceInterface {
	
	ArrayList<Mountain> findAllMountains();
	Boolean validMountain(Mountain research, ArrayList<Mountain> mountains);
	
}

