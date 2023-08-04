package com.midominio.biblioteca.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midominio.biblioteca.web.app.model.entity.Libro;
import com.midominio.biblioteca.web.app.model.service.ILibroService;

@RestController
@RequestMapping("/rest")
public class RestLibroController {

	@Autowired
	private ILibroService libroService;
	
	@GetMapping("/libros")
	public List<Libro> listarLibros(){
		
		return libroService.findAll();
	}
	
	@GetMapping("/libro/{id}")
	public Libro listarLibro(@PathVariable Long id) {
		return libroService.findOne(id);
	}
	
	@DeleteMapping("/libro/{id}")
	public void borrarLibro(@PathVariable Long id) {
		libroService.delete(id);
	}
	
}
