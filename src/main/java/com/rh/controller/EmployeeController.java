package com.rh.controller;

import java.util.List;
import com.rh.entity.Absense;
import com.rh.entity.Department;
import com.rh.entity.Employee;
import com.rh.entity.Paiment;
import com.rh.entity.Vacation;
import com.rh.service.DepartmentService;
import com.rh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletContext;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
    ServletContext servletContext;

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/all")
    public String index(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees/all";
    }

    @GetMapping("/new")
    public String showNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
       
        return "employees/new";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
    	
    	 /*MultipartFile multipartFile = employee.getUserImage();
         if (multipartFile != null || !multipartFile.isEmpty()) {

             String fileName = servletContext.getRealPath("/") + "resources\\files\\" + multipartFile.getOriginalFilename();
             try {
                 multipartFile.transferTo(new File(fileName));
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }*/
    	
    	
        /*Employee emp = employeeService.getEmployeeById(employee.getId());
    	employee.setDepartment(emp.getDepartment());
    	System.out.println(employee.getName());*/
        employeeService.saveEmployee(employee);
        return "redirect:/employees/all";
    }
    
    @PostMapping("/save/{department_id}")
    public String saveEmployee(@ModelAttribute("employee") Employee employee,
            @PathVariable(value = "department_id") long id) {
        Department department = departmentService.getDepartmentById(id);

        employeeService.saveEmployee(employee, department);
        return "redirect:/departments/details/" + department.getId();
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee", employee);
        model.addAttribute("vacation", new Vacation());
        model.addAttribute("absense", new Absense());
        model.addAttribute("department", new Department());
        model.addAttribute("paiment", new Paiment());
        //model.addAttribute("Uploads");
                      
        return "employees/details";
    }
    
    

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee", employee);
        return "employees/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        this.employeeService.deleteEmployeeById(id);
        return "redirect:/employees/all";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
            @RequestParam("sortDir") String sortDir, Model model) {
        int pageSize = 5;

        Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Employee> listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listEmployees", listEmployees);
        return "index";
    }
    
    
    /*
    private final String UPLOAD_DIR = "./uploads/";
    
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes, 
    		@PathVariable(value = "employee_id") long id) {
    	
    	Employee employee = employeeService.getEmployeeById(id);

        // check if file is empty
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/employees/details/" + employee.getId();
        }

        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        // save the file on the local file system
        try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // return success response
        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');

        return "redirect:/employees/details/" + employee.getId();
    }
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
}
