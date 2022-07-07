package com.rh.service;

import java.util.List;

import com.rh.entity.Soumission;
import org.springframework.data.domain.Page;


public interface SoumissionService {
    List<Soumission> getAllSoumissions();
    void saveSoumission(Soumission soumission);
    Soumission getSoumissionById(long id);
    void deleteSoumissionById(long id);
    Page<Soumission> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
