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
    
    String dni;
    String nombre;
    String apellidos;
    String direccion;
    String email;
    String telefono;
    String fecha;
    byte edad;
    
    public Cliente(String nDni, String nNombre, String nApellidos, String nDireccion, String nEmail, String nTelefono, String nFecha, Byte nEdad){
    
        dni = nDni;
        nombre = nNombre;
        apellidos = nApellidos;
        direccion = nDireccion;
        email = nEmail;
        telefono = nTelefono;
        fecha = nFecha;
        edad = nEdad;
        
    }
    
    public void informacion(){
        System.out.println("\n DNI: " + dni + "\n Nombre: " + nombre + "\n Apellidos: " + apellidos + "\n Dirección: " + direccion + "\n e-mail: " + email + "\n Teléfono: " + telefono + "\n Fecha de nacimiento: " + fecha + "\n Edad: " + edad);
    }
    
    public String getDni(){
        return dni;
    }
    
    public byte getEdad(){
        return edad;
    }
    
}