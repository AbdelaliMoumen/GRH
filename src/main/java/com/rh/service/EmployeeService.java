package com.rh.service;

import java.util.List;

import com.rh.entity.Employee;
import com.rh.entity.Department;

import org.springframework.data.domain.Page;


public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
    
    //
    List<Employee> getDepartmentEmployees(Department department);

    void saveEmployee(Employee employee, Department department);
    
    //
    
}
