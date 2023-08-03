package com.midominio.biblioteca.web.app.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BibliotecaErrorHandlerController {

	
	@ExceptionHandler(ArithmeticException.class)
	public String arithmeticException (ArithmeticException ex, Model model) {
		model.addAttribute("error", "Error de aritmética");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", LocalDate.now());
		return "error/internal-error";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String templateInputError(NullPointerException ex, Model model) {
		model.addAttribute("error", "Error null pointer");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", LocalDate.now());
		return "error/internal-error";
	}
	
}
