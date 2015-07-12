package it.polimi.awt.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import it.polimi.awt.domain.SavedPhoto;

@Repository
public class JpaSaveMountainRepository implements SaveMountainRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void saveMountain(ArrayList<SavedPhoto> mountains) {
		for (SavedPhoto mountain : mountains) {
			em.persist(mountain);
			em.close();
		}
	}

	@Override
	public List<SavedPhoto> findAll() {
		TypedQuery<SavedPhoto> query = em.createQuery(
				"Select b from SavedPhoto b", SavedPhoto.class);
		return query.getResultList();
	}

	@Override
	public List<List<SavedPhoto>> findAllMountainAndSavedMountain() {
		List<List<SavedPhoto>> mountains = new ArrayList<List<SavedPhoto>>();
		TypedQuery<String> query = em.createQuery(
				"Select distinct b.mountain.name from SavedPhoto b",
				String.class);
		int i=0;
		for (String mountain : query.getResultList()) {
			mountains.add(new ArrayList<SavedPhoto>());
			TypedQuery<SavedPhoto> savedPhotoByMountain = em.createQuery(
					"Select b from SavedPhoto b where b.mountain.name='"
							+ mountain + "'", SavedPhoto.class);
			for (SavedPhoto savedMountain : savedPhotoByMountain.getResultList()) {
				mountains.get(i).add(savedMountain);
			}
			i++;
		}

		return mountains;
	}
}
