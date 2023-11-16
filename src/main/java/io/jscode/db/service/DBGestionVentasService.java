package io.jscode.db.service;

import java.time.LocalDateTime;
import java.util.List;

import io.jscode.db.entity.InfoVentaCab;
import io.jscode.util.ExcepcionGenerica;

public interface DBGestionVentasService {
	Long proceRegistrarVenta(InfoVentaCab ventaCab) throws ExcepcionGenerica;
	List<InfoVentaCab> consultarVentasPorRangoFecha(LocalDateTime fechaDesde, LocalDateTime fechaHasta) throws ExcepcionGenerica;
	void proceAnularVenta(InfoVentaCab ventaCab) throws ExcepcionGenerica;
}
