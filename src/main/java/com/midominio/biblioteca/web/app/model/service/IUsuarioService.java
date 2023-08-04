package com.midominio.biblioteca.web.app.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.midominio.biblioteca.web.app.model.entity.Usuario;

public interface IUsuarioService {
	
	List<Usuario> findAll();
	Page<Usuario> listar(Pageable pageable);
	void save(Usuario usuario);
	Usuario findOne(Long id);	
	void delete(Long id);
}
