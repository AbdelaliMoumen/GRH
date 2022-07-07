package com.rh.repository;

import com.rh.entity.Cpaiment;
import com.rh.entity.Contrat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CpaimentRepository extends JpaRepository<Cpaiment, Long> {

  List<Cpaiment> findAllByContrat(Contrat contrat);

}
