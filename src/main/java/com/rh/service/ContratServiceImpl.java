package com.rh.service;

import java.util.List;
import java.util.Optional;

import com.rh.entity.Contrat;
import com.rh.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ContratServiceImpl implements ContratService {

    @Autowired
    private ContratRepository contratRepository;

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public void saveContrat(Contrat contrat) {
        this.contratRepository.save(contrat);
    }

    @Override
    public Contrat getContratById(long id) {
        Optional<Contrat> optional = contratRepository.findById(id);
        Contrat contrat = null;
        if (optional.isPresent()) {
            contrat = optional.get();
        } else {
            throw new RuntimeException(" Contrat not found for id :: " + id);
        }
        return contrat;
    }

    @Override
    public void deleteContratById(long id) {
        this.contratRepository.deleteById(id);
    }

    @Override
    public Page<Contrat> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.contratRepository.findAll(pageable);
    }
}
