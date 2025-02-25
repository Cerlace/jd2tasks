package cerlace.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourceConfig.class, JpaConfig.class, TransactionConfig.class})
@ComponentScan(basePackages = "cerlace")
public class AppConfig {
}
