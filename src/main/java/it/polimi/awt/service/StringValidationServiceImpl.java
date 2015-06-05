package it.polimi.awt.service;

import it.polimi.awt.domain.Mountain;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class StringValidationServiceImpl implements StringValidationService{

	@Override
	public Boolean validMountain(Mountain research, List<Mountain> mountains) {
		Mountain mountain;
		boolean isPresent=false;
		Iterator<Mountain> iterator = mountains.iterator();
	    while (iterator.hasNext()) {
	        mountain = (Mountain) iterator.next();
	        if(research.getName().toUpperCase().equals(mountain.getName().toUpperCase())){
	        	isPresent=true;
	        	
	        }

	    }
		return isPresent;
	}

}
