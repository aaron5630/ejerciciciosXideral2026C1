package com.academia.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.academia.rest.entity.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{
}
