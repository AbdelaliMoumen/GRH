package com.rh.service;

import java.util.List;

import com.rh.entity.Department;
import org.springframework.data.domain.Page;


public interface DepartmentService {
    List<Department> getAllDepartments();
    void saveDepartment(Department department);
    Department getDepartmentById(long id);
    void deleteDepartmentById(long id);
    Page<Department> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
