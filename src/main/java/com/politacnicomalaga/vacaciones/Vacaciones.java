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
        
        //Cliente
        String dniIn;
        String dni;
        String nombre;
        String apellidos;
        String direccion;
        String email;
        String telefono;
        String fechaNacimiento;
        byte edad;
        
        //Hotel
        Hotel hotel = new Hotel("ELAE HOTEL es una gran cadena de hoteles repartidos por España y Guatemala. Reconocidos por sus módicos precios, con respecto a la calidad de las instalaciones y la tan amable atención al cliente.", 
                "ELAE HOTEL", "C/Hola, 5", "elaehotelhola@g.elae.es", "922 693 103");
        
        while(menu){
            System.out.println("-------------------------------------------------");
            System.out.println("");
            System.out.println("OPCIONES:");
            System.out.println("1. Crear un nuevo cliente.");
            System.out.println("2. Mostrar lista de todos los clientes.");
            System.out.println("3. Eliminar un cliente.");
            System.out.println("4. Actualizar un  cliente.");
            System.out.println("5. Promoción.");
            System.out.println("6. Datos del Hotel.");
            System.out.println("7. Mostrar cliente por DNI.");
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
                    fechaNacimiento = sc.next();
                    sc.reset();
                    
                    System.out.println("Introduzca Edad:");
                    edad = sc.nextByte();
                    sc.reset();
                    
                    //Llamo la función .addCliente() de la clase Hotel.
                    
                    if(hotel.addCliente(dni, nombre, apellidos, direccion, email, telefono, fechaNacimiento, edad)){
                        System.out.println("Cliente registrado.");
                    }else{
                        System.out.println("El cliente no se ha podido registrar porque ya existe o alguno de los datos introducidos no es correcto.");
                    }

                    break;//LISTO
                    
                case "2":
                    if(hotel.mostrarClientes().size() < 1){
                        System.out.println("No hay ningún cliente registrado.");
                    }else{
                        for(int i = 0; i < hotel.mostrarClientes().size(); i++){
                            Cliente cliente = hotel.mostrarClientes().get(i); //Selecciono el cliente número i del Array
                            
                            System.out.println("[" + cliente.getDni() + ", " + cliente.getNombre() + ", " + cliente.getApellidos() + ", " + cliente.getDireccion() + ", " + cliente.getEmail() + ", " + cliente.getTelefono() + ", " + cliente.getFechaNacimiento() + ", " + cliente.getEdad() + "]");
                        }
                    }

                    break;//LISTO
                    
                case "3":
                    System.out.println("Introduzca el DNI del cliente que desea eliminar:");
                    dni = sc.next();
                    sc.reset();
                    
                    if(hotel.deleteCliente(dni)){
                        System.out.println("Cliente eliminado.");
                    }else{
                        System.out.println("No existe ningún cliente asociado al DNI introducido.");
                    }

                    break;//LISTO

                case "4":
                    System.out.println("Introduzca el DNI del cliente que desea actualizar:");
                    dniIn = sc.next();
                    sc.reset();

                    if(hotel.comprobarDni(dniIn)){
                        System.out.println("Introduzca el nuevo DNI:");
                        dni = sc.next();
                        sc.reset();
                        System.out.println("Introduzca el nuevo Nombre:");
                        nombre = sc.next();
                        sc.reset();
                        System.out.println("Introduzca los nuevos Apellidos:");
                        apellidos = sc.next();
                        sc.reset();
                        System.out.println("Introduzca la nueva Dirección:");
                        direccion = sc.next();
                        sc.reset();
                        System.out.println("Introduzca el nuevo e-mail:");
                        email = sc.next();
                        sc.reset();
                        System.out.println("Introduzca el nuevo Teléfono:");
                        telefono = sc.next();
                        sc.reset();
                        System.out.println("Introduzca la nueva Fecha de nacimiento:");
                        fechaNacimiento = sc.next();
                        sc.reset();
                        System.out.println("Introduzca la nueva Edad:");
                        edad = sc.nextByte();
                        sc.reset();

                        hotel.actualizarCliente(dniIn, dni, nombre, apellidos, direccion, email, telefono, fechaNacimiento, edad);
                        System.out.println("Cliente actualizado.");
                    }else{
                        System.out.println("No existe ningún cliente asociado al DNI introducido.");
                    }

                    break;

                case "5":
                    System.out.println("Hay una promoción disponible para los clientes de entre: 18 y 35 años");
                    System.out.println("Tenemos un 20% de descuento del total si reservas una semana");
                    System.out.println("");
                    System.out.println("Introduzca el DNI del cliente al que quiere aplicar la promoción: ");
                    dni = sc.next();
                    sc.reset();

                    if(hotel.promocion(dni) == 1){
                        System.out.println("Este cliente tiene opción a promoción.");
                    }else if(hotel.promocion(dni) == 2){
                        System.out.println("Este cliente no puede aplicar la promoción, ya que no cumple los requisitos.");
                    }else{
                        System.out.println("El DNI introducido no está asociado a ningún cliente.");
                    }

                    break;//LISTO
                    
                case "6":
                    System.out.println(hotel.datosHotel());
                    break;//LISTO
                
                case "7":
                    System.out.println("Introduzca el DNI del cliente que desea mostrar:");
                    dni = sc.next();
                    sc.reset();
                    
                    Cliente cliente = hotel.mostrarClienteDni(dni);
                    
                    if(cliente == null){
                        System.out.println("No existe ningún cliente asociado al DNI introducido.");
                    }else{
                        System.out.println("\n DNI: " + cliente.getDni() + "\n Nombre: " + cliente.getNombre() + "\n Apellidos: " + cliente.getApellidos() + 
                        "\n Dirección: " + cliente.getDireccion() + "\n e-mail: " + cliente.getEmail() + "\n Teléfono: " + cliente.getTelefono() + 
                        "\n Fecha de nacimiento: " + cliente.getFechaNacimiento() + "\n Edad: " + cliente.getEdad());
                    }

                    break;//LISTO
                    
                default:
                    sc.close(); //Cierro la entrada de teclado.
                    menu = false;
                    break;
            }
        }
    }
}