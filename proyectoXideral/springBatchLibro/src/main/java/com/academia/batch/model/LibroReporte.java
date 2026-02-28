package com.academia.batch.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reportes")
public class LibroReporte {

    @Id
    private String id;
    private String nombre;
    private String isbn;
    private String categoria;
    private String autor;
    private Integer paginas;
    private double precio;
    private Integer cantidad;
    private double total;

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
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    @Override
    public String toString() {
        return "Reporte [nombre=" + nombre + ", isbn=" + isbn + ", categoria=" + categoria + ", autor=" + autor
                + ", paginas=" + paginas + ", precio=" + precio + ", cantidad=" + cantidad + ", total=" + total + "]";
    }

    


}
