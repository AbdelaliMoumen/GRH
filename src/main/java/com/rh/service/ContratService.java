package com.rh.service;

import java.util.List;

import com.rh.entity.Contrat;
import org.springframework.data.domain.Page;


public interface ContratService {
    List<Contrat> getAllContrats();
    void saveContrat(Contrat contrat);
    Contrat getContratById(long id);
    void deleteContratById(long id);
    Page<Contrat> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
