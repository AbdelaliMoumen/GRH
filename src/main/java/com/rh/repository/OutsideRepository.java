package com.rh.repository;

import com.rh.entity.Outside;
import com.rh.entity.Soumission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutsideRepository extends JpaRepository<Outside, Long> {

  List<Outside> findAllBySoumission(Soumission soumission);

}
