package com.rh.repository;

import com.rh.entity.Paiment;
import com.rh.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaimentRepository extends JpaRepository<Paiment, Long> {

  List<Paiment> findAllByEmployee(Employee employee);

}
