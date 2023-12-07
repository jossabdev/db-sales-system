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
@Table(name = "t_admi_usuario", schema = "usr_admin")
@Getter
@Setter
@NoArgsConstructor
public class AdmiUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@ManyToOne
	@JoinColumn(name = "rol_id", nullable = false, updatable = false)
	private AdmiRol rol;
	
	@Column(name = "usuario", nullable = false, length = 48)
	private String usuario;

	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "email", nullable = true, length = 48)
	private String email;
	
	@Column(name = "password", nullable = false, length = 256)
	private String password;
	
	@Column(name = "locked")
	private boolean locked;
	
	@Column(name = "disabled")
	private boolean disabled;
	
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
