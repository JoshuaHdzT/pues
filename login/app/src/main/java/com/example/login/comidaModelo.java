package com.example.login;

public class comidaModelo {
    private String nombre,descripcion,precio,categoria;
    private String foto;
    private int imgCantante;

    public comidaModelo() {
    }

    public comidaModelo(String nombre, String descripcion, String precio, String categoria, int imgCantante) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.imgCantante = imgCantante;
    }

    public comidaModelo(String nombre, String descripcion, String precio, String categoria, String foto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getImgCantante() {
        return imgCantante;
    }

    public void setImgCantante(int imgCantante) {
        this.imgCantante = imgCantante;
    }
}
