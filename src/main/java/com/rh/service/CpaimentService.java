package com.rh.service;

import java.util.List;

import com.rh.entity.Contrat;
import com.rh.entity.Cpaiment;

public interface CpaimentService {
    List<Cpaiment> getAllCpaiments();

    List<Cpaiment> getContratCpaiments(Contrat contrat);

    void saveCpaiment(Cpaiment cpaiment, Contrat contrat);

    Cpaiment getCpaimentById(long id);

    void deleteCpaimentById(long id);
}
