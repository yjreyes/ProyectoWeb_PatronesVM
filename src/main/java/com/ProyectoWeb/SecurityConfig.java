package com.ProyectoWeb;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123")
                .roles("ADMIN", "USUARIO")
                .and()
                .withUser("juan")
                .password("{noop}456")
                .roles("USUARIO");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/vehiculo/nuevo", "vehiculo/guardar",
                        "/vehiculo/modificar/**", "/vehiculo/eliminar/**",
                        "/menu")
                .hasRole("ADMIN")
                .antMatchers("/","/vehiculo/listado")
                .hasAnyRole("ADMIN", "USUARIO")
                .and().formLogin().loginPage("/login")
                .and().exceptionHandling().accessDeniedPage("/errores/403");
    }

}
