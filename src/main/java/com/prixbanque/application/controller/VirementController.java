package com.prixbanque.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author antoine
 *Controller pour les virements
 */
@Controller
public class VirementController {

    /**
     * @return vue virement
     */
    @GetMapping("/virement")
    public String virement()
    {
        return "virement"; //$NON-NLS-1$
    }
}
