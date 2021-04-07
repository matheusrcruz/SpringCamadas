package com.generation.bootcamp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter  {

		@Autowired
		private UserDetailsService userDetailsService;
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws  Exception{
			auth.userDetailsService(userDetailsService);	
		}
		
		@Bean
		public PasswordEncoder password() {
			return new BCryptPasswordEncoder();
		} 
		
		@Override
		protected void configure(HttpSecurity http)throws Exception  {
			http.authorizeRequests()
			.antMatchers("usuarios/logar").permitAll()       // Esses dois endPoints podem passar sem qualquer restrição meu clinte pode mandalos seja 
			.antMatchers("usuarios/cadastra").permitAll()
			.anyRequest().authenticated()  //Agora tods outras req precisam ser autenticadas em meu modulo de security(passar a key no header)
			.and().httpBasic() //Tipo de autenticação que eu estou usando poderia usar outra? auth 2 ou JWt? 
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)// Politica da api eu esou falando que sigo o padrão stateless ou seja não guardo estado(ou sessão)
			.and().cors()
			.and().csrf().disable();     //tudo np and são parametros que são seguidos por padroes da arquitetura rest em aplicações restful
		} 
	
}
