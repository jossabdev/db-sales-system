package io.jscode.db.service;

import java.util.List;

import io.jscode.db.entity.AdmiRol;

public interface DBAdmiRolService {
	List<AdmiRol> getAll();
	AdmiRol getById(Long id);
	AdmiRol getBy(AdmiRol rol);
	AdmiRol save(AdmiRol rol);
	void update(AdmiRol rol);
	void delete(AdmiRol rol);
	void deleteById(Long id);
	List<AdmiRol> getAllBy(AdmiRol rol);
}
