/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.politacnicomalaga.vacaciones;
import java.util.Arrays;
import java.util.InputMismatchException;
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
        String ruta;
        
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
            mostrarMenuPrincipal();            
            opcion = leerStringTeclado(sc);
            
            System.out.println("-------------------------------------------------");
            
            switch (opcion) {
                case "1":
                    //pide datos
                    System.out.println("Introduzca DNI:");
                    dni = leerStringTeclado(sc);
                    
                    System.out.println("Introduzca Nombre:");
                    nombre = leerStringTeclado(sc);
                    
                    System.out.println("Introduzca Apellidos:");
                    apellidos = leerStringTeclado(sc);
                    
                    System.out.println("Introduzca Dirección:");
                    direccion = leerStringTeclado(sc);
                    
                    System.out.println("Introduzca eMail:");
                    email = leerStringTeclado(sc);
                    
                    System.out.println("Introduzca Teléfono:");
                    telefono = leerStringTeclado(sc);
                    
                    System.out.println("Introduzca Fecha de Nacimiento:");
                    fechaNacimiento = leerStringTeclado(sc);
                    
                    System.out.println("Introduzca Edad:");
                    edad = (byte) leerIntTeclado(sc);
                    
                    //Llamo la función .addCliente() de la clase Hotel.
                    
                    if(hotel.addCliente(dni, nombre, apellidos, direccion, email, telefono, fechaNacimiento, edad)){
                        System.out.println("Cliente registrado.");
                    }else{
                        System.out.println("El cliente no se ha podido registrar porque ya existe o alguno de los datos introducidos no es correcto.");
                    }

                    break;//LISTO
                    
                case "2":
                    if(hotel.mostrarClientes() == null){
                        System.out.println("No hay ningún cliente registrado.");
                    }else{
                        for (Cliente c : hotel.mostrarClientes()) {
                            System.out.println(c.toString());
                        }
                    }

                    break;//LISTO
                    
                case "3":
                    System.out.println("Introduzca el DNI del cliente que desea eliminar:");
                    dni = leerStringTeclado(sc);
                    
                    if(hotel.deleteCliente(dni)){
                        System.out.println("Cliente eliminado.");
                    }else{
                        System.out.println("No existe ningún cliente asociado al DNI introducido.");
                    }

                    break;//LISTO

                case "4":
                    System.out.println("Introduzca el DNI del cliente que desea actualizar:");
                    dniIn = leerStringTeclado(sc);

                    if(hotel.comprobarDni(dniIn)){
                        System.out.println("Introduzca el nuevo DNI:");
                        dni = leerStringTeclado(sc);
                        System.out.println("Introduzca el nuevo Nombre:");
                        nombre = leerStringTeclado(sc);
                        System.out.println("Introduzca los nuevos Apellidos:");
                        apellidos = leerStringTeclado(sc);
                        System.out.println("Introduzca la nueva Dirección:");
                        direccion = leerStringTeclado(sc);
                        System.out.println("Introduzca el nuevo e-mail:");
                        email = leerStringTeclado(sc);
                        System.out.println("Introduzca el nuevo Teléfono:");
                        telefono = leerStringTeclado(sc);
                        System.out.println("Introduzca la nueva Fecha de nacimiento:");
                        fechaNacimiento = leerStringTeclado(sc);
                        System.out.println("Introduzca la nueva Edad:");
                        edad = (byte) leerIntTeclado(sc);

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
                    dni = leerStringTeclado(sc);

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
                    dni = leerStringTeclado(sc);
                    
                    Cliente cliente = hotel.mostrarClienteDni(dni);
                    
                    if(cliente == null){
                        System.out.println("No existe ningún cliente asociado al DNI introducido.");
                    }else{
                        System.out.println("\n DNI: " + cliente.getDni() + "\n Nombre: " + cliente.getNombre() + "\n Apellidos: " + cliente.getApellidos() + 
                        "\n Dirección: " + cliente.getDireccion() + "\n e-mail: " + cliente.getEmail() + "\n Teléfono: " + cliente.getTelefono() + 
                        "\n Fecha de nacimiento: " + cliente.getFechaNacimiento() + "\n Edad: " + cliente.getEdad());
                    }

                    break;//LISTO
                /* 
                case "8":
                    System.out.println("Indica la ruta en la que desea guardar el fichero CSV:");
                    ruta = leerStringTeclado(sc);                                        
                    
                    if(hotel.hacerCSV(ruta)){
                        System.out.println("Datos HOTEL añadidos con éxito.");
                    }else{
                        System.out.println("IOException");
                    }
                    for(int i = 0; i < hotel.mostrarClientes().size(); i++){
                        Cliente miCliente = hotel.mostrarClientes().get(i);
                        if(miCliente.hacerCSV(ruta)){
                            System.out.println("Datos CLIENTE añadidos con éxito.");
                        }else{
                            System.out.println("IOException");
                        }
                    }
                    
                    break;
                */    
                case "9":
                    
                    break;
                default:
                    sc.close(); //Cierro la entrada de teclado.
                    menu = false;
                    break;
                                        
            }
        }
    }
    
    private static void mostrarMenuPrincipal() {
	System.out.println("------------------------------------------------- \n");
        System.out.println("1. Crear un nuevo cliente.");
        System.out.println("2. Mostrar lista de todos los clientes.");
        System.out.println("3. Eliminar un cliente.");
        System.out.println("4. Actualizar un  cliente.");
        System.out.println("5. Promoción.");
        System.out.println("6. Datos del Hotel.");
        System.out.println("7. Mostrar cliente por DNI.");
        System.out.println("8. Pasar a fichero CSV.");
        System.out.println("9. Cargar datos de fichero CSV.");
        System.out.println("Otra tecla: SALIR.\n");
        System.out.println("-------------------------------------------------");
        System.out.println("Escoja la tarea a realizar:");
		
    }
	
    //Recogemos un número de teclado, si nos dan algo que no es un número, ponemos -1 para repetir entrada
    private static int leerIntTeclado(Scanner sc) {
	int iOpcion;
	try {
            iOpcion = sc.nextInt();
            sc.nextLine();
	} catch (InputMismatchException e) {
            sc.nextLine();
            return -1;
	}
	return iOpcion;
    }
	
    //Recoger un string de teclado
    private static String leerStringTeclado(Scanner sc) {		
        String sEntrada;
	try {
            sEntrada = sc.nextLine();
	}catch (InputMismatchException e) {
            return "";
	}
        return sEntrada;
    }
    
}