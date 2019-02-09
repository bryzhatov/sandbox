package ua.bryzhatov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

// Что бы не описывать каждый бин в классе можно использовать ComponentScan и аннотации
// Component, Repository, Service
@Configuration
@ComponentScan(basePackages = {"ua.bryzhatov.service","ua.bryzhatov.dao"})
public class SpringConfig {

    //Здесь используется Spring JDBC
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/SpringDB");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Bryzh200696");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

//    @Bean
//    public UserDAO getUserDAO(){
//        return new UserDAOImpl(getJdbcTemplate());
//    }

//    @Bean
//    public UserService getUserService(){
//        return new UserServiceImpl();
//    }
}
