package io.jscode.db.service;

import java.util.List;

import io.jscode.db.entity.InfoVentaDet;

public interface DBInfoVentaDetService {
	List<InfoVentaDet> getAll();
	InfoVentaDet getById(Long id);
	InfoVentaDet save(InfoVentaDet ventaDet);
	void update(InfoVentaDet ventaDet);
	void delete(InfoVentaDet ventaDet);
	void deleteById(Long id);
	List<InfoVentaDet> getAllBy(InfoVentaDet ventaDet);
}
