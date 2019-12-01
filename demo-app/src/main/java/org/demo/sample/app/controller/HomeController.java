package org.demo.sample.app.controller;

import fr.tnframework.core.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private LineService lineService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("lines", lineService.getLines());
        return "home";
    }

}
