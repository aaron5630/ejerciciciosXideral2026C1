package com.academia.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.academia.batch.model.Libro;
import com.academia.batch.model.LibroReporte;
import com.academia.batch.service.CalculoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ReporteProcessor implements ItemProcessor<Libro, LibroReporte> {

    private static final Logger log = LoggerFactory.getLogger(ReporteProcessor.class);

    private final CalculoService calculoService;

    // Inyección por constructor (mejor para pruebas unitarias)
    public ReporteProcessor(CalculoService calculoService) {
        this.calculoService = calculoService;
    }

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
        
        // Usamos el servicio externo (que mockearemos en los tests)
        double totalConImpuestos = calculoService.calcularPrecioFinal(
            libro.getPrecio(), 
            libro.getCantidad(), 
            libro.getCategoria()
        );
        
        reporte.setTotal(totalConImpuestos);
        
        // Llamada a método de auditoría (para demostrar verify() en Mockito)
        calculoService.registrarEnAuditoria(libro.getIsbn());

        log.info("Step 2 - Reporte con Impuestos: {}", reporte);
        return reporte;
    }
}
