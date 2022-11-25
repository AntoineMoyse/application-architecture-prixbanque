package com.prixbanque.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author antoine
 *
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login"); //$NON-NLS-1$ //$NON-NLS-2$
		registry.addViewController("/").setViewName("hello"); //$NON-NLS-1$ //$NON-NLS-2$
		registry.addViewController("/hello").setViewName("hello"); //$NON-NLS-1$ //$NON-NLS-2$
		registry.addViewController("/index").setViewName("index"); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
