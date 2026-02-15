package com.academia.rest.serviceI;

import java.util.List;

import org.springframework.stereotype.Service;

import com.academia.rest.entity.Libro;

@Service
public interface LibroService {

    Libro libroById(Integer id);

    Libro save(Libro libro);

    List<Libro> libroAll();
    
    void deleteById(Integer id);

    Libro updateById(Integer id, Libro libro);

    Libro prestarLibro(Integer idLibro, Integer idEstudiante);

    Libro devolverLibro(Integer idLibro, Integer idEstudiante);

    
}
