package com.academia.batch.processor;

import com.academia.batch.model.Libro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LibroProcessorTest {

    private LibroProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new LibroProcessor();
    }

    @Test
    void testProcessLibro() {
        // Given
        Libro input = new Libro();
        input.setNombre("El Quijote");
        input.setIsbn("123456789");
        input.setPrecio(25.50);
        input.setCantidad(10);

        // When
        Libro result = processor.process(input);

        // Then
        assertNotNull(result);
        assertEquals("El Quijote", result.getNombre());
        assertEquals("123456789", result.getIsbn());
        assertEquals(25.50, result.getPrecio());
        assertEquals(10, result.getCantidad());
    }
}
