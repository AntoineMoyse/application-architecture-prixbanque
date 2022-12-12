package com.prixbanque.application.controller;

import com.prixbanque.application.model.Solde;
import com.prixbanque.application.service.SoldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.prixbanque.application.model.Client;
import com.prixbanque.application.service.LoginService;

/**
 * @author antoine
 * Controller LogIn
 */
@Controller
@Component("LogInController")
public class LogInController {

    @Autowired
    public LoginService loginservice;

    /**
     * @return vue login
     */
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login"); //$NON-NLS-1$
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