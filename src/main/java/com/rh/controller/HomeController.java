package com.rh.controller;

import com.rh.service.CandidateService;
import com.rh.service.EmployeeService;
import com.rh.service.SoumissionService;
import com.rh.service.DepartmentService;
import com.rh.service.ContratService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private CandidateService candidatesService;
  
  @Autowired
  private DepartmentService departmentService;
  
  @Autowired
  private ContratService contratService;
  
  @Autowired
  private SoumissionService soumissionService;
  

  @GetMapping("/login")
  public String login() {
      return "login";
  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("employees", employeeService.getAllEmployees());
    model.addAttribute("candidates", candidatesService.getAllCandidates());
    model.addAttribute("departments", departmentService.getAllDepartments());
    model.addAttribute("contrats", contratService.getAllContrats());
    model.addAttribute("soumissions", soumissionService.getAllSoumissions());
    return "home";
  }
}

/*
@GetMapping("/login")
public String login() {
    return "login";
}

@GetMapping("/")
public String home() {
    return "home";
*/








