package com.midominio.biblioteca.web.app.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.midominio.biblioteca.web.app.model.entity.Usuario;
import com.midominio.biblioteca.web.app.model.service.IUsuarioService;
import com.midominio.biblioteca.web.app.utils.paginator.PageRender;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/listar")
	public String listarHandler(@RequestParam(defaultValue = "0") int page,Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Usuario> usuarios = usuarioService.listar(pageRequest);
		PageRender<Usuario> pageRender = new PageRender<>("/usuario/listar", usuarios);
		
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("page", pageRender);
		
		return "usuario/listar";
	}

	@GetMapping("/form")
	public String crearUsuario(Map<String, Object> model) {

		model.put("titulo", "Formulario de usuario");
		model.put("usuario", new Usuario());

		return "usuario/form";
	}

	@PostMapping("/form")
	public String guardarLibro(@Valid Usuario usuario, BindingResult result, @RequestParam("file") MultipartFile foto, Model model, RedirectAttributes flash) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de usuario");
			return "usuario/form";
		}
		
		if (!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src/main/resources/static/upload");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			
			
			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "/" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				flash.addFlashAttribute("info", "Subido correctamente " + foto.getOriginalFilename());
				usuario.setFoto(foto.getOriginalFilename());
			} catch (Exception e) {

			}
		}

		usuarioService.save(usuario);
		return "redirect:listar";
	}
	
	@GetMapping("/form/{id}")
	public String actualizarUsuario(@PathVariable("id") Long id, Map<String, Object> model) {

		Usuario usuario = null;

		if (id > 0) {
			usuario = usuarioService.findOne(id);
		} else {
			return "redirect:listar";
		}

		model.put("usuario", usuario);
		model.put("titulo", "Editar usuario");
		return "usuario/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		if (id > 0)
			usuarioService.delete(id);
		return "redirect:/usuario/listar";
	}
	
	@GetMapping("/ver/{id}")
	public String verPorId(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, Model model,
			RedirectAttributes flash) {

		Usuario usuario = usuarioService.findOne(id);

		if (usuario == null) {
			flash.addFlashAttribute("error", "Usuario inexistente");
			return "redirect:/usuario/listar";
		}

		model.addAttribute("titulo", "Mostrando un usuario");
		model.addAttribute("usuario", usuario);

		return "usuario/ver";
	}

}
