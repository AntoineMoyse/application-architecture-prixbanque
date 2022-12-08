package com.prixbanque.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author antoine
 * Controller pour les soldes
 */
@Controller
public class SoldeController {

    /**
     * @return vue Solde
     */
    @GetMapping("/solde")
    public String solde()
    {
        return "solde"; //$NON-NLS-1$
    }
}
