package com.rh.controller;

import java.util.List;

import com.rh.entity.Employee;
import com.rh.entity.Department;
import com.rh.service.DepartmentService;
import com.rh.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public String index(Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "departments/all";
    }

    @GetMapping("/new")
    public String showNewDepartmentForm(Model model) {
        model.addAttribute("department", new Department());
        return "departments/new";
    }

    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute("department") Department department) {

        departmentService.saveDepartment(department);
        return "redirect:/departments/all";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable(value = "id") long id, Model model) {
        Department department = departmentService.getDepartmentById(id);
        
        
        List<Employee> employees =  employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        
        model.addAttribute("department", department);
        model.addAttribute("employee", new Employee());
        
        
        
        return "departments/details";
    }
    
    /*@PostMapping("/employees/save/{department_id}")
    public String saveEmployee(@ModelAttribute("employee") Employee employee,
            @PathVariable(value = "department_id") long id) {
        Department department = departmentService.getDepartmentById(id);

        employeeService.saveEmployee(employee, department);
        return "redirect:/departments/details/" + department.getId();
    }*/

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Department department = departmentService.getDepartmentById(id);

        model.addAttribute("department", department);
        return "departments/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable(value = "id") long id) {

        this.departmentService.deleteDepartmentById(id);
        return "redirect:/departments/all";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
            @RequestParam("sortDir") String sortDir, Model model) {
        int pageSize = 5;

        Page<Department> page = departmentService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Department> listDepartments = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listDepartments", listDepartments);
        return "index";
    }
}
