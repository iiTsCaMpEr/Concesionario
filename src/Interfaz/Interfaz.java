package Interfaz;

import Personas.DirectorComercial;
import Concesionario.Concesionario;
 import java.util.Scanner;

 public class Interfaz {
     private Concesionario concesionario = new Concesionario();
     private DirectorComercial director = new DirectorComercial(concesionario,"a", "a", "a", 4);

     public Interfaz() {
         Scanner scanner = new Scanner(System.in);
         //inicializarDatosDePrueba(); // Datos de prueba

         // identificar tipo de usuario

         int opcion = -1;
         while (opcion != 0) {
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
                     System.out.println("¡Hasta luego!");
                     System.exit(0);
                     break;
             }
         }

         scanner.close();
     }

     public static void mostrarMenuIdentificaion() {
         System.out.println("\n--- IDENTIFIQUESE ---");
         System.out.println("\n--- ¿Que tipo de usuario es? ---");
         System.out.println("1. Personas.Cliente");
         System.out.println("2. Personas.Vendedor");
         System.out.println("3. Director Comercial");
         System.out.println("4 . Salir");
         System.out.print("Selecciona una opción: ");
     }

     private void mostrarMenuDirectorComercial() {
         System.out.println("\n--- Menú Director Comercial ---");
         System.out.println("1. Crear coche a concesionario");
         System.out.println("2. Eliminar coche de concesionario");
         System.out.println("3. Listar coches en stock");
         System.out.println("4. Listar coches en reparación");
         System.out.println("5. --------");
         System.out.println("6. --------");
         System.out.println("7. Salir");
         System.out.print("Selecciona una opción: ");
     }

     public void interfazDirectorComercial() {
         Scanner scanner = new Scanner(System.in);


         int opcion = -1;
         while (opcion != 7) {
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
                     listarCochesEnReparacion();
                     break;
                 case 4:
                     //listarCochesVendidosPorVendedor(scanner);
                     break;
                 case 5:
                     //listarClientesConReserva();
                     break;
                 case 6:
                     //clienteQueComproCoche(scanner);
                     break;
                 case 7:
                     System.out.println("¡Hasta luego!");
                     break;
             }
         }
     }

     public static void mostrarMenuCliente() {
         System.out.println("\n--- Menú de Clientes ---");
         System.out.println("1. Reservar coche");
         System.out.println("2. Cancelar reserva");
         System.out.println("3. Ver mis reservas");
         System.out.println("4. Ver mis coches");
         System.out.println("5. Reparar coche");
         System.out.println("6. Ver coches en stock");
         System.out.println("7. Salir");
         System.out.print("Selecciona una opción: ");
     }

     public void interfazCliente() {
         Scanner scanner = new Scanner(System.in);
         // Personas.Cliente nuevoCliente = Personas.Cliente.crearClienteDesdeEntradaUsuario(scanner);
         // concesionario.addCliente(nuevoCliente);


         int opcion = -1;
         while (opcion != 7) {
             mostrarMenuCliente();
             opcion = scanner.nextInt();
             scanner.nextLine();

             switch (opcion) {
                 case 1:
                     concesionario.listarCochesEnVenta();
                     break;
                 case 2:
                     // listarCochesReservados();
                     break;
                 case 3:
                     // listarCochesEnReparacion();
                     break;
                 case 4:
                     // listarCochesVendidosPorVendedor(scanner);
                     break;
                 case 5:
                     // repararCoche(Vehiculos.Coche)
                     break;
                 case 6:
                     // verCochesEnStock()
                     break;
                 case 7:
                     System.out.println("¡Hasta luego!");
                     break;
             }
         }
     }

     public void mostrarMenuReservaCoche() {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Ingrese la matrícula del coche que desea reservar: ");
         String matricula = scanner.nextLine();
         // concesionario.reservarCoche(matricula, cliente.getDni());

     }

     public void mostrarMenuVendedor() {
         System.out.println("\n--- Menú de Personas.Vendedor ---");
         System.out.println("1. Listar coches en venta");
         System.out.println("2. Listar coches reservados");
         System.out.println("3. Listar coches en reparación");
         System.out.println("4. Listar coches vendidos por un vendedor a comisión");
         System.out.println("5. Listar clientes con coches reservados");
         System.out.println("6. Mostrar cliente que compró un coche");
         System.out.println("0. Salir");
         System.out.print("Selecciona una opción: ");
     }

     public void interfazVendedor() {
         Scanner scanner = new Scanner(System.in);




         int opcion = -1;
         while (opcion != 0) {
             mostrarMenuVendedor();
             opcion = scanner.nextInt();
             scanner.nextLine();

             switch (opcion) {
                 case 1:
                     // listarCochesEnVenta();
                     break;
                 case 2:
                     // listarCochesReservados();
                     break;
                 case 3:
                     // listarCochesEnReparacion();
                     break;
                 case 4:
                     // listarCochesVendidosPorVendedor(scanner);
                     break;
                 case 5:
                     System.out.println("¡Hasta luego!");
                     break;
                 default:
                     System.out.println("Opción inválida, por favor intenta nuevamente.");
             }
         }

         scanner.close();
     }

     private void listarCochesEnVenta() {
         concesionario.listarCochesEnVenta();
     }

     private void listarCochesReservados() {
         concesionario.listarCochesReservados();
     }

     private void listarCochesEnReparacion() {
         concesionario.listarCochesEnReparacion();
     }


     // Método para inicializar datos de prueba
   /* private void inicializarDatosDePrueba() {


        concesionario.añadirCoche(new Vehiculos.Coche("opel", "corsa", "4999-HSN", 999,999, "Turismo", "En Venta"));

        Personas.Cliente cliente1 = new Personas.Cliente("peter", "calle bobo", "77666888A",111222333);

        Personas.Vendedor numero1 = new Personas.Vendedor("Carlos", "av la paz", "49180611X",695703282);

        concesionario.addVendedor(numero1);
        concesionario.addCliente(cliente1);
    }
}


    */
 }