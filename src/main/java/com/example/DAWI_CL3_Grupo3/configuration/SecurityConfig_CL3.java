package com.example.DAWI_CL3_Grupo3.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;
import com.example.DAWI_CL3_Grupo3.service.UsuarioDetalleService_CL3;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig_CL3 {
	@Autowired
	private final UsuarioDetalleService_CL3 
		usuarioDetalleService_cl3;
	
	@Bean
	public SecurityFilterChain 
		configure(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests()
			.antMatchers("/auth/login",
					"/auth/registrar",
					"/auth/guardarUsuario",
					"/resources/**",
					"/static/**",
					"/css/**",
					"/js/**")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin().loginPage("/auth/login")
			.usernameParameter("txtusuario_cl3")
			.passwordParameter("txtpassword_cl3")
			.defaultSuccessUrl("/home")
			.failureUrl("/auth/login?error=true")
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/auth/login").and()
			.exceptionHandling()
			.accessDeniedPage("/access-denied")
			.and()
			.authenticationProvider(
					authenticationProvider());
		return http.build();
			
	}
	
	@Bean
	public AuthenticationProvider 
		authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider
			= new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(
				usuarioDetalleService_cl3);
		authenticationProvider.setPasswordEncoder(
				new BCryptPasswordEncoder());
		return authenticationProvider;
	}
}
