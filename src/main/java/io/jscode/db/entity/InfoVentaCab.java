package io.jscode.db.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "t_info_venta_cab", schema = "usr_admin")
@Data
public class InfoVentaCab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_venta")
	private Long idVenta;
	
	@Column(name = "vendedor")
	private String vendedor;
	
	@Column(name = "cliente")
	private String cliente;
	
	@Column(name = "subtotal")
	private Double subtotal;
	
	@Column(name = "iva")
	private Double iva;
	
	@Column(name = "descuento")
	private Double descuento;
	
	@Column(name = "total")
	private Double total;
	
	@Column(name = "fecha_venta")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaVenta;
	
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
	private List<InfoVentaDet> detalleVenta;
	
	public void setDetalleVenta(List<InfoVentaDet> detalleVenta) {
		this.detalleVenta = detalleVenta;
		
		if(this.detalleVenta != null)
			detalleVenta.forEach(venta -> venta.setVenta(this));
	}
}
