package br.com.fiap.CPEvento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("msg", "Bem vindo!");
        return "/fragments/index";
    }
}
