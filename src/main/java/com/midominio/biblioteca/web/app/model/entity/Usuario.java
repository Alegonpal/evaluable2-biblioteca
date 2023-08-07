package com.midominio.biblioteca.web.app.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size( min=3, max=20)
	@NotEmpty
	private String nombre;
	@Size( min=3, max=20)
	@NotEmpty
	private String apellido;
	@Size( min=8, max=10)
	@NotEmpty
	private String dni;
	@NotNull
	@Column(name = "fecha_nacimiento")
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaNacimiento;
	@Size( min=3, max=40)
	@NotEmpty
	private String email;
	@NotNull
	@Column(name = "libros_prestados")
	@Min(value = 0)
	@Max(value = 5)
	private int librosPrestados;
	private String foto;
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getLibrosPrestados() {
		return librosPrestados;
	}
	public void setLibrosPrestados(int librosPrestados) {
		this.librosPrestados = librosPrestados;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
}
