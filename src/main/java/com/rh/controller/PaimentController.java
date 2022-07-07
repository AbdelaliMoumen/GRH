package com.rh.controller;

import com.rh.entity.Employee;
import com.rh.entity.Paiment;
import com.rh.service.PaimentService;
import com.rh.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/paiments")
public class PaimentController {

    @Autowired
    private PaimentService paimentService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public String index(Model model) {
        model.addAttribute("Paiments", paimentService.getAllPaiments());
        return "paiments/all";
    }

    // @GetMapping("/new")
    // public String showNewEmployeeForm(Model model) {
    // model.addAttribute("employee", new Employee());
    // return "employees/new";
    // }

    @PostMapping("/save/{employee_id}")
    public String savePaiment(@ModelAttribute("paiment") Paiment paiment,
            @PathVariable(value = "employee_id") long id) {
        Employee employee = employeeService.getEmployeeById(id);

        paimentService.savePaiment(paiment, employee);
        return "redirect:/employees/details/" + employee.getId();
    }

    // @GetMapping("/details/{id}")
    // public String details(@PathVariable(value = "id") long id, Model model) {
    // Employee employee = paimentService.getEmployeeById(id);

    // model.addAttribute("employee", employee);
    // return "employees/details";
    // }

    // @GetMapping("/edit/{id}")
    // public String showFormForUpdate(@PathVariable(value = "id") long id, Model
    // model) {
    // Employee employee = paimentService.getEmployeeById(id);

    // model.addAttribute("employee", employee);
    // return "employees/edit";
    // }

    // @GetMapping("/delete/{id}")
    // public String deleteEmployee(@PathVariable(value = "id") long id) {

    // this.paimentService.deleteEmployeeById(id);
    // return "redirect:/employees/all";
    // }
}
