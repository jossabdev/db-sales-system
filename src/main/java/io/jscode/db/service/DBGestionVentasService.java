package io.jscode.db.service;

import io.jscode.db.entity.InfoVentaCab;
import io.jscode.util.ExcepcionGenerica;

public interface DBGestionVentasService {
	Long proceRegistrarVenta(InfoVentaCab ventaCab) throws ExcepcionGenerica;
}
