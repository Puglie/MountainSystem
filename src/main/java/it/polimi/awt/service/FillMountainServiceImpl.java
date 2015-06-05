package it.polimi.awt.service;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.polimi.awt.domain.Mountain;
import it.polimi.awt.service.FillMountainService;


@Service
@Transactional
public class FillMountainServiceImpl implements FillMountainService{

	@Override
	public Mountain getMountain(Mountain research, List<Mountain> mountains) {
		Mountain mountain;
		Iterator<Mountain> iterator = mountains.iterator();
	    while (iterator.hasNext()) {
	        mountain = (Mountain) iterator.next();
	        if(research.getName().toUpperCase().equals(mountain.getName().toUpperCase())){
	        	research.setElevation(mountain.getElevation());
	        	research.setIcon(mountain.getIcon());
	        	research.setLatitude(mountain.getLatitude());
	        	research.setLongitude(mountain.getLongitude());
	        	research.setLatitude_decimal(mountain.getLatitude_decimal());
	        	research.setLongitude_decimal(mountain.getLongitude_decimal());
	        	research.setProm(mountain.getProm());
	        	
	        }

	    }
		return research;
	}

}
