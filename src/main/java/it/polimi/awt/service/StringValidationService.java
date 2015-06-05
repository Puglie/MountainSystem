package it.polimi.awt.service;

import java.util.List;

import it.polimi.awt.domain.Mountain;

public interface StringValidationService {
	
	Boolean validMountain(Mountain research, List<Mountain> mountains);
	
}

