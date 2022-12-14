package com.prixbanque.application.controller;

import com.prixbanque.application.model.Client;
import com.prixbanque.application.model.Virement;
import com.prixbanque.application.service.LoginService;
import com.prixbanque.application.service.VirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author antoine
 *Controller pour les virements
 */
@Controller
@Component("VirementController")
public class VirementController {

    @Autowired
    @Lazy
    public VirementService virementservice;

    @Resource(name="SoldeController")
    public SoldeController soldecontroller;

    @Resource(name="LogInController")
    private LogInController logincontroller;

    /**
     * @return vue virement
     */
    @RequestMapping(value = "/virement", method = RequestMethod.GET)
    public ModelAndView virement() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("virement"); //$NON-NLS-1$
        return modelAndView;
    }

    @RequestMapping(value = "/virement", method = RequestMethod.POST)
    public ModelAndView newVirement(float montant, String mail) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Client client = this.logincontroller.loginservice.findClientBymailadress(auth.getName());
        Virement newvirement = new Virement();
        newvirement.setClientPayeur(client);
        newvirement.setMontant(montant);
        newvirement.setClientReceveur(this.logincontroller.loginservice.findClientBymailadress(mail));
        this.virementservice.newVirement(newvirement);
        modelAndView.addObject("successMessage", "Virement has been done successfully"); //$NON-NLS-1$ //$NON-NLS-2$
        modelAndView.addObject("virement", new Virement()); //$NON-NLS-1$
        modelAndView.setViewName("virement"); //$NON-NLS-1$

        return modelAndView;
    }
}
