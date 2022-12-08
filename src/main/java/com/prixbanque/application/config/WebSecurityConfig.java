package com.prixbanque.application.config;

import com.prixbanque.application.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;

	@Bean
	public UserDetailsService mongoUserDetails() {
		return new LoginService();
	}

	/*@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/home", "/register").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}*/

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/register").permitAll()
				.antMatchers("/dashboard/**").hasAuthority("ADMIN").anyRequest()
				.authenticated().and().csrf().disable().formLogin().successHandler(customizeAuthenticationSuccessHandler)
				.loginPage("/login").failureUrl("/login?error=true")
				.usernameParameter("mailadress")
				.passwordParameter("pwd")
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and().exceptionHandling();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserDetailsService userDetailsService = mongoUserDetails();
		auth
				.userDetailsService(userDetailsService)
				.passwordEncoder(bCryptPasswordEncoder);

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
				.ignoring()
				.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
}
