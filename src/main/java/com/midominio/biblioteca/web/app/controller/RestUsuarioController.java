package com.midominio.biblioteca.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.midominio.biblioteca.web.app.model.entity.Usuario;
import com.midominio.biblioteca.web.app.model.service.IUsuarioService;

@RestController
@RequestMapping("/rest")
public class RestUsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios(){
		
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario listarUsuario(@PathVariable Long id) {
		return usuarioService.findOne(id);
	}
	
	@DeleteMapping("/usuario/{id}")
	public void borrarUsuario(@PathVariable Long id) {
		usuarioService.delete(id);
	}
}
