package com.rh.repository;


import com.rh.entity.Soumission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoumissionRepository extends JpaRepository<Soumission, Long>{}
