package fr.eplouhinec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DecoratorController {

    @RequestMapping(value = "/decorate", method = RequestMethod.GET)
    public String decorate() {
        return "page";
    }
}
