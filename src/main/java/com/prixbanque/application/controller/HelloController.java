package com.prixbanque.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author antoine
 * Controller LogIn
 */
@Controller
public class HelloController {
	/**
	 * @return
	 * Page des clients
	 */
	@RequestMapping(value = "/hello")
	   public static String hello() {
	      return "hello"; //$NON-NLS-1$
	   }
}
