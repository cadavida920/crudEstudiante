package com.modelo;

public class Estudiante {
    private int id;
    private String fechaRegistro;
    private String nombre;
    private String apellido;
    private String celular;
    private String documento;

    public Estudiante(){
    }
    public Estudiante (int id, String fechaRegistro, String nombre, String apellido, String celular, String documento){
        this.id = id;
        this.fechaRegistro = fechaRegistro;
        this.nombre =nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.documento = documento;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
