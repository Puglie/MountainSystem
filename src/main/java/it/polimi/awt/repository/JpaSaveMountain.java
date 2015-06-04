package it.polimi.awt.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import it.polimi.awt.domain.SavedMountain;

@Repository
public class JpaSaveMountain implements SaveMountainRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void saveMountain(SavedMountain mountain) {
		em.persist(mountain);
		
	}

}
