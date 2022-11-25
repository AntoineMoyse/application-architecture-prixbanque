package com.prixbanque.application.controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author antoine
 *
 */
public class IndexController {

	/**
	 * @return vue index
	 */
	@GetMapping("/index")
	public String index()
	{
		return "index"; //$NON-NLS-1$
	}
}
