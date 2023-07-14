package io.jscode.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.jscode.db.entity.AdmiUsuario;
import io.jscode.db.repository.AdmiUsuarioRepository;
import io.jscode.db.service.DBAdmiUsuarioService;

@Service
public class DBAdmiUsuarioServiceImpl implements DBAdmiUsuarioService {

	@Autowired
	AdmiUsuarioRepository admiUsuarioRepository;
	
	@Override
	public List<AdmiUsuario> getAll() {
		return admiUsuarioRepository.findAll();
	}

	@Override
	public AdmiUsuario getById(Long id) {
		return admiUsuarioRepository.findById(id).get();
	}

	@Override
	public AdmiUsuario getBy(AdmiUsuario usuario) throws UsernameNotFoundException{
		return admiUsuarioRepository.findOne(Example.of(usuario)).orElseThrow(() -> new UsernameNotFoundException("Usuario: " + usuario.getUsuario() + " no encontrado"));
	}

	@Override
	public AdmiUsuario save(AdmiUsuario usuario) {		
		return admiUsuarioRepository.save(usuario);
	}

	@Override
	public void update(AdmiUsuario usuario) {
		admiUsuarioRepository.save(usuario);
	}

	@Override
	public void delete(AdmiUsuario usuario) {
		admiUsuarioRepository.delete(usuario);
	}

	@Override
	public void deleteById(Long id) {
		admiUsuarioRepository.deleteById(id);
	}

	@Override
	public List<AdmiUsuario> getAllBy(AdmiUsuario usuario) {
		return admiUsuarioRepository.findAll(Example.of(usuario));
	}

}
