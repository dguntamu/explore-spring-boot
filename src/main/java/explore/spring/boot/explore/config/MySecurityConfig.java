package explore.spring.boot.explore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("dhanu")
                //.password("dhanu123")// this is for NoOpPasswordEncoder.
                .password("{bcrypt}$2a$10$zthK5GVCFrW0gxyydg.qe.7H8ntEFztT1QM3tBUIi0ALPaNVgPouq") //its a BCrypted password for 'dhanu123'
                //https://www.bcryptcalculator.com/encode generated from here.
                .roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    /*@Bean
    PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }*/
    /*@Bean
    PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }*/
}
