package it.polimi.awt.service;

import it.polimi.awt.domain.Mountain;
import it.polimi.awt.domain.SavedMountain;
import it.polimi.awt.repository.MountainRepository;
import it.polimi.awt.repository.SaveMountainRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SavedMountainServiceImpl implements SavedMountainService {

	@Autowired
	private SaveMountainRepository smr;
	@Autowired
	private MountainRepository mr;

	@Override
	public void saveMountains(ArrayList<SavedMountain> mountains) {
		//for (SavedMountain mountain : mountains) {
			smr.saveMountain(mountains);
		//}

	}

	@Override
	public List<SavedMountain> getMountains() {
		return smr.findAll();
	}
	
	public Mountain getMountain(String name){
		return mr.findMountain(name);
	}

	@Override
	public List<List<SavedMountain>> findAllMountainAndSavedMountain() {
		
		return smr.findAllMountainAndSavedMountain();
	}

}
