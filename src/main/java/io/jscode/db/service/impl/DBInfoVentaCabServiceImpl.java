package io.jscode.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import io.jscode.db.entity.InfoVentaCab;
import io.jscode.db.repository.InfoVentaCabRepository;
import io.jscode.db.service.DBInfoVentaCabService;

@Service
public class DBInfoVentaCabServiceImpl implements DBInfoVentaCabService {

	@Autowired
	InfoVentaCabRepository infoVentaCabRepository;
	
	@Override
	public List<InfoVentaCab> getAll() {
		return infoVentaCabRepository.findAll() ;
	}

	@Override
	public InfoVentaCab getById(Long id) {
		return infoVentaCabRepository.findById(id).get();
	}

	@Override
	public InfoVentaCab save(InfoVentaCab ventaCab) {		
		return infoVentaCabRepository.save(ventaCab);
	}
	
	@Override
	public void update(InfoVentaCab ventaCab) {
		infoVentaCabRepository.save(ventaCab);
	}

	@Override
	public void delete(InfoVentaCab ventaCab) {
		infoVentaCabRepository.delete(ventaCab);
	}

	@Override
	public List<InfoVentaCab> getAllBy(InfoVentaCab ventaCab) {
		Example<InfoVentaCab> filtro = Example.of(ventaCab);
		return infoVentaCabRepository.findAll(filtro);
	}

	@Override
	public void deleteById(Long id) {
		infoVentaCabRepository.deleteById(id);
	}

}
