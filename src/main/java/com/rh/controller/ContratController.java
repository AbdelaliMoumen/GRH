package com.rh.controller;

import java.util.List;

import com.rh.entity.Contrat;
import com.rh.entity.Cpaiment;
import com.rh.service.ContratService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contrats")
public class ContratController {

    @Autowired
    private ContratService contratService;

    @GetMapping("/all")
    public String index(Model model) {
        model.addAttribute("contrats", contratService.getAllContrats());
        return "contrats/all";
    }

    @GetMapping("/new")
    public String showNewContratForm(Model model) {
        model.addAttribute("contrat", new Contrat());
        return "contrats/new";
    }

    @PostMapping("/save")
    public String saveContrat(@ModelAttribute("contrat") Contrat contrat) {

        contratService.saveContrat(contrat);
        return "redirect:/contrats/all";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable(value = "id") long id, Model model) {
        Contrat contrat = contratService.getContratById(id);

        model.addAttribute("contrat", contrat);
        model.addAttribute("cpaiment", new Cpaiment());
        return "contrats/details";
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Contrat contrat = contratService.getContratById(id);

        model.addAttribute("contrat", contrat);
        return "contrats/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteContrat(@PathVariable(value = "id") long id) {

        this.contratService.deleteContratById(id);
        return "redirect:/contrats/all";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
            @RequestParam("sortDir") String sortDir, Model model) {
        int pageSize = 5;

        Page<Contrat> page = contratService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Contrat> listContrats = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listContrats", listContrats);
        return "index";
    }
}
