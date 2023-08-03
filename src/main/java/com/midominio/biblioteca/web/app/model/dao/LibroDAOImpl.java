package com.midominio.biblioteca.web.app.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

import com.midominio.biblioteca.web.app.model.entity.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class LibroDAOImpl /*implements ILibroDAO*/ {

	@PersistenceContext
	private EntityManager em;

	// @Transactional(readOnly = true)
	// @Override
	public List<Libro> findAll() {

		return em.createQuery("from Libro", Libro.class).getResultList();
	}

	// @Override
	// @Transactional
	public void save(Libro libro) {

		if (libro.getId() != null && libro.getId() > 0)
			// Actualiza
			em.merge(libro);
		else
			// Inserta
			em.persist(libro);

	}

	// @Override
	// @Transactional(readOnly = true)
	public Libro findOne(Long id) {
		return em.find(Libro.class, id);
	}
	
	// @Override
	 // @Transactional
		public void delete(Long id) {
			em.remove(findOne(id));
		}

}
