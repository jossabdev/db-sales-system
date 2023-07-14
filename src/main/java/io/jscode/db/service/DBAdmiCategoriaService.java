package io.jscode.db.service;

import java.util.List;

import io.jscode.db.entity.AdmiCategoria;

public interface DBAdmiCategoriaService {
	List<AdmiCategoria> getAll();
	AdmiCategoria getById(Long id);
	AdmiCategoria getBy(AdmiCategoria categoria);
	AdmiCategoria save(AdmiCategoria categoria);
	void update(AdmiCategoria categoria);
	void delete(AdmiCategoria categoria);
	void deleteById(Long id);
	List<AdmiCategoria> getAllBy(AdmiCategoria categoria);
}
