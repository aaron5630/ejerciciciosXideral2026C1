package com.academia.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.academia.rest.entity.Libro;
import com.academia.rest.serviceI.LibroService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    ResponseEntity<List<Libro>> obtenerLibros(){
        return ResponseEntity.ok(libroService.libroAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerLibroPorId(@PathVariable Integer id){
        return ResponseEntity.ok(libroService.libroById(id));
    }

    @PostMapping()
    public ResponseEntity<?> crearLibro (@RequestBody Libro libro) {
        Libro libroCreado = libroService.save(libro);
        return ResponseEntity.ok(libroCreado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarLibroPorId(@PathVariable Integer id, @RequestBody Libro libro){
        Libro libroUpdated = libroService.updateById(id, libro);
        return ResponseEntity.ok(libroUpdated);
        //return libroService.updateById(id, libro).map(ResponseEntity::ok).orElseThrow(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarLibroPorId(@PathVariable Integer id){
        libroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/prestar")
    public ResponseEntity<?> prestarLibro(@RequestParam Integer idLibro, @ RequestParam Integer idAlumno){
        Libro libroPrestado = libroService.prestarLibro(idLibro, idAlumno);
        return ResponseEntity.ok(libroPrestado);
    }

    @PutMapping("/devolver")
    public ResponseEntity<?> devolverLibroLibro(@RequestParam Integer idLibro, @ RequestParam Integer idAlumno){
        Libro libroDevuelto = libroService.devolverLibro(idLibro, idAlumno);
        return ResponseEntity.ok(libroDevuelto);
    }

}
