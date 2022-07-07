package com.rh.controller;

import java.util.List;

import com.rh.entity.Soumission;
import com.rh.entity.Outside;
import com.rh.service.SoumissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/soumissions")
public class SoumissionController {

    @Autowired
    private SoumissionService soumissionService;

    @GetMapping("/all")
    public String index(Model model) {
        model.addAttribute("soumissions", soumissionService.getAllSoumissions());
        return "soumissions/all";
    }

    @GetMapping("/new")
    public String showNewSoumissionForm(Model model) {
        model.addAttribute("soumission", new Soumission());
        return "soumissions/new";
    }

    @PostMapping("/save")
    public String saveSoumission(@ModelAttribute("soumission") Soumission soumission) {

        soumissionService.saveSoumission(soumission);
        return "redirect:/soumissions/all";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable(value = "id") long id, Model model) {
        Soumission soumission = soumissionService.getSoumissionById(id);

        model.addAttribute("soumission", soumission);
        model.addAttribute("outside", new Outside());
        return "soumissions/details";
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Soumission soumission = soumissionService.getSoumissionById(id);

        model.addAttribute("soumission", soumission);
        return "soumissions/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteSoumission(@PathVariable(value = "id") long id) {

        this.soumissionService.deleteSoumissionById(id);
        return "redirect:/soumissions/all";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
            @RequestParam("sortDir") String sortDir, Model model) {
        int pageSize = 5;

        Page<Soumission> page = soumissionService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Soumission> listSoumissions = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listSoumissions", listSoumissions);
        return "index";
    }
}
