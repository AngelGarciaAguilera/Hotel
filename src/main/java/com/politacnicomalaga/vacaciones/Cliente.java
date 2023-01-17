/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politacnicomalaga.vacaciones;

/**
 *
 * @author mint
 */
public class Cliente {
    
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String email;
    private String telefono;
    private String fechaNacimiento;
    private byte edad;
    
    public Cliente(String nDni, String nNombre, String nApellidos, String nDireccion, String nEmail, String nTelefono, String nFechaNacimiento, Byte nEdad){
    
        dni = nDni;
        nombre = nNombre;
        apellidos = nApellidos;
        direccion = nDireccion;
        email = nEmail;
        telefono = nTelefono;
        fechaNacimiento = nFechaNacimiento;
        edad = nEdad;
        
    }
    
    //Para generar los getters automáticamente pulsamos ALT+INSERT 
    public String getDni(){
        return dni;
    }
    
    public byte getEdad(){
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }
    
}