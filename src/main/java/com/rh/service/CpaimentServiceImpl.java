package com.rh.service;

import java.util.List;
import java.util.Optional;

import com.rh.entity.Contrat;
import com.rh.entity.Cpaiment;
import com.rh.repository.CpaimentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CpaimentServiceImpl implements CpaimentService {

    @Autowired
    private CpaimentRepository cpaimentRepository;

    @Override
    public List<Cpaiment> getAllCpaiments() {
        return cpaimentRepository.findAll();
    }

    @Override
    public Cpaiment getCpaimentById(long id) {
        Optional<Cpaiment> optional = cpaimentRepository.findById(id);
        Cpaiment Cpaiment = null;
        if (optional.isPresent()) {
            Cpaiment = optional.get();
        } else {
            throw new RuntimeException(" Cpaiment not found for id :: " + id);
        }
        return Cpaiment;
    }

    @Override
    public void deleteCpaimentById(long id) {
        this.cpaimentRepository.deleteById(id);
    }

    @Override
    public void saveCpaiment(Cpaiment Cpaiment, Contrat contrat) {
        Cpaiment _Cpaiment = Cpaiment;
        Cpaiment.setContrat(contrat);
        this.cpaimentRepository.save(_Cpaiment);
    }

    @Override
    public List<Cpaiment> getContratCpaiments(Contrat contrat) {
        return cpaimentRepository.findAllByContrat(contrat);
    }
}
