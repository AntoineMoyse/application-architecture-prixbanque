package com.prixbanque.application.controller;

import com.prixbanque.application.model.Client;
import com.prixbanque.application.service.LoginService;
import com.prixbanque.application.service.SoldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prixbanque.application.model.Solde;
/**
 * @author antoine
 * Controller pour les soldes
 */
@Controller
public class SoldeController {

    @Autowired
    private LoginService loginservice;

    @Autowired
    private SoldeService soldeservice;

    /**
     * @return vue Solde
     */
    @RequestMapping(value = "/solde", method = RequestMethod.GET)
    public ModelAndView solde()
    {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Client client = this.loginservice.findClientBymailadress(auth.getName());
        Solde solde = this.soldeservice.findSoldeByClient(client);
        modelAndView.addObject("solde", solde); //$NON-NLS-1$
        modelAndView.setViewName("solde"); //$NON-NLS-1$
        return modelAndView;
    }
}
