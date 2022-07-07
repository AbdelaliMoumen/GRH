package com.rh.service;

import java.util.List;
import java.util.Optional;

import com.rh.entity.Soumission;
import com.rh.repository.SoumissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SoumissionServiceImpl implements SoumissionService {

    @Autowired
    private SoumissionRepository soumissionRepository;

    @Override
    public List<Soumission> getAllSoumissions() {
        return soumissionRepository.findAll();
    }

    @Override
    public void saveSoumission(Soumission soumission) {
        this.soumissionRepository.save(soumission);
    }

    @Override
    public Soumission getSoumissionById(long id) {
        Optional<Soumission> optional = soumissionRepository.findById(id);
        Soumission soumission = null;
        if (optional.isPresent()) {
            soumission = optional.get();
        } else {
            throw new RuntimeException(" Soumission not found for id :: " + id);
        }
        return soumission;
    }

    @Override
    public void deleteSoumissionById(long id) {
        this.soumissionRepository.deleteById(id);
    }

    @Override
    public Page<Soumission> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.soumissionRepository.findAll(pageable);
    }
}
