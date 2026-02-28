package com.academia.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.academia.batch.model.Libro;
import com.academia.batch.model.LibroReporte;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReporteProcessor implements ItemProcessor<Libro, LibroReporte> {

    private static final Logger log = LoggerFactory.getLogger(ReporteProcessor.class);

    @Override
    public LibroReporte process(Libro libro) {
        LibroReporte reporte = new LibroReporte();
        reporte.setNombre(libro.getNombre());
        reporte.setIsbn(libro.getIsbn());
        reporte.setCategoria(libro.getCategoria());
        reporte.setAutor(libro.getAutor());
        reporte.setPaginas(libro.getPaginas());
        reporte.setPrecio(libro.getPrecio());
        reporte.setCantidad(libro.getCantidad());
        reporte.setTotal(libro.getPrecio()* libro.getCantidad());

        log.info("Step 2 - Reporte: {}", reporte);
        return reporte;
    }
}
