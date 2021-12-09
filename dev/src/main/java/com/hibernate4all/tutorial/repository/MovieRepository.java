package com.hibernate4all.tutorial.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.hibernate4all.tutorial.domain.Movie;


@Repository
public class MovieRepository {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieRepository.class);
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void persist(Movie movie) {
		LOGGER.trace("entityManager.contains() : " + entityManager.contains(movie));
		// persist va faire passer movie dans la session
		entityManager.persist(movie);
		LOGGER.trace("entityManager.contains() : " + entityManager.contains(movie));
	}
	
	@Transactional
	public Movie find(Long id) {
		Movie result = entityManager.find(Movie.class, id);
		LOGGER.trace("entityManager.contains()" + entityManager.contains(result));
		return result;
	}
	
	public List<Movie> getAll(){
		//Request JPQL
		return entityManager.createQuery("from Movie", Movie.class).getResultList();
			
	}

	@Transactional
	public List<Movie> getAll2(){
		//Request JPQL
		return entityManager.createQuery("from Movie", Movie.class).getResultList();
			
	}
	
	@Transactional
	public List<Movie> getAll3(){
		//Request JPQL
		return entityManager.createQuery("from Movie", Movie.class).getResultList();
			
	}
	
}
