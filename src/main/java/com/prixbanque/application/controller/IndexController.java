package com.prixbanque.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author antoine
 *
 */
public class IndexController {

	/**
	 * @return
	 */
	@GetMapping("/index")
	public ModelAndView index()
	{
		final ModelAndView modelAndView = new ModelAndView("index"); //$NON-NLS-1$
		return modelAndView;
	}
}
