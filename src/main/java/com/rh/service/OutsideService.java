package com.rh.service;

import java.util.List;

import com.rh.entity.Soumission;
import com.rh.entity.Outside;

public interface OutsideService {
    List<Outside> getAllOutsides();

    List<Outside> getSoumissionOutsides(Soumission soumission);

    void saveOutside(Outside outside, Soumission soumission);

    Outside getOutsideById(long id);

    void deleteOutsideById(long id);
}
