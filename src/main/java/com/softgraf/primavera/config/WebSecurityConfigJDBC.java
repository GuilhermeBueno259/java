package com.softgraf.primavera.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigJDBC extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// autoriza requisições (faz a proteção das rotas)
		http.authorizeHttpRequests()
			// páginas de acesso público
			.antMatchers("/", "/home/**", "/sobre", "/images/**", "/uploads/**", "/api/**").permitAll()
			/// todas as outras deve ser autenticadas
			.anyRequest().authenticated()
			
			.and()
			.formLogin(form -> form
							   .loginPage("/login") // é a página de login do controller
							   .defaultSuccessUrl("/produto/gerenciar", true)
							   .permitAll()
					  )
			.logout(logout -> logout.logoutUrl("/logout"))
			// desabilita a segurança de requisições
			.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		salvarNovoUsuario(auth);
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager () {
		return new JdbcUserDetailsManager(dataSource);
	}
	
	/// função auxiliar para criar um novo usuário uma vez que não há formulário no sistema
	private void salvarNovoUsuario(AuthenticationManagerBuilder auth) throws Exception {
		UserDetails user = User.builder()
				.username("guilherme")
				.password(passwordEncoder().encode("123"))
				.roles("USER")
				.build();

		// grava usuário no banco só uma vez! Pois na segunda lança excessão
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder()).withUser(user);
	}

}
