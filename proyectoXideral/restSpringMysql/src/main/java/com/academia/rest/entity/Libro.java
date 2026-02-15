package com.academia.rest.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String isbn;

    @Column(nullable = false)
    private Integer paginas;

    @Column(nullable = false, length = 100)
    private String autor;

    @Column(name = "fecha_de_publicacion", nullable = false)
    private LocalDate fechaDePublicacion;

    @Column(name = "fecha_de_registro", nullable = false, updatable = false)
    private LocalDate fechaDeRegistro;

    @Column(name = "es_prestado", nullable = false)
    private boolean esPrestado;
    
    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = true)
    private Alumno alumno;

    @PrePersist
    protected void onCreate() {
        this.fechaDeRegistro = LocalDate.now();
        if (!this.esPrestado) {
            this.alumno = null; 
        }
    }


    public Libro (){

    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
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


    public Integer getPaginas() {
        return paginas;
    }


    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }


    public String getAutor() {
        return autor;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }


    public LocalDate getFechaDePublicacion() {
        return fechaDePublicacion;
    }


    public void setFechaDePublicacion(LocalDate fechaDePublicacion) {
        this.fechaDePublicacion = fechaDePublicacion;
    }


    public LocalDate getFechaDeRegistro() {
        return fechaDeRegistro;
    }


    public void setFechaDeRegistro(LocalDate fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }


    public boolean isEsPrestado() {
        return esPrestado;
    }


    public void setEsPrestado(boolean esPrestado) {
        this.esPrestado = esPrestado;
    }


    public Alumno getAlumno() {
        return alumno;
    }


    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        result = prime * result + ((paginas == null) ? 0 : paginas.hashCode());
        result = prime * result + ((autor == null) ? 0 : autor.hashCode());
        result = prime * result + ((fechaDePublicacion == null) ? 0 : fechaDePublicacion.hashCode());
        result = prime * result + ((fechaDeRegistro == null) ? 0 : fechaDeRegistro.hashCode());
        result = prime * result + (esPrestado ? 1231 : 1237);
        result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Libro other = (Libro) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        if (paginas == null) {
            if (other.paginas != null)
                return false;
        } else if (!paginas.equals(other.paginas))
            return false;
        if (autor == null) {
            if (other.autor != null)
                return false;
        } else if (!autor.equals(other.autor))
            return false;
        if (fechaDePublicacion == null) {
            if (other.fechaDePublicacion != null)
                return false;
        } else if (!fechaDePublicacion.equals(other.fechaDePublicacion))
            return false;
        if (fechaDeRegistro == null) {
            if (other.fechaDeRegistro != null)
                return false;
        } else if (!fechaDeRegistro.equals(other.fechaDeRegistro))
            return false;
        if (esPrestado != other.esPrestado)
            return false;
        if (alumno == null) {
            if (other.alumno != null)
                return false;
        } else if (!alumno.equals(other.alumno))
            return false;
        return true;
    }

    
    
}
