package org.example.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

//@Component
@Configuration
@ComponentScan("org.example")
//@Profile("dev")
//@PropertySource("/application.properties")
public class JdbcConfig {

    //    @Value("${dataSource.url}")
//    private String dataBaseUrl;
//
//    @Value("${dataSource.user}")
//    String userName;
//
//    @Value("${dataSource.password}")
//    String password;
//
//    @Value("${dataSource}")
//    String driver;


    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/certificate");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        dataSource.setMinimumIdle(5);
        return dataSource;
    }
// @Bean
//    public DataSource dataSource() {
//        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setDriverClassName(driver);
//        dataSource.setJdbcUrl(dataBaseUrl);
//        dataSource.setUsername(userName);
//        dataSource.setPassword(password);
//        return dataSource;
//    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
