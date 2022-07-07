package com.rh.repository;


import com.rh.entity.Employee;
import com.rh.entity.Department;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	  List<Employee> findAllByDepartment(Department department);

	}