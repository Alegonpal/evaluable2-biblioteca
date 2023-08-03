package com.midominio.biblioteca.web.app.model.service;

import java.util.List;

import com.midominio.biblioteca.web.app.model.entity.Usuario;

public interface IUsuarioService {
	
	List<Usuario> findAll();
	void save(Usuario usuario);
	Usuario findOne(Long id);	
	void delete(Long id);
}
