package com.midominio.biblioteca.web.app.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.midominio.biblioteca.web.app.model.entity.Usuario;

public interface IUsuarioDAO extends PagingAndSortingRepository<Usuario, Long>, CrudRepository <Usuario, Long> {
//	List<Usuario> findAll();
//	void save (Usuario usuario);
//	Usuario findOne(Long id);
//	void delete(Long id);
}
