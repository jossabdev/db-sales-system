package io.jscode.db.service;

import java.util.List;

import io.jscode.db.entity.InfoVentaCab;

public interface DBInfoVentaCabService {
	List<InfoVentaCab> getAll();
	InfoVentaCab getById(Long id);
	InfoVentaCab save(InfoVentaCab ventaCab);
	void update(InfoVentaCab ventaCab);
	void delete(InfoVentaCab ventaCab);
	void deleteById(Long id);
	List<InfoVentaCab> getAllBy(InfoVentaCab ventaCab);
}
