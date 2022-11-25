package com.prixbanque.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author antoine
 *
 */
public class PageConfig implements WebMvcConfigurer{

	/**
	 * @return encodeur de mot de passe
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	    return bCryptPasswordEncoder;
	}
	
	/**
	 * @param registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/hello").setViewName("hello"); //$NON-NLS-1$ //$NON-NLS-2$
	    registry.addViewController("/").setViewName("hello"); //$NON-NLS-1$ //$NON-NLS-2$
	    registry.addViewController("/dashboard").setViewName("dashboard"); //$NON-NLS-1$ //$NON-NLS-2$
	    registry.addViewController("/login").setViewName("login"); //$NON-NLS-1$ //$NON-NLS-2$
	}
}
