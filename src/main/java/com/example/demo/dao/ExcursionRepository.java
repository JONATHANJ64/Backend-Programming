package com.example.demo.dao;

import com.example.demo.entities.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


//repository interfaces for the entities that extend JpaRepository
@CrossOrigin("http://localhost:4200")
public interface ExcursionRepository.java extends JpaRepository<Excursion, Long> {
}