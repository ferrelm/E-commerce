package com.example.demo.accessingdatajpa.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http.cors().and().csrf().disable() // o que autorizo
				.authorizeHttpRequests(authorize -> authorize
                        .antMatchers("/**").permitAll()
						.anyRequest().authenticated()
				) // como autorizo
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // segundo endpoint tem de se autenticar outra vez
				.exceptionHandling()
                .authenticationEntryPoint((request, response, ex) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED,ex.getMessage()));
		// @formatter:on
		return http.build();
	}

	@Bean
	UserDetailsService users() {
		// @formatter:off
		return new InMemoryUserDetailsManager(
			User.withUsername("user")
				.password("{noop}password")
				.authorities("app")
				.build()
		);
		// @formatter:on
	}
}
