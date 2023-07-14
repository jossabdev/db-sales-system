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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_admi_producto", schema = "usr_admin")
@Getter
@Setter
@NoArgsConstructor
public class AdmiProducto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Long idProducto;
	
	@Column(name = "nombre_producto", length = 64, nullable = false)
	private String nombreProducto;
	
	@Column(name = "descripcion", length = 256)
	private String descripcion;
	
	@Column(name = "codigo_barras", length = 1000)
	private String codigoBarras;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private AdmiCategoria categoria;
	
	@Column(name = "costo")
	private Double costo;
	
	@Column(name = "precio_venta")
	private Double precioVenta;

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
