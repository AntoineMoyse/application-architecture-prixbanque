package com.prixbanque.application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.prixbanque.application.repository.ClientRepository;

/**
 * @author antoine
 * Controller LogIn
 */
@Controller
public class LogInController {
	
	@Autowired
	private ClientRepository clientrepo;
  
    /**
     * @param model 
     * @return liste de tous les clients
     */
    @GetMapping(value={"/login", "/"})
    public static String login(Model model) {
        return "login"; //$NON-NLS-1$
    }
    
    
	
}