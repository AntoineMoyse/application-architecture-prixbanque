package com.prixbanque.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author antoine
 * Controller LogIn
 */
@Controller
public class LogInController {
	/**
	 * @return
	 * Page des clients
	 */
	@RequestMapping(value = "/Clients")
	   public static String Clients() {
	      return "Clients"; //$NON-NLS-1$
	   }
}
