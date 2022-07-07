package com.rh.service;

import java.util.List;
import java.util.Optional;

import com.rh.entity.Employee;
import com.rh.entity.Paiment;
import com.rh.repository.PaimentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaimentServiceImpl implements PaimentService {

    @Autowired
    private PaimentRepository paimentRepository;

    @Override
    public List<Paiment> getAllPaiments() {
        return paimentRepository.findAll();
    }

    @Override
    public Paiment getPaimentById(long id) {
        Optional<Paiment> optional = paimentRepository.findById(id);
        Paiment Paiment = null;
        if (optional.isPresent()) {
            Paiment = optional.get();
        } else {
            throw new RuntimeException(" Paiment not found for id :: " + id);
        }
        return Paiment;
    }

    @Override
    public void deletePaimentById(long id) {
        this.paimentRepository.deleteById(id);
    }

    @Override
    public void savePaiment(Paiment Paiment, Employee employee) {
        Paiment _Paiment = Paiment;
        Paiment.setEmployee(employee);
        this.paimentRepository.save(_Paiment);
    }

    @Override
    public List<Paiment> getEmployeePaiments(Employee employee) {
        return paimentRepository.findAllByEmployee(employee);
    }
}
