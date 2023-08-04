package com.midominio.biblioteca.web.app.model.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.midominio.biblioteca.web.app.model.entity.Libro;

public interface ILibroService {
	
	List<Libro> findAll();
	Page<Libro> listar(Pageable pageable);
	void save(Libro libro);
	Libro findOne(Long id);	
	void delete(Long id);

}
