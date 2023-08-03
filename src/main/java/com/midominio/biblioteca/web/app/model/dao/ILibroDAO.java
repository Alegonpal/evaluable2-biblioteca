package com.midominio.biblioteca.web.app.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.midominio.biblioteca.web.app.model.entity.Libro;

public interface ILibroDAO extends CrudRepository<Libro, Long>{
	
//	List<Libro> findAll();
//	void save (Libro libro);
//	Libro findOne(Long id);
//	void delete(Long id);
}
