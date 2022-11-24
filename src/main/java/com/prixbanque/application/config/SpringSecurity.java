package com.prixbanque.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author antoine
 *
 */
@Configuration
@EnableWebSecurity
public class SpringSecurity {

	/**
	 * @param http
	 * @return config
	 * @throws Exception
	 */
	@Bean
    public static SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/register/**").permitAll() //$NON-NLS-1$
                .antMatchers("/index").permitAll() //$NON-NLS-1$
                .antMatchers("/clients").permitAll() //$NON-NLS-1$
                .and().
                formLogin(
                        form -> form
                                .loginPage("/login") //$NON-NLS-1$
                                .loginProcessingUrl("/login") //$NON-NLS-1$
                                .defaultSuccessUrl("/clients") //$NON-NLS-1$
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //$NON-NLS-1$
                                .permitAll()
                );
        return http.build();
    }
}
