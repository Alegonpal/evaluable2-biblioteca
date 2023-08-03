package com.midominio.biblioteca.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

		@GetMapping({"/", "/home", ""})
		public String homeHandler(Model model) {
			
			model.addAttribute("titulo", "Home biblioteca");
			model.addAttribute("encabezado", "Aplicación para gestión de biblioteca");
			
			return "home";
		}
}
