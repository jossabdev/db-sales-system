package io.jscode.db.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import io.jscode.db.entity.AdmiCategoria;
import io.jscode.db.repository.AdmiCategoriaRepository;
import io.jscode.db.service.DBAdmiCategoriaService;

@Service
public class DBAdmiCategoriaServiceImpl implements DBAdmiCategoriaService {

	@Autowired
	private AdmiCategoriaRepository admiCategoriaRepository;
	
	@Override
	public List<AdmiCategoria> getAll() {
		return admiCategoriaRepository.findAll();
	}

	@Override
	public AdmiCategoria save(AdmiCategoria categoria) {
		return admiCategoriaRepository.save(categoria);		
	}

	@Override
	public void update(AdmiCategoria categoria) {
		admiCategoriaRepository.save(categoria);
	}

	@Override
	public void delete(AdmiCategoria categoria) {
		admiCategoriaRepository.delete(categoria);		
	}

	@Override
	public AdmiCategoria getById(Long id) throws NoSuchElementException {		
		return admiCategoriaRepository.findById(id).get();
	}

	public List<AdmiCategoria> getAllBy(AdmiCategoria categoria){
		Example<AdmiCategoria> filtro = Example.of(categoria);		
		return admiCategoriaRepository.findAll(filtro);
	}

	@Override
	public void deleteById(Long id) {
		admiCategoriaRepository.deleteById(id);		
	}

	@Override
	public AdmiCategoria getBy(AdmiCategoria categoria) throws NoSuchElementException {		
		return admiCategoriaRepository.findOne(Example.of(categoria)).get();
	}
}
