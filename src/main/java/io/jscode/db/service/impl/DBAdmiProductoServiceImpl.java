package io.jscode.db.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import io.jscode.db.entity.AdmiProducto;

import io.jscode.db.repository.AdmiProductoRepository;
import io.jscode.db.service.DBAdmiProductoService;

@Service
public class DBAdmiProductoServiceImpl implements DBAdmiProductoService {

	@Autowired
	AdmiProductoRepository admiProductoRepository;
	
	@Override
	public List<AdmiProducto> getAll() {
		return admiProductoRepository.findAll();
	}

	@Override
	public AdmiProducto getById(Long id) throws NoSuchElementException {		
		return admiProductoRepository.findById(id).get();
	}

	@Override
	public AdmiProducto save(AdmiProducto producto){
		return admiProductoRepository.save(producto);
	}

	@Override
	public void update(AdmiProducto producto) {
		admiProductoRepository.save(producto);		
	}

	@Override
	public void delete(AdmiProducto producto) {
		admiProductoRepository.delete(producto);
		
	}

	@Override
	public List<AdmiProducto> getAllBy(AdmiProducto producto) {
		Example<AdmiProducto> filtro = Example.of(producto);
		return admiProductoRepository.findAll(filtro);
	}

	@Override
	public void deleteById(Long id) {
		admiProductoRepository.deleteById(id);
	}

	@Override
	public AdmiProducto getBy(AdmiProducto producto) throws NoSuchElementException {		
		return admiProductoRepository.findOne(Example.of(producto)).orElse(new AdmiProducto());
	}

}
