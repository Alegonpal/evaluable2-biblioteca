package com.midominio.biblioteca.web.app.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.midominio.biblioteca.web.app.model.entity.Usuario;

public interface IUsuarioDAO extends CrudRepository <Usuario, Long> {
//	List<Usuario> findAll();
//	void save (Usuario usuario);
//	Usuario findOne(Long id);
//	void delete(Long id);
}
