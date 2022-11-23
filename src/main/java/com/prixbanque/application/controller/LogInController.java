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
    @GetMapping("/Clients")
    public String getClients(Model model) {
    	model.addAttribute("clients", this.clientrepo.findAll()); //$NON-NLS-1$
        return "/Clients"; //$NON-NLS-1$
    }
	
}