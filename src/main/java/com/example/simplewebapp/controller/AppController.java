package com.example.simplewebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.logging.Logger;

@Controller
public class AppController {
    private final static Logger LOGGER = Logger.getLogger(AppController.class.getName());

    private String applicationName="";

    private String deploymentGroupName="";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayIndex(Model model) {
        model.addAttribute("applicationName", applicationName);
        model.addAttribute("deploymentGroupName", deploymentGroupName);
        model.addAttribute("instanceIds", Collections.<String>emptyList());
        model.addAttribute("instanceStates", "instanceStates");
        return "/index";
    }

    @RequestMapping(value = "/starter", method = RequestMethod.GET)
    public String displayStarter(Model model) {
        return "/starter";
    }

}
