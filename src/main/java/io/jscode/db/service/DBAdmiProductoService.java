package io.jscode.db.service;

import java.util.List;

import io.jscode.db.entity.AdmiProducto;

public interface DBAdmiProductoService {
	List<AdmiProducto> getAll();
	AdmiProducto getById(Long id);
	AdmiProducto getBy(AdmiProducto producto);
	AdmiProducto save(AdmiProducto producto);
	void update(AdmiProducto producto);
	void delete(AdmiProducto producto);
	void deleteById(Long id);
	List<AdmiProducto> getAllBy(AdmiProducto producto);
}
