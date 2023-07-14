package io.jscode.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import io.jscode.db.entity.AdmiRol;
import io.jscode.db.repository.AdmiRolRepository;
import io.jscode.db.service.DBAdmiRolService;

@Service
public class DBAdmiRolServiceImpl implements DBAdmiRolService{

	private AdmiRolRepository admiRolRepository;
	
	@Autowired
	public DBAdmiRolServiceImpl(AdmiRolRepository admiRolRepository) {
		this.admiRolRepository = admiRolRepository;
	}
	
	@Override
	public List<AdmiRol> getAll() {
		return admiRolRepository.findAll();
	}

	@Override
	public AdmiRol getById(Long id) {
		return admiRolRepository.findById(id).get();
	}

	@Override
	public AdmiRol getBy(AdmiRol rol) {
		return admiRolRepository.findOne(Example.of(rol)).get();
	}

	@Override
	public AdmiRol save(AdmiRol rol) {
		return admiRolRepository.save(rol);
	}

	@Override
	public void update(AdmiRol rol) {
		admiRolRepository.save(rol);
	}

	@Override
	public void delete(AdmiRol rol) {
		admiRolRepository.delete(rol);
	}

	@Override
	public void deleteById(Long id) {
		admiRolRepository.deleteById(id);
	}

	@Override
	public List<AdmiRol> getAllBy(AdmiRol rol) {
		return admiRolRepository.findAll(Example.of(rol));
	}

}
