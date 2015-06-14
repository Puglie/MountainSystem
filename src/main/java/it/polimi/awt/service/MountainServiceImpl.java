package it.polimi.awt.service;

import it.polimi.awt.domain.Mountain;
import it.polimi.awt.repository.MountainRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MountainServiceImpl implements MountainService{
	
	@Autowired
	private MountainRepository mountainRepository;

	@Override
	public List<Mountain> findAll() {
		return mountainRepository.findAll();
	}

	@Override
	public Mountain findByName(String name) {
		return mountainRepository.findByName(name);
	}

}
