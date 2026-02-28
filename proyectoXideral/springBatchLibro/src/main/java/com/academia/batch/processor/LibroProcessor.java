package com.academia.batch.processor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.academia.batch.model.Libro;

// El Processor es el componente que transforma cada registro.
// Recibe un Empleado del Reader y devuelve un Empleado transformado al Writer.
public class LibroProcessor implements ItemProcessor<Libro, Libro> {

    private static final Logger log = LoggerFactory.getLogger(LibroProcessor.class);

    @Override
    public Libro process(Libro libro) {
        libro.setNombre(libro.getNombre());
        libro.setIsbn(libro.getIsbn());
        libro.setCategoria(libro.getCategoria());
        libro.setAutor(libro.getAutor());
        libro.setPaginas(libro.getPaginas());
        libro.setPrecio(libro.getPrecio());
        libro.setCantidad(libro.getCantidad());

        log.info("Procesando: {}", libro);
        return libro;
    }
}
