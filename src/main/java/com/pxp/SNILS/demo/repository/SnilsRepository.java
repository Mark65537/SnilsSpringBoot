package com.pxp.SNILS.demo.repository;

import com.pxp.SNILS.demo.entity.Snils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SnilsRepository extends JpaRepository<Snils, Integer> {
    public List<Snils> findByNumber(String number);
}
