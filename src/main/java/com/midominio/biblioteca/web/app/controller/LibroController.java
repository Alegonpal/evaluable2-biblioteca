package com.midominio.biblioteca.web.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.midominio.biblioteca.web.app.model.entity.Libro;
import com.midominio.biblioteca.web.app.model.service.ILibroService;
import com.midominio.biblioteca.web.app.utils.paginator.PageRender;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/libro")
public class LibroController {
	
	@Autowired
	private ILibroService libroService;
	
	@GetMapping("/listar")
	public String listarHandler(@RequestParam(defaultValue = "0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Libro> libros = libroService.listar(pageRequest);
		PageRender<Libro> pageRender = new PageRender<>("/libro/listar", libros);
		
		model.addAttribute("titulo", "Listado de libros");
		model.addAttribute("libros", libros);
		model.addAttribute("page", pageRender);
		
		return "libro/listar";
	}
	
	@GetMapping("/form")
	public String crearLibro(Map<String, Object> model) {
		
		model.put("titulo", "Formulario de libro");
		model.put("libro", new Libro());
		
		return "libro/form";
	}
	
	@PostMapping("/form")
	public String guardarLibro(@Valid Libro libro, BindingResult result, Model model, RedirectAttributes flash) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de libro");
			return "libro/form";
		}
		
		libroService.save(libro);
		flash.addFlashAttribute("success", "Artículo guardado con éxito");
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
	public String eliminar(@PathVariable("id") Long id, RedirectAttributes flash) {
		if (id > 0)
			libroService.delete(id);
		flash.addFlashAttribute("warning", "Artículo borrado con éxito");
		return "redirect:/libro/listar";
	}
	
}
