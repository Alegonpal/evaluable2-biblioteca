package com.midominio.biblioteca.web.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.biblioteca.web.app.model.dao.ILibroDAO;
import com.midominio.biblioteca.web.app.model.entity.Libro;

@Service
public class LibroServiceImpl implements ILibroService{
	
	@Autowired
	private ILibroDAO libroDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Libro> findAll() {
		// TODO Auto-generated method stub
		return (List<Libro>) libroDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Libro libro) {
		// TODO Auto-generated method stub
		libroDAO.save(libro);
	}

	@Override
	@Transactional(readOnly = true)
	public Libro findOne(Long id) {
		// TODO Auto-generated method stub
		return libroDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		libroDAO.deleteById(id);
	}

}
