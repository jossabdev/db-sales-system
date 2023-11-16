package io.jscode.db.service;

import java.util.List;

import io.jscode.db.entity.InfoInventario;

public interface DBInfoInventarioService {
	List<InfoInventario> getAll();
	InfoInventario getById(Long id);
	InfoInventario getBy(InfoInventario inventario);
	InfoInventario save(InfoInventario inventario);
	InfoInventario update(InfoInventario inventario);
	void delete(InfoInventario inventario);
	void deleteById(Long id);
	List<InfoInventario> getAllBy(InfoInventario inventario);
}
