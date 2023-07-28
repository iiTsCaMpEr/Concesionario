package Interfaz;

import Inventario.Exposicion;
import Personas.Cliente;
import Personas.DirectorComercial;
import Concesionario.Concesionario;
import Personas.Mecanico;
import Personas.Vendedor;
import Vehiculos.Coche;
import Vehiculos.Estado;


import java.util.Scanner;

 public class Interfaz {

     private Concesionario concesionario;
     private DirectorComercial director;
     private Cliente cliente;
     private Coche coche;
     private Vendedor vendedor;
     private Mecanico mecanico;

     public Interfaz() {
         concesionario = new Concesionario();
         director = new DirectorComercial(concesionario);
         cliente = new Cliente(concesionario);
         coche = new Coche();
         vendedor = new Vendedor(concesionario);
         mecanico = new Mecanico(concesionario);
 }
    public void interfazPrograma() {
        Scanner scanner = new Scanner(System.in);
        //inicializarDatosDePrueba(); // Datos de prueba

        // identificar tipo de usuario

         int opcion = -1;
         while (opcion != 5) {
             mostrarMenuIdentificaion();
             opcion = scanner.nextInt();
             scanner.nextLine();


             switch (opcion) {
                 case 1:
                     interfazCliente();
                     break;
                 case 2:
                     interfazVendedor();
                     break;
                 case 3:
                     interfazDirectorComercial();
                     break;
                 case 4:
                     interfazMecanico();
                     break;
                 case 5:
                     System.out.println("¡Hasta luego!");
                     System.exit(0);
             }
         }
     }

     public static void mostrarMenuIdentificaion() {
         System.out.println("\n--- IDENTIFIQUESE ---");
         System.out.println("\n--- ¿Que tipo de usuario es? ---");
         System.out.println("1. Cliente");
         System.out.println("2. Vendedor");
         System.out.println("3. Director Comercial");
         System.out.println("4. Mecánico");
         System.out.println("5. Salir");
         System.out.print("Selecciona una opción: ");
     }

     private void mostrarMenuDirectorComercial() {
         System.out.println("\n--- Menú Director Comercial ---");
         System.out.println("1.  Crear coche a concesionario");
         System.out.println("2.  Eliminar coche de concesionario");
         System.out.println("3.  Listar coches en stock");
         System.out.println("4.  Listar coches en reparación");
         System.out.println("5.  Listar coches reservados");
         System.out.println("6.  Añadir vendedor");
         System.out.println("7.  Añadir cliente");
         System.out.println("8.  Consultar reservas de un cliente determinado");
         System.out.println("9.  Consultar que coches ha vendido un vendedor determinado");
         System.out.println("10. Añadir exposición");
         System.out.println("11. Añadir coche a exposición");
         System.out.println("12. Eliminar coche de exposición");
         System.out.println("13. Mostar que coches hay en una exposición");
         System.out.println("14. Imprimir exposiciones");
         System.out.println("15. Salir");
         System.out.print("Selecciona una opción: ");
     }

     public void interfazDirectorComercial() {
         Scanner scanner = new Scanner(System.in);


         int opcion = -1;
         while (opcion != 15) {
             mostrarMenuDirectorComercial();
             opcion = scanner.nextInt();
             scanner.nextLine();

             switch (opcion) {
                 case 1:
                     concesionario.listarCochesEnVenta();  // coches disponibles para reservar
                     director.crearCoche();
                     concesionario.listarCochesEnVenta();
                     break;
                 case 2:
                     concesionario.listarCochesEnVenta();
                     director.borrarCoche();
                     concesionario.listarCochesEnVenta();
                     break;
                 case 3:
                     director.cochesEnStock();
                     break;
                 case 4:
                     director.cochesEnReparacion();
                     break;
                 case 5:
                     director.cochesEnReserva();
                     break;
                 case 6:
                     director.añadirVendedor();
                     concesionario.imprimirVendedores();
                     //clienteQueComproCoche(scanner);
                     break;
                 case 7:
                     director.anadirCliente();
                     concesionario.imprimirClientes();
                     //clienteQueComproCoche(scanner);
                     break;
                 case 8:
                     director.queReservasTieneX_Cliente();
                     break;
                 case 9:
                     director.queVentasTieneX_Vendedor();
                     break;
                 case 10:
                     director.añadirExposicion();
                     concesionario.imprimirExposiciones();
                     break;
                 case 11:
                     director.darDeAltaCocheA_Exposicion();
                     break;
                 case 12:
                     director.darDeBajaCocheA_Exposicion();
                     break;
                 case 13:
                     director.queCochesHayEnX_Exposicion();

                     break;
                 case 14:
                     concesionario.imprimirExposiciones();
                     break;
                 case 15:
                     System.out.println("¡Hasta luego!");
                     break;
             }
         }
     }

     public static void mostrarMenuMecanico(){
         System.out.println("\n--- Menú de Mecánico ---");
         System.out.println("1. Agregar coche a reparaciones");
         System.out.println("2. Devolver coche a stock");
         System.out.println("3. Consultar reparaciones de cualquier coche");
         System.out.println("4. Salir");
         System.out.print("Selecciona una opción: ");

     }

     public void interfazMecanico() {
         Scanner scanner = new Scanner(System.in);

         int opcion = -1;
         while (opcion != 4) {
             mostrarMenuMecanico();
             opcion = scanner.nextInt();
             scanner.nextLine();

             switch (opcion) {
                 case 1:
                     mecanico.agregarReparacion();
                     break;
                 case 2:
                     mecanico.cochesEnReparacion();
                     mecanico.elegirCocheEnReparacion();
                     break;
                 case 3:
                    // mecanico.elegirCocheParaVerReparaciones(); //no funciona
                     break;
                 case 4:
                     System.out.println("¡Hasta luego!");
                     break;
             }
         }
     }

     public static void mostrarMenuCliente() {
         System.out.println("\n--- Menú de Clientes ---");
         System.out.println("1. Consultar coches en stock");
         System.out.println("2. Salir");
         System.out.print("Selecciona una opción: ");
     }

     public void interfazCliente() {
         Scanner scanner = new Scanner(System.in);

         int opcion = -1;
         while (opcion != 2) {
             mostrarMenuCliente();
             opcion = scanner.nextInt();
             scanner.nextLine();

             switch (opcion) {
                 case 1:
                     concesionario.listarCochesEnVenta();
                     break;
                 case 2:
                     // listarCochesReservados();
                     System.out.println("¡Hasta luego!");
                     break;
             }
         }
     }

     public void mostrarMenuVendedor() {
         System.out.println("\n--- Menú de Vendedores ---");
         System.out.println("1. Vender coche");
         System.out.println("2. Reservar coche");
         System.out.println("3. Cancelar reserva de cliente");
         System.out.println("4. Consultas sobre clientes");
         System.out.println("5. Consultas sobre coches");
         System.out.println("6. Consultas sobre exposiciones");
         System.out.println("7. Salir");
         System.out.print("Selecciona una opción: ");
     }

     public void interfazVendedor() {
         Scanner scanner = new Scanner(System.in);


         int opcion = -1;
         while (opcion != 7) {
             mostrarMenuVendedor();
             opcion = scanner.nextInt();
             scanner.nextLine();

             switch (opcion) {
                 case 1:
                     vendedor.venderCoche();
                     break;
                 case 2:
                     vendedor.reservarCoche();
                     break;
                 case 3:
                     vendedor.cancelarReserva();
                     break;
                 case 4:
                     concesionario.imprimirClientes();
                     break;
                 case 5:
                     director.cochesEnStock();
                     break;
                 case 6:

                     break;
                 case 7:
                     System.out.println("¡Hasta luego!");
                     break;
             }
         }
     }

 }
