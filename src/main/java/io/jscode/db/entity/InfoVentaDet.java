package io.jscode.db.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "t_info_venta_det", schema = "usr_admin")
@Data
public class InfoVentaDet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_venta_det")
	private Long idVentaDet;
	
	@ManyToOne
	@JoinColumn(name = "venta_id", nullable = false, updatable = false)
	@JsonIgnore
	private InfoVentaCab venta;
	
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private AdmiProducto producto;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	
	@Column(name = "valor_unitario", nullable = false)
	private Double valorUnitario;
	
	@Column(name = "valor_total", nullable = false)
	private Double valorTotal;
	
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
