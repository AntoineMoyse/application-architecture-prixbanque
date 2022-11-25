package com.prixbanque.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author antoine
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	/**
	 * @param http
	 * @return config
	 * @throws Exception
	 */
	@Bean
	public static SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/hello").permitAll() //$NON-NLS-1$ //$NON-NLS-2$
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login") //$NON-NLS-1$
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}

	/**
	 * @return oué
	 */
	@SuppressWarnings("deprecation")
	@Bean
	public static UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user") //$NON-NLS-1$
				.password("password") //$NON-NLS-1$
				.roles("USER") //$NON-NLS-1$
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
