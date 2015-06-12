package it.polimi.awt.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import it.polimi.awt.domain.Mountain;
import it.polimi.awt.domain.SavedMountain;

@Repository
public class JpaSaveMountainRepository implements SaveMountainRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void saveMountain(ArrayList<SavedMountain> mountains) {
		for (SavedMountain mountain : mountains) {
			em.persist(mountain);
			em.close();
		}
	}

	@Override
	public List<SavedMountain> findAll() {
		TypedQuery<SavedMountain> query = em.createQuery(
				"Select b from SavedMountain b", SavedMountain.class);
		return query.getResultList();
	}

	@Override
	public List<List<SavedMountain>> findByName() {
		List<List<SavedMountain>> mountains = new ArrayList<List<SavedMountain>>();
		TypedQuery<String> query = em.createQuery(
				"Select distinct b.mountain.name from SavedMountain b",
				String.class);
		int i=0;
		for (String mountain : query.getResultList()) {
			mountains.add(new ArrayList<SavedMountain>());
			TypedQuery<SavedMountain> queryByName = em.createQuery(
					"Select b from SavedMountain b where b.mountain.name='"
							+ mountain + "'", SavedMountain.class);
			for (SavedMountain savedMountain : queryByName.getResultList()) {
				mountains.get(i).add(savedMountain);
			}
			i++;
		}

		return mountains;
	}
}
