/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.politacnicomalaga.vacaciones;
import java.util.Scanner;

/**
 *
 * @author mint
 */
public class Vacaciones {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        boolean menu = true;
        String opcion;
        
        String dni;
        String nombre;
        String apellidos;
        String direccion;
        String email;
        String telefono;
        String fecha;
        byte edad;
        
        Hotel hotel = new Hotel();
        
        while(menu){
            System.out.println("-------------------------------------------------");
            System.out.println("");
            System.out.println("OPCIONES:");
            System.out.println("1. Crear un nuevo cliente.");
            System.out.println("2. Mostrar lista de todos los clientes.");
            System.out.println("3. Eliminar un cliente.");
            System.out.println("4. Promoción.");
            System.out.println("5. Datos del Hotel.");
            System.out.println("Otra tecla: SALIR.");
            System.out.println("");
            System.out.println("-------------------------------------------------");
            System.out.println("Escoja la tarea a realizar:");
            
            opcion = sc.next();
            sc.reset();
            
            System.out.println("-------------------------------------------------");
            
            switch (opcion) {
                case "1":
                    //pide datos
                    System.out.println("Introduzca DNI:");
                    dni = sc.next();
                    sc.reset();
                    
                    System.out.println("Introduzca Nombre:");
                    nombre = sc.next();
                    sc.reset();
                    
                    System.out.println("Introduzca Apellidos:");
                    apellidos = sc.next();
                    sc.reset();
                    
                    System.out.println("Introduzca Dirección:");
                    direccion = sc.next();
                    sc.reset();
                    
                    System.out.println("Introduzca eMail:");
                    email = sc.next();
                    sc.reset();
                    
                    System.out.println("Introduzca Teléfono:");
                    telefono = sc.next();
                    sc.reset();
                    
                    System.out.println("Introduzca Fecha de Nacimiento:");
                    fecha = sc.next();
                    sc.reset();
                    
                    System.out.println("Introduzca Edad:");
                    edad = sc.nextByte();
                    sc.reset();
                    
                    //crea el nuevo objeto cliente de la clase Cliente con los datos introducidos.
                    //Recojo los datos que contienen las variables, que he introducido anteriormente, y me las llevo a la clase Cliente.
                    Cliente cliente = new Cliente(dni, nombre, apellidos, direccion, email, telefono, fecha, edad);
                    //Llamo la función .addCliente de la clase Hotel.
                    hotel.addCliente(cliente);
                    break;
                    
                case "2":
                    hotel.showLista();
                    break;
                    
                case "3":
                    System.out.println("Introduzca el DNI del cliente que desea eliminar:");
                    dni = sc.next();
                    sc.reset();
                    hotel.deleteCliente(dni);
                    break;
                    
                case "4":
                    System.out.println("Hay una promoción disponible para los clientes de entre: 18 y 35 años");
                    System.out.println("Tenemos un 20% de descuento del total si reservas una semana");
                    System.out.println("");
                    System.out.println("Introduzca el DNI del cliente al que quiere aplicar la promoción: ");
                    dni = sc.next();
                    sc.reset();
                    hotel.promocion(dni);
                    break;
                    
                case "5":
                    hotel.datosHotel();
                    break;
                    
                default:
                    menu = false;
                    break;
            }
        }
    }
}