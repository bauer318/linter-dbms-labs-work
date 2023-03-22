package ru.rsreu.kibamba.linter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication/*(exclude={DataSourceAutoConfiguration.class})*/
public class LinterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinterApplication.class, args);
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.relx.jdbc.LinterDriver");
        dataSource.setUrl("jdbc:linter:linapid:localhost:1070:local;autoCommit=true");
        dataSource.setUsername("SYSTEM");
        dataSource.setPassword("MANAGER");
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }


}
