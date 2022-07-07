package com.rh.service;

import java.util.List;

import com.rh.entity.Employee;
import com.rh.entity.Paiment;

public interface PaimentService {
    List<Paiment> getAllPaiments();

    List<Paiment> getEmployeePaiments(Employee employee);

    void savePaiment(Paiment paiment, Employee employee);

    Paiment getPaimentById(long id);

    void deletePaimentById(long id);
}
