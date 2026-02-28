package com.academia.batch.service;

import org.springframework.stereotype.Service;

@Service
public class CalculoService {

    // Simula un cálculo complejo (ej. impuestos, descuentos por categoría, etc.)
    public double calcularPrecioFinal(double precio, int cantidad, String categoria) {
        double subtotal = precio * cantidad;
        double impuesto = 0.16; // 16% IVA

        if ("Educación".equalsIgnoreCase(categoria)) {
            impuesto = 0.05; // Solo 5% para libros educativos
        }

        return subtotal + (subtotal * impuesto);
    }

    public void registrarEnAuditoria(String isbn) {
        // Simula una llamada a un sistema externo de auditoría
        System.out.println("Auditoría: Procesando libro con ISBN " + isbn);
    }
}
