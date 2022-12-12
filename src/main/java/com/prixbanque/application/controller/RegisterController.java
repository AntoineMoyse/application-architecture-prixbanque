package com.prixbanque.application.controller;

import com.prixbanque.application.model.Client;
import com.prixbanque.application.repository.ClientRepository.ClientRepository;
import com.prixbanque.application.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@Component("RegisterController")
public class RegisterController {

    @Resource(name="LogInController")
    private LogInController logincontroller;

    @Resource(name="SoldeController")
    private SoldeController soldecontroller;

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
        Client clientExists = this.logincontroller.loginservice.findClientBymailadress(client.getMailadress());
        if (clientExists != null) {
            bindingResult
                    .rejectValue("email", "error.user", //$NON-NLS-1$ //$NON-NLS-2$
                            "There is already a user registered with the username provided"); //$NON-NLS-1$
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register"); //$NON-NLS-1$
        } else {
            this.logincontroller.loginservice.newClient(client);
            this.soldecontroller.soldeservice.newSolde(10000.00f, client);
            modelAndView.addObject("successMessage", "User has been registered successfully"); //$NON-NLS-1$ //$NON-NLS-2$
            modelAndView.addObject("client", new Client()); //$NON-NLS-1$
            modelAndView.setViewName("login"); //$NON-NLS-1$
        }
        return modelAndView;
    }
}
