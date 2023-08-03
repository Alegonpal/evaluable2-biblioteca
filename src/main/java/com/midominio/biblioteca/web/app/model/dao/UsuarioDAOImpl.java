package com.midominio.biblioteca.web.app.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

import com.midominio.biblioteca.web.app.model.entity.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UsuarioDAOImpl /*implements IUsuarioDAO*/ {

	@PersistenceContext
	private EntityManager em;

	// @Transactional(readOnly = true)
	// @Override
	public List<Usuario> findAll() {

		return em.createQuery("from Usuario", Usuario.class).getResultList();
	}

	// @Override
	// @Transactional
	public void save(Usuario usuario) {

		if (usuario.getId() != null && usuario.getId() > 0)
			// Actualiza
			em.merge(usuario);
		else
			// Inserta
			em.persist(usuario);

	}

	// @Override
	// @Transactional(readOnly = true)
	public Usuario findOne(Long id) {
		return em.find(Usuario.class, id);
	}
	
	// @Override
	// @Transactional
		public void delete(Long id) {
			em.remove(findOne(id));
		}

}
