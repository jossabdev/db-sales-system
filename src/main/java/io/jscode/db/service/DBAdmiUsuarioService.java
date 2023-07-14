package io.jscode.db.service;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import io.jscode.db.entity.AdmiUsuario;

public interface DBAdmiUsuarioService {
	List<AdmiUsuario> getAll();
	AdmiUsuario getById(Long id);
	AdmiUsuario getBy(AdmiUsuario usuario) throws UsernameNotFoundException;
	AdmiUsuario save(AdmiUsuario usuario);
	void update(AdmiUsuario usuario);
	void delete(AdmiUsuario usuario);
	void deleteById(Long id);
	List<AdmiUsuario> getAllBy(AdmiUsuario usuario);
}
