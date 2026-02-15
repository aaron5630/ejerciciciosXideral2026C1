package com.academia.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.rest.entity.Alumno;
import com.academia.rest.entity.Libro;
import com.academia.rest.repository.AlumnoRepository;
import com.academia.rest.repository.LibroRepository;
import com.academia.rest.serviceI.LibroService;
@Service
public class LibroServiceImpl implements LibroService{
    @Autowired
    LibroRepository libroRepository;
    @Autowired 
    AlumnoRepository alumnoRepository;
    

    @Override
    public Libro libroById(Integer id) {
        return libroRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("El libro no está registrado."));
    }

    @Override
    public Libro save(Libro libro) {
       // Optional<Libro> libroOptional = libroRepository.findById(libro.getId()); 
       // if (libroOptional.isEmpty()){
            //libroRepository.save(libro);
            //Libro libroRegister = libroRepository.findById(libro.getId()).get();
            //return libroRegister;
        //}
       // throw new IllegalStateException("El libro no está registrado.");
       return libroRepository.save(libro);
    }

    @Override
    public List<Libro> libroAll() {
        return libroRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Libro> libroOptional = libroRepository.findById(id);
        if(libroOptional.isEmpty()){
            throw new IllegalStateException("El libro no está registrado.");
        }
        libroRepository.deleteById(id);
    }

    @Override
    public Libro updateById(Integer id, Libro libro) {
        Optional<Libro> optionalLibro = libroRepository.findById(id);
        if (optionalLibro.isPresent()){
            Libro libroUpdated = optionalLibro.get();
            libroUpdated.setNombre(libro.getNombre());
            libroUpdated.setIsbn(libro.getIsbn());
            libroUpdated.setPaginas(libro.getPaginas());
            libroUpdated.setAutor(libro.getAutor());
            libroUpdated.setFechaDePublicacion(libro.getFechaDePublicacion());
            return libroRepository.save(libroUpdated); 
        }
        throw new IllegalStateException("El libro no se encuentra registrado.");
    }

    @Override
    public Libro prestarLibro(Integer idLibro, Integer idAlumno){
        Libro libroAPrestar = libroById(idLibro);
        if(libroAPrestar.isEsPrestado()){
            throw new IllegalStateException("El libro ya está prestado.");
        }
        Optional<Alumno> alumnoQuierePrestamo = alumnoRepository.findById(idAlumno);
        if (alumnoQuierePrestamo.isEmpty()){
            throw new IllegalStateException("El alumno no existe.");
        }
        libroAPrestar.setAlumno(alumnoQuierePrestamo.get());
        libroAPrestar.setEsPrestado(true);
        return libroRepository.save(libroAPrestar);
    }

    @Override 
    public Libro devolverLibro(Integer idLibro, Integer idAlumno){
        Libro libroADevolver = libroById(idLibro);
        if (!(libroADevolver.isEsPrestado() &&
            libroADevolver.getAlumno().getId().equals(idAlumno))){
                throw new IllegalStateException("El id del alumno no coincide con el libro prestado.");
        }
        libroADevolver.setEsPrestado(false);
        libroADevolver.setAlumno(null);
        return libroRepository.save(libroADevolver);
    }
    


}
