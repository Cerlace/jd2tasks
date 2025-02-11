package cerlace.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/hw8_library?createDatabaseIfNotExist=true");
        dataSource.setUsername("root");
        dataSource.setPassword("lspsds13");
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(10);

        return dataSource;
    }
}
