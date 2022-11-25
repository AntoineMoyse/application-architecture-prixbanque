package com.prixbanque.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import com.prixbanque.application.service.LoginService;

/**
 * @author antoine
 *
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	/**
	 * @return je sais pas laisse moi tranquille
	 */
	@Bean
	public PasswordEncoder passwordEncoder()
	{
	    return new BCryptPasswordEncoder();
	}
	
	/**
	 * @return ta grand mère la chauve
	 */
	@Bean
	public CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler()
	{
		return new CustomizeAuthenticationSuccessHandler();
	}
	
	/**
	 * @return le service de connexion
	 */
	@Bean
	public UserDetailsService mongoUserDetails() {
	    return new LoginService();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    UserDetailsService userDetailsService = mongoUserDetails();
	    auth
	        .userDetailsService(userDetailsService)
	        .passwordEncoder(passwordEncoder());

	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	            .antMatchers("/").permitAll() //$NON-NLS-1$
	            .antMatchers("/login").permitAll() //$NON-NLS-1$
	            .antMatchers("/signup").permitAll() //$NON-NLS-1$
	            .antMatchers("/dashboard/**").hasAuthority("ADMIN").anyRequest() //$NON-NLS-1$ //$NON-NLS-2$
	            .authenticated().and().csrf().disable().formLogin().successHandler(customizeAuthenticationSuccessHandler())
	            .loginPage("/login").failureUrl("/login?error=true") //$NON-NLS-1$ //$NON-NLS-2$
	            .usernameParameter("email") //$NON-NLS-1$
	            .passwordParameter("password") //$NON-NLS-1$
	            .and().logout()
	            .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //$NON-NLS-1$
	            .logoutSuccessUrl("/").and().exceptionHandling(); //$NON-NLS-1$
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	        .ignoring()
	        .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	}
}
