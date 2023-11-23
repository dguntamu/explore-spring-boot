package explore.spring.boot.explore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class MyAppConfig {

    @Bean
    public PasswordEncoder getPasswordEncoder(){
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }

    //For the below DataSourceDriverManager, add spring jdbc dependency in pom.xml
    /*@Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSourceDriverManager = new DriverManagerDataSource();
        dataSourceDriverManager.setUrl("");
        dataSourceDriverManager.setUserName("root");
        dataSourceDriverManager.setPassword("root123");
        dataSourceDriverManager.setDriverClassName("com.mysql.jdbc....");

        return dataSourceDriverManager;
    }*/

}
