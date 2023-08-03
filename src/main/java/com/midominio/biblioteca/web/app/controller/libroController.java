package com.midominio.biblioteca.web.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.midominio.biblioteca.web.app.model.entity.Libro;
import com.midominio.biblioteca.web.app.model.service.ILibroService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/libro")
public class libroController {
	
	@Autowired
	private ILibroService libroService;
	
	@GetMapping("/listar")
	public String listarHandler(Model model) {
		
		model.addAttribute("titulo", "Listado de libros");
		model.addAttribute("libros", libroService.findAll());
		
		return "libro/listar";
	}
	
	@GetMapping("/form")
	public String crearLibro(Map<String, Object> model) {
		
		model.put("titulo", "Formulario de libro");
		model.put("libro", new Libro());
		
		return "libro/form";
	}
	
	@PostMapping("/form")
	public String guardarLibro(@Valid Libro libro, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de libro");
			return "libro/form";
		}
		
		libroService.save(libro);
		return "redirect:listar";
	}
	
	@GetMapping("/form/{id}")
	public String actualizarLibro(@PathVariable("id") Long id, Map<String, Object> model) {
		
		Libro libro = null;
		
		if(id>0) {
			libro = libroService.findOne(id);
		} else {
			return "redirect:listar";
		}
		
		model.put("libro", libro);
		model.put("titulo", "Editar libro");
		return "libro/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		if (id > 0)
			libroService.delete(id);
		return "redirect:/libro/listar";
	}
	
}
