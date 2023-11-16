package io.jscode.db.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.jscode.db.entity.InfoVentaCab;
import io.jscode.db.repository.InfoVentaCabRepository;
import io.jscode.db.service.DBGestionVentasService;
import io.jscode.db.util.SalesConstants;
import io.jscode.db.util.SalesProperties;
import io.jscode.util.ExcepcionGenerica;
import io.jscode.util.SalesUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Service
public class DGestionVentasServiceImpl implements DBGestionVentasService {
	@PersistenceContext
	EntityManager em;

	@Autowired
	private SalesProperties salesProperties;
	
	@Autowired
	private SalesUtils salesUtils;

	@Autowired
	private InfoVentaCabRepository infoVentaCabRepository;

	@Autowired
	@Qualifier("jdbcSalesSystem")
	private JdbcTemplate jdbcTemplate;

	@Override
	public Long proceRegistrarVenta(InfoVentaCab ventaCab) throws ExcepcionGenerica{

		String requestStr;
		Long idVenta;

		try {
			requestStr = salesUtils.convertObjectAsString(ventaCab);
		} catch (JsonProcessingException e) {
			throw new ExcepcionGenerica(e);
		}

		StoredProcedureQuery spq = em.createStoredProcedureQuery(
				SalesConstants.SCHEMA_SALES + "." + salesProperties.getProceRegistrarVenta());
		spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		spq.registerStoredProcedureParameter(2, String.class, ParameterMode.INOUT);
		spq.registerStoredProcedureParameter(3, String.class, ParameterMode.INOUT);
		spq.registerStoredProcedureParameter(4, Integer.class, ParameterMode.INOUT);

		spq.setParameter(1, requestStr);
		spq.setParameter(2, "");
		spq.setParameter(3, "");
		spq.setParameter(4, 0);

		spq.execute();

		String status = spq.getOutputParameterValue(2).toString();
		String mensaje = spq.getOutputParameterValue(3).toString();
		Integer nIdVenta = (Integer) spq.getOutputParameterValue(4);
		idVenta = Long.parseLong(String.valueOf(nIdVenta));

		if (status.equals("ERROR")) {
			throw new ExcepcionGenerica(mensaje);
		}

		return idVenta;

	}

	@Override
	public List<InfoVentaCab> consultarVentasPorRangoFecha(LocalDateTime fechaDesde, LocalDateTime fechaHasta)
			throws ExcepcionGenerica {
		return infoVentaCabRepository.findByFechaVentaBetween(fechaDesde, fechaHasta);
	}

	@Override
	public void proceAnularVenta(InfoVentaCab ventaCab) throws ExcepcionGenerica {
		String requestStr;

		try {
			requestStr = salesUtils.convertObjectAsString(ventaCab);
		} catch (JsonProcessingException e) {
			throw new ExcepcionGenerica(e);
		}

		StoredProcedureQuery spq = em.createStoredProcedureQuery(
				SalesConstants.SCHEMA_SALES + "." + salesProperties.getProceAnularVenta());
		spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		spq.registerStoredProcedureParameter(2, String.class, ParameterMode.INOUT);
		spq.registerStoredProcedureParameter(3, String.class, ParameterMode.INOUT);

		spq.setParameter(1, requestStr);
		spq.setParameter(2, "");
		spq.setParameter(3, "");

		spq.execute();

		String status = spq.getOutputParameterValue(2).toString();
		String mensaje = spq.getOutputParameterValue(3).toString();
		
		if (status.equals("ERROR")) {
			throw new ExcepcionGenerica(mensaje);
		}

	}

}
