package io.jscode.db.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "t_info_inventario", schema = "usr_admin")
@Data
public class InfoInventario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inventario")
	private Long idInventario;
	
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private AdmiProducto producto;
	
	@Column(name = "stock_inicial", nullable = false)
	private Integer stockInicial;
	
	@Column(name = "cantidad_ingresados", nullable = false)
	private Integer cantidadIngresados;
	
	@Column(name = "cantidad_vendidos", nullable = false)
	private Integer cantidadVendidos;
	
	@Column(name = "stock_total", nullable = false)
	private Integer stockTotal;
	
	@Column(name = "estado", length = 12, nullable = false)
	private String estado;
	
	@Column(name = "usr_creacion")
	private String usrCreacion;
	
	@Column(name = "fe_creacion")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime feCreacion;
	
	@Column(name = "ip_creacion")
	private String ipCreacion;
	
	@Column(name = "usr_ult_mod")
	private String usrUltMod;
	
	@Column(name = "fe_ult_mod")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime feUltMod;
	
	@Column(name = "ip_ult_mod")
	private String ipUltMod;
}
