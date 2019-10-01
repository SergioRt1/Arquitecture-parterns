package edu.arep.EC2.config;

import edu.arep.EC2.entities.User;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

@Configuration
public class DataSourceConfig {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        return new DataSource();
    }

    @Bean(name = "userInsert")
    @Primary
    public SimpleJdbcInsert userInsert(DataSource ds) {
        return new SimpleJdbcInsert(ds).withTableName(User.TABLE).usingGeneratedKeyColumns(User.ID);
    }
}
