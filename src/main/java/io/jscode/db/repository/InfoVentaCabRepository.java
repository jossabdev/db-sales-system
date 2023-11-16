package io.jscode.db.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jscode.db.entity.InfoVentaCab;

public interface InfoVentaCabRepository extends JpaRepository<InfoVentaCab, Long>{

    public List<InfoVentaCab> findByFechaVentaBetween(LocalDateTime desde, LocalDateTime hasta);

}
