package it.polimi.awt.repository;

import it.polimi.awt.domain.Mountain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class JpaMountainRepository implements MountainRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Mountain> findAll() {

		TypedQuery<Mountain> query = em.createQuery("Select b from Mountain b",
				Mountain.class);

		return query.getResultList();
	}

	public Mountain findMountain(String name) {
		TypedQuery<Mountain> query = em
				.createQuery("Select b from Mountain b where b.name='" + name + "'",
						Mountain.class);
		return query.getSingleResult();
	}

}
