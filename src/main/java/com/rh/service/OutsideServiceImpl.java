package com.rh.service;

import java.util.List;
import java.util.Optional;

import com.rh.entity.Soumission;
import com.rh.entity.Outside;
import com.rh.repository.OutsideRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutsideServiceImpl implements OutsideService {

    @Autowired
    private OutsideRepository outsideRepository;

    @Override
    public List<Outside> getAllOutsides() {
        return outsideRepository.findAll();
    }

    @Override
    public Outside getOutsideById(long id) {
        Optional<Outside> optional = outsideRepository.findById(id);
        Outside Outside = null;
        if (optional.isPresent()) {
            Outside = optional.get();
        } else {
            throw new RuntimeException(" Outside not found for id :: " + id);
        }
        return Outside;
    }

    @Override
    public void deleteOutsideById(long id) {
        this.outsideRepository.deleteById(id);
    }

    @Override
    public void saveOutside(Outside Outside, Soumission contrat) {
        Outside _Outside = Outside;
        Outside.setSoumission(contrat);
        this.outsideRepository.save(_Outside);
    }

    @Override
    public List<Outside> getSoumissionOutsides(Soumission contrat) {
        return outsideRepository.findAllBySoumission(contrat);
    }
}
