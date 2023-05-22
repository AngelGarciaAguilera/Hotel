/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politacnicomalaga.vacaciones;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author mint
 */
public class Hotel {
    
    private String descripcion;
    private String nombre;
    private String direccion;
    private String email;
    private String telefono;
    
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
 
    public Hotel(String nDescripcion, String nNombre, String nDireccion, String nEmail, String nTelefono){
    
        descripcion = nDescripcion;
        nombre = nNombre;
        direccion = nDireccion;
        email = nEmail;
        telefono = nTelefono;
        
    }

    public boolean addCliente(String dni, String nombre, String apellidos, String direccion, String email, String telefono, String fechaNacimiento, Byte edad){
        //Busco si ya existe un cliente con el DNI introducido.
        boolean found = false;
        for(int i = 0; i < clientes.size(); i++){
            Cliente cliente = clientes.get(i); //Selecciono el cliente número i
            //Si el DNI introducido es igual al DNI del cliente seleccionado, devuelve true (o sea, existe un cliente con ese DNI).
            if(cliente.getDni().equals(dni)){
                found = true;
            }
        }
        if(found){
            return false;
        }else{
            Cliente cliente = new Cliente(dni, nombre, apellidos, direccion, email, telefono, fechaNacimiento, edad);
            clientes.add(cliente);
            return true;
        }
    }
    
    /*public void showLista(){
        for(int i = 0; i < clientes.size(); i++){
            System.out.println("");
            System.out.println("Cliente " + (i+1));
            Cliente cliente = clientes.get(i); //Selecciono el cliente número i
            
            System.out.println("\n DNI: " + cliente.getDni() + "\n Nombre: " + cliente.getNombre() + "\n Apellidos: " + cliente.getApellidos() + 
                    "\n Dirección: " + cliente.getDireccion() + "\n e-mail: " + cliente.getEmail() + "\n Teléfono: " + cliente.getTelefono() + 
                    "\n Fecha de nacimiento: " + cliente.getFechaNacimiento() + "\n Edad: " + cliente.getEdad());
            System.out.println("");
        }
    }*/
    
    public Cliente[] mostrarClientes() {
        if (clientes.isEmpty()) {
            return null;
        }
        Cliente[] listaC = new Cliente[clientes.size()];
        return clientes.toArray(listaC);
    }

    public Cliente mostrarClienteDni(String dniIn){
        
        for(int i = 0; i < clientes.size(); i++){
            Cliente cliente = clientes.get(i); //Selecciono el cliente número i
            //Si el DNI introducido es igual al DNI del cliente seleccionado, lo elimina
            if(cliente.getDni().equals(dniIn)){
                return cliente;
            }
        }
        return null;
    }

    public boolean actualizarCliente(String dniIn, String nDni, String nNombre, String nApellidos, String nDireccion, String nEmail, String nTelefono, String nFechaNacimiento, Byte nEdad){
        for(int i = 0; i < clientes.size(); i++){
            Cliente cliente = clientes.get(i); //Selecciono el cliente número i
            if(cliente.getDni().equals(dniIn)){
                cliente.setDni(nDni);
                cliente.setNombre(nNombre);
                cliente.setApellidos(nApellidos);
                cliente.setDireccion(nDireccion);
                cliente.setEmail(nEmail);
                cliente.setTelefono(nTelefono);
                cliente.setFechaNacimiento(nFechaNacimiento);
                cliente.setEdad(nEdad);
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteCliente(String dniIn){

        for(int i = 0; i < clientes.size(); i++){
            Cliente cliente = clientes.get(i); //Selecciono el cliente número i
            //Si el DNI introducido es igual al DNI del cliente seleccionado, lo elimina
            if(cliente.getDni().equals(dniIn)){
                clientes.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean comprobarDni(String dniIn){
        for(int i = 0; i < clientes.size(); i++){
            Cliente cliente = clientes.get(i); //Selecciono el cliente número i
            //Si el DNI introducido es igual al DNI del cliente seleccionado, entonces existe un cliente asociado a ese DNI.
            if(cliente.getDni().equals(dniIn)){
                return true;
            }
        }
        return false;
    }
    public String datosHotel(){
        return "Nombre: " + nombre + "\nDirección: " + direccion + "\nCorreo electrónico: " + email + "\nTeléfono: " + telefono + "\nDescripción: " + descripcion;
    }

    public int promocion(String dniIn){
        
        for(int i = 0; i < clientes.size(); i++){
            Cliente cliente = clientes.get(i); //Selecciono el cliente número i
            //Si el DNI del cliente número i es el que se ha introducido, entonces, calcula si puede aplicar la promoción o no.
            if(cliente.getDni().equals(dniIn)){
                if(cliente.getEdad() >= 18 && cliente.getEdad() <= 35){
                    return 1;
                }else{
                    return 2;
                }
            }
        }
        return 0;
    }
    
    public boolean hacerCSV(String ruta){
        PrintWriter out = null;
        try{
            out = new PrintWriter(new FileWriter(ruta, true));
            out.println(this.toCSV());            
        }catch(IOException io){            
            return false;
        }finally{
            if(out != null){
                out.close();
            }
        }
        return true;
    }
    
    public String toCSV(){
        return "Hotel;" + descripcion + ";" + nombre + ";" + direccion + ";" + email + ";" + telefono + ";";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
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
}