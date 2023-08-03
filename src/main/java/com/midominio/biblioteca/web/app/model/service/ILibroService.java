package com.midominio.biblioteca.web.app.model.service;

import java.util.List;

import com.midominio.biblioteca.web.app.model.entity.Libro;

public interface ILibroService {
	
	List<Libro> findAll();
	void save(Libro libro);
	Libro findOne(Long id);	
	void delete(Long id);

}
