package com.midominio.biblioteca.web.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midominio.biblioteca.web.app.model.dao.IUsuarioDAO;
import com.midominio.biblioteca.web.app.model.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioDAO usuarioDAO;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioDAO.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(Long id) {
		// TODO Auto-generated method stub
		return usuarioDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usuarioDAO.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> listar(Pageable pageable) {
		return usuarioDAO.findAll(pageable);
	}

}
