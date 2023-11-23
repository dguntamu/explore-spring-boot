package explore.spring.boot.explore.config;

import explore.spring.boot.explore.authenticationprovider.MyCustomBasicAuthenticationProvider;
import explore.spring.boot.explore.dao.impl.UserLoadServiceImpl;
import explore.spring.boot.explore.filter.MyAuthenticationLoggerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity(debug = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserLoadServiceImpl userLoadServiceImpl;

    @Autowired
    private MyCustomBasicAuthenticationProvider myCustomBasicAuthenticationProvider;

    //InMemory-WORKING ONE
//   @Override
    protected void configure1(AuthenticationManagerBuilder auth) throws Exception {

       //auth.userDetailsService(userLoadServiceImpl).passwordEncoder(passwordEncoder);

       //Below is used bcz created custom provider (MyCustomBasicAuthenticationProvider.java) and commenting above userDetailsService(-)
       auth.authenticationProvider(myCustomBasicAuthenticationProvider);


       /*
        //Creating user
        UserDetails chehel = User
                .withUsername("chahel")
                //.password("{bcrypt}$2a$10$jm8looy2si0.8tAl6rHkuuqPQHFX9QXQqQvOl9pePhQS6mJNr8NgO") //password : chahel123 (NOT working)
                .password("chahel123") //Changed to NoOpPasswordEncoder from Bcrypt
                .roles("ADMIN","USER")
                .build();

        //Saving user
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(chehel);

        //Informing through which service savign the user (InMemoryUserDetailsManager)
        auth.userDetailsService(inMemoryUserDetailsManager);*/
    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Creating user
        UserDetails chahel = User
                .withUsername("chahel")
                //.password("{bcrypt}$2a$10$jm8looy2si0.8tAl6rHkuuqPQHFX9QXQqQvOl9pePhQS6mJNr8NgO") //password : chahel123 (NOT working)
                .password("chahel123") //Changed to NoOpPasswordEncoder from Bcrypt
                .roles("ADMIN","USER")
                .build();

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);

        //Saving user
        *//*JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.createUser(chahel);*//*

        ////Informing through which service saving the user (JdbcUserDetailsManager)
        *//*auth.userDetailsService(jdbcUserDetailsManager);*//*
    }*/


    //Working ONE
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .passwordEncoder(passwordEncoder) //Created @Bean definition in MyAppConfig.java, check for implementation class.
                .withUser("dhanu")
                .password("dhanu123")// this is for NoOpPasswordEncoder.
                //.password("{bcrypt}$2a$10$zthK5GVCFrW0gxyydg.qe.7H8ntEFztT1QM3tBUIi0ALPaNVgPouq") //its a BCrypted password for 'dhanu123'
                 //https://www.bcryptcalculator.com/encode generated from here.
                //its a BCrypted password for 'dhanu123' bcz impl is Bcrypt in MyAppConfig.java
                //.password("$2a$10$zthK5GVCFrW0gxyydg.qe.7H8ntEFztT1QM3tBUIi0ALPaNVgPouq")
                .roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new MyAuthenticationLoggerFilter(),BasicAuthenticationFilter.class)
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
