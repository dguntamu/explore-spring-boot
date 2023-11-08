package explore.spring.boot.explore.config;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .passwordEncoder(passwordEncoder) //Created @Bean definition in MyAppConfig.java, check for implementation class.
                .withUser("dhanu")
                //.password("dhanu123")// this is for NoOpPasswordEncoder.
                /*.password("{bcrypt}$2a$10$zthK5GVCFrW0gxyydg.qe.7H8ntEFztT1QM3tBUIi0ALPaNVgPouq") //its a BCrypted password for 'dhanu123'
                 //https://www.bcryptcalculator.com/encode generated from here.*/
                //its a BCrypted password for 'dhanu123' bcz impl is Bcrypt in MyAppConfig.java
                .password("$2a$10$zthK5GVCFrW0gxyydg.qe.7H8ntEFztT1QM3tBUIi0ALPaNVgPouq")
                .roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/emps","/emp/*").authenticated()
                .and()
                .authorizeRequests()
                .antMatchers("/emp-address/*").permitAll()
                .and()
                .httpBasic()
                .and()
                .formLogin();
    }

    //Working one.
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin();
    }*/

    /*@Bean
    PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }*/
    /*@Bean
    PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }*/
}
