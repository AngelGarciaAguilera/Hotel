/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.politacnicomalaga.vacaciones;

import java.util.ArrayList;

/**
 *
 * @author mint
 */
public class Hotel {
    
    String descripcion;
    String nombre;
    String direccion;
    String email;
    String telefono;
    
    ArrayList<Cliente> clientes;
    
    boolean inexistente = true;

    
    public Hotel(){
    
        clientes = new ArrayList<Cliente>();
        descripcion = "ELAE HOTEL es una gran cadena de hoteles repartidos por España y Guatemala. "
                + "Reconocidos por sus módicos precios, con respecto a la calidad de las instalaciones y la tan amable atención al cliente.";
        nombre = "ELAE HOTEL";
        direccion = "C/Hola, 5";
        email = "elaehotelhola@g.elae.es";
        telefono = "922 693 103";
        
    }
    public void datosHotel(){
        System.out.println(nombre);
        System.out.println(direccion);
        System.out.println(email);
        System.out.println(telefono);
        System.out.println("");
        System.out.println(descripcion);
    }
    public void addCliente(Cliente cliente){
        clientes.add(cliente);
        System.out.println("Cliente registrado.");
    }
    
    public void showLista(){
        for(int i = 0; i < clientes.size(); i++){
            System.out.println("");
            System.out.println("Cliente " + (i+1));
            Cliente cliente = clientes.get(i); //Selecciono el cliente número i
            cliente.informacion(); //Llamo a la función .informacion de la clase Cliente
            System.out.println("");
        }
    }
    
    public void deleteCliente(String dniIn){
        String dniCliente;
        
        for(int i = 0; i < clientes.size(); i++){
            Cliente cliente = clientes.get(i); //Selecciono el cliente número i
            dniCliente = cliente.getDni(); //Pido el DNI del cliente seleccionado y la almaceno en una variable
            //Si el DNI introducido es igual al DNI del cliente seleccionado, lo elimina
            if(dniCliente.equals(dniIn)){
                clientes.remove(i);
                System.out.println("Cliente eliminado.");
                inexistente = false;
            }
        }
        if(inexistente){
            System.out.println("No existe ningún cliente asociado al DNI introducido.");
        }
        inexistente = true;
    }
    
    public void promocion(String dniIn){
        byte edadCliente;
        String dniCliente;
        
        for(int i = 0; i < clientes.size(); i++){
            Cliente cliente = clientes.get(i); //Selecciono el cliente número i
            edadCliente = cliente.getEdad(); //Pido la edad del cliente seleccionado y la almaceno en una variable
            dniCliente = cliente.getDni();
            //Si el DNI del cliente número i es el que se ha introducido, entonces, calcula si puede aplicar la promoción o no.
            if(dniCliente.equals(dniIn)){
                if(edadCliente >= 18 && edadCliente <= 35){
                System.out.println("Este cliente tiene opción a promoción");
                }else{
                    System.out.println("Este cliente no puede aplicar la promoción, ya que no cumple los requisitos. ");
                }
                inexistente = false;
            }
        }
        //Termina el bucle y el DNI introducido no ha coincidido con ninguno, por tanto, no hay ningún cliente con ese DNI.
        if(inexistente){
            System.out.println("No existe ningún cliente asociado al DNI introducido.");
        }
        inexistente = true;
    }
}