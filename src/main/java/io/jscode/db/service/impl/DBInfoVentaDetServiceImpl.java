package io.jscode.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import io.jscode.db.entity.InfoVentaDet;
import io.jscode.db.repository.InfoVentaDetRepository;
import io.jscode.db.service.DBInfoVentaDetService;

@Service
public class DBInfoVentaDetServiceImpl implements DBInfoVentaDetService {

	@Autowired
	InfoVentaDetRepository infoVentaDetRepository;
	
	@Override
	public List<InfoVentaDet> getAll() {
		return infoVentaDetRepository.findAll();
	}

	@Override
	public InfoVentaDet getById(Long id) {
		return infoVentaDetRepository.findById(id).get();
	}

	@Override
	public InfoVentaDet save(InfoVentaDet ventaDet) {
		return infoVentaDetRepository.save(ventaDet);
	}

	@Override
	public void update(InfoVentaDet ventaDet) {
		infoVentaDetRepository.save(ventaDet);
	}

	@Override
	public void delete(InfoVentaDet ventaDet) {
		infoVentaDetRepository.delete(ventaDet);

	}

	@Override
	public List<InfoVentaDet> getAllBy(InfoVentaDet ventaDet) {
		Example<InfoVentaDet> filtro = Example.of(ventaDet);
		return infoVentaDetRepository.findAll(filtro);
	}

	@Override
	public void deleteById(Long id) {
		infoVentaDetRepository.deleteById(id);
	}

}
