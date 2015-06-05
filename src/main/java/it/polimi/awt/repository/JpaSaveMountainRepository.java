package it.polimi.awt.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import it.polimi.awt.domain.SavedMountain;

@Repository
public class JpaSaveMountainRepository implements SaveMountainRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void saveMountain(ArrayList<SavedMountain> mountains) {
        for(SavedMountain mountain : mountains){
        	em.persist(mountain);
        	em.close();
        }
	}

	@Override
	public List<SavedMountain> findAll() {
		TypedQuery<SavedMountain> query= em.createQuery("Select b from SavedMountain b", SavedMountain.class);
		return query.getResultList();
	}

}
