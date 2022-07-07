package com.rh.service;

import java.util.List;
import java.util.Optional;

import com.rh.entity.Employee;
import com.rh.entity.Vacation;
import com.rh.repository.VacationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationServiceImpl implements VacationService {

    @Autowired
    private VacationRepository vacationRepository;

    @Override
    public List<Vacation> getAllVacations() {
        return vacationRepository.findAll();
    }

    @Override
    public Vacation getVacationById(long id) {
        Optional<Vacation> optional = vacationRepository.findById(id);
        Vacation vacation = null;
        if (optional.isPresent()) {
            vacation = optional.get();
        } else {
            throw new RuntimeException(" Vacation not found for id :: " + id);
        }
        return vacation;
    }

    @Override
    public void deleteVacationById(long id) {
        this.vacationRepository.deleteById(id);
    }

    @Override
    public void saveVacation(Vacation vacation, Employee employee) {
        Vacation _vacation = vacation;
        vacation.setEmployee(employee);
        this.vacationRepository.save(_vacation);
    }

    @Override
    public List<Vacation> getEmployeeVacations(Employee employee) {
        return vacationRepository.findAllByEmployee(employee);
    }
}
