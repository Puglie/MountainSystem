package it.polimi.awt.service;

import it.polimi.awt.domain.SavedMountain;
import it.polimi.awt.repository.SaveMountainRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SavedMountainServiceImpl implements SavedMountainService {

	@Autowired
	private SaveMountainRepository smr;

	@Override
	public void saveMountains(ArrayList<SavedMountain> mountains) {
		//for (SavedMountain mountain : mountains) {
			smr.saveMountain(mountains);
		//}

	}

}
