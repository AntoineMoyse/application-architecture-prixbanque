package com.prixbanque.application.controller;

import com.prixbanque.application.model.Solde;
import com.prixbanque.application.service.SoldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.prixbanque.application.model.Client;
import com.prixbanque.application.service.LoginService;

/**
 * @author antoine
 * Controller LogIn
 */
@Controller
public class LogInController {

    @Autowired
    private LoginService loginservice;

    @Autowired
    private SoldeService soldeservice;
	
    /**
     * @return vue login
     */
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login"); //$NON-NLS-1$
        return modelAndView;
    }
    
    /**
     * @return vue register
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        Client client = new Client();
        modelAndView.addObject("client", client); //$NON-NLS-1$
        modelAndView.setViewName("register"); //$NON-NLS-1$
        return modelAndView;
    }
    
    /**
     * @param client
     * @param bindingResult
     * @return post vue register
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView newClient(@Valid Client client, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Client clientExists = this.loginservice.findClientBymailadress(client.getMailadress());
        if (clientExists != null) {
            bindingResult
                    .rejectValue("email", "error.user", //$NON-NLS-1$ //$NON-NLS-2$
                            "There is already a user registered with the username provided"); //$NON-NLS-1$
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register"); //$NON-NLS-1$
        } else {
        	this.loginservice.newClient(client);
            this.soldeservice.newSolde(10000.00f, client);
            modelAndView.addObject("successMessage", "User has been registered successfully"); //$NON-NLS-1$ //$NON-NLS-2$
            modelAndView.addObject("client", new Client()); //$NON-NLS-1$
            modelAndView.setViewName("login"); //$NON-NLS-1$
        }
        return modelAndView;
    }
    
    /**
     * @return vue hello
     */
    @RequestMapping(value = {"/","/hello"}, method = RequestMethod.GET)
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello"); //$NON-NLS-1$
        return modelAndView;
    }
}