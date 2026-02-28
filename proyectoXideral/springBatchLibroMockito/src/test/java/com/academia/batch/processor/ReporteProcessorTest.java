package com.academia.batch.processor;

import com.academia.batch.model.Libro;
import com.academia.batch.model.LibroReporte;
import com.academia.batch.service.CalculoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReporteProcessorTest {

    @Mock
    private CalculoService calculoService;

    @InjectMocks
    private ReporteProcessor processor;

    @Test
    @DisplayName("Debería calcular el total usando el servicio mockeado")
    void testProcessReporteComplejo() {
        // GIVEN
        Libro libro = new Libro();
        libro.setNombre("Libro de Prueba");
        libro.setIsbn("ABC-123");
        libro.setPrecio(100.0);
        libro.setCantidad(2);
        libro.setCategoria("Fantasía");

        // Configuramos el mock para que devuelva un valor fijo
        when(calculoService.calcularPrecioFinal(anyDouble(), anyInt(), anyString()))
                .thenReturn(232.0);

        // WHEN
        LibroReporte resultado = processor.process(libro);

        // THEN
        assertNotNull(resultado);
        assertEquals(232.0, resultado.getTotal());
        
        // Verificamos que se llamó a la auditoría con el ISBN correcto
        verify(calculoService).registrarEnAuditoria("ABC-123");
    }

    @Test
    @DisplayName("Debería capturar y validar los argumentos enviados al servicio")
    void testArgumentCaptor() {
        // GIVEN
        Libro libro = new Libro();
        libro.setIsbn("ISBN-999");
        libro.setPrecio(10.0);
        libro.setCantidad(1);
        libro.setCategoria("General");
        
        ArgumentCaptor<String> isbnCaptor = ArgumentCaptor.forClass(String.class);

        // WHEN
        processor.process(libro);

        // THEN
        verify(calculoService).registrarEnAuditoria(isbnCaptor.capture());
        assertEquals("ISBN-999", isbnCaptor.getValue());
    }

    @Test
    @DisplayName("Debería fallar si el servicio lanza una excepción (Simulación de Error)")
    void testServiceException() {
        // GIVEN: Llenamos el libro para evitar NullPointerException por unboxing
        Libro libro = new Libro();
        libro.setIsbn("ERROR-404");
        libro.setPrecio(50.0);
        libro.setCantidad(1);
        libro.setCategoria("Sistemas");

        // IMPORTANTE: El procesador llama primero a calcularPrecioFinal y luego a registrarEnAuditoria.
        // Simulamos que el error ocurre en la auditoría.
        doThrow(new RuntimeException("Error crítico de sistema externo"))
                .when(calculoService).registrarEnAuditoria(anyString());

        // WHEN & THEN
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            processor.process(libro);
        });

        assertEquals("Error crítico de sistema externo", exception.getMessage());
    }
}
