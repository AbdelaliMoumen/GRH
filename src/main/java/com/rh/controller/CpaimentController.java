package com.rh.controller;

import com.rh.entity.Contrat;
import com.rh.entity.Cpaiment;
import com.rh.service.CpaimentService;
import com.rh.service.ContratService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cpaiments")
public class CpaimentController {

    @Autowired
    private CpaimentService cpaimentService;

    @Autowired
    private ContratService contratService;

    @GetMapping("/all")
    public String index(Model model) {
        model.addAttribute("Cpaiments", cpaimentService.getAllCpaiments());
        return "cpaiments/all";
    }

    

    @PostMapping("/save/{contrat_id}")
    public String saveCpaiment(@ModelAttribute("cpaiment") Cpaiment cpaiment,
            @PathVariable(value = "contrat_id") long id) {
        Contrat contrat = contratService.getContratById(id);

        cpaimentService.saveCpaiment(cpaiment, contrat);
        return "redirect:/contrats/details/" + contrat.getId();
    }

    
}
