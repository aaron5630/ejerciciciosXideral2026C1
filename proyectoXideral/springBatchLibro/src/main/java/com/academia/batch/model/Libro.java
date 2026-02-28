package com.academia.batch.model;

// POJO que representa a un empleado.
// Spring Batch usa los setters para mapear las columnas del CSV a este objeto
// y los getters para escribir los valores en la base de datos.
public class Libro {

    private String nombre;
    private String isbn;
    private String categoria;
    private String autor;
    private Integer paginas;
    private double precio;
    private Integer cantidad;


    public Libro() {
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getIsbn() {
        return isbn;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public String getCategoria() {
        return categoria;
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public String getAutor() {
        return autor;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }


    public Integer getPaginas() {
        return paginas;
    }


    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }


    public double getPrecio() {
        return precio;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public Integer getCantidad() {
        return cantidad;
    }


    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


    @Override
    public String toString() {
        return "Libro [nombre=" + nombre + ", isbn=" + isbn + ", categoria=" + categoria + ", autor=" + autor
                + ", paginas=" + paginas + ", precio=" + precio + ", cantidad=" + cantidad + "]";
    }

   
}
