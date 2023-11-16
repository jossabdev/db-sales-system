package io.jscode.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import io.jscode.db.entity.InfoInventario;
import io.jscode.db.repository.InfoInventarioRepository;
import io.jscode.db.service.DBInfoInventarioService;

@Service
public class DBInfoInventarioServiceImpl implements DBInfoInventarioService {

	@Autowired
	InfoInventarioRepository infoInventarioRepository;
	
	@Override
	public List<InfoInventario> getAll() {
		return infoInventarioRepository.findAll();
	}

	@Override
	public InfoInventario getById(Long id) {	
		return infoInventarioRepository.findById(id).get();
	}

	@Override
	public InfoInventario save(InfoInventario inventario) {		
		return infoInventarioRepository.save(inventario);
	}

	@Override
	public InfoInventario update(InfoInventario inventario) {
		return infoInventarioRepository.save(inventario);	
	}

	@Override
	public void delete(InfoInventario inventario) {
		infoInventarioRepository.delete(inventario);
	}

	@Override
	public List<InfoInventario> getAllBy(InfoInventario inventario) {
		Example<InfoInventario> filtro = Example.of(inventario);
		return infoInventarioRepository.findAll(filtro);
	}

	@Override
	public void deleteById(Long id) {
		infoInventarioRepository.deleteById(id);
	}

	@Override
	public InfoInventario getBy(InfoInventario inventario) {		
		return infoInventarioRepository.findOne(Example.of(inventario)).get();
	}

}
