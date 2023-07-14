package io.jscode.db.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Data
@Configuration
@PropertySource("classpath:sales.properties")
public class SalesProperties {
	@Value("${db.proce.registrar.venta}")
	private String proceRegistrarVenta;
}
