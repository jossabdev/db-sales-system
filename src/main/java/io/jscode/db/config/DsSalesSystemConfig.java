package io.jscode.db.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "SalesSystemEMFactory", transactionManagerRef = "SalesSystemTM", basePackages = {"io.jscode.db.repository"})
@EntityScan(basePackages = {"io.jscode.db.entity"})
public class DsSalesSystemConfig {

}
