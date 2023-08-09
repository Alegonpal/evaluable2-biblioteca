package com.midominio.biblioteca.web.app.model.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.midominio.biblioteca.web.app.model.entity.Libro;

public interface ILibroDAO extends PagingAndSortingRepository<Libro, Long>, CrudRepository<Libro, Long>{
	
//	List<Libro> findAll();
//	void save (Libro libro);
//	Libro findOne(Long id);
//	void delete(Long id);
}
