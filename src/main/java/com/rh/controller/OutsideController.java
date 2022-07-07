package com.rh.controller;

import com.rh.entity.Soumission;
import com.rh.entity.Outside;
import com.rh.service.OutsideService;
import com.rh.service.SoumissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/outsides")
public class OutsideController {

    @Autowired
    private OutsideService outsideService;

    @Autowired
    private SoumissionService soumissionService;

    @GetMapping("/all")
    public String index(Model model) {
        model.addAttribute("Outsides", outsideService.getAllOutsides());
        return "outsides/all";
    }

    

    @PostMapping("/save/{soumission_id}")
    public String saveOutside(@ModelAttribute("outside") Outside outside,
            @PathVariable(value = "soumission_id") long id) {
        Soumission soumission = soumissionService.getSoumissionById(id);

        outsideService.saveOutside(outside, soumission);
        return "redirect:/soumissions/details/" + soumission.getId();
    }

    
}
