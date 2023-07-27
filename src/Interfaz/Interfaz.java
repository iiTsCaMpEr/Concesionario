package Interfaz;

import Personas.Cliente;
import Personas.DirectorComercial;
import Concesionario.Concesionario;
import Personas.Vendedor;
import Vehiculos.Coche;

import java.util.Scanner;

 public class Interfaz {
     private Concesionario concesionario = new Concesionario();
     private DirectorComercial director = new DirectorComercial(concesionario,"a", "a", "a", 4);

     private Cliente cliente = new Cliente(concesionario, "a","a","a",654);
     private Coche coche = new Coche("a", "b", "23432JHK", 50.00, 60.00,"Turismo", "");

     private Vendedor vendedor = new Vendedor(concesionario,"p","j","12345P",5647475);

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

     }

     public static void mostrarMenuIdentificaion() {
         System.out.println("\n--- IDENTIFÍQUESE ---");
         System.out.println("\n--- ¿Que tipo de usuario es? ---");
         System.out.println("1. Cliente");
         System.out.println("2. Vendedor");
         System.out.println("3. Director Comercial");
         System.out.println("4. Salir");
         System.out.print("Selecciona una opción: ");
     }

     private void mostrarMenuDirectorComercial() {
         System.out.println("\n--- Menú Director Comercial ---");
         System.out.println("1. Crear coche a concesionario");
         System.out.println("2. Eliminar coche de concesionario");
         System.out.println("3. Listar coches en stock");
         System.out.println("4. Listar coches en reparación");
         System.out.println("5. Listar coches reservados");
         System.out.println("6. Añadir cliente");
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
                     listarCochesEnVenta();
                     break;
                 case 4:
                     listarCochesEnReparacion();
                     //listarCochesVendidosPorVendedor(scanner);
                     break;
                 case 5:
                     listarCochesReservados();
                     //listarClientesConReserva();
                     break;
                 case 6:
                     director.anadirCliente();
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
         System.out.println("1. Consultar coches en Stock. ");
         System.out.println("2. Salir. ");


     }

     public void interfazCliente() {
         Scanner scanner = new Scanner(System.in);
         // Personas.Cliente nuevoCliente = Personas.Cliente.crearClienteDesdeEntradaUsuario(scanner);
         // concesionario.addCliente(nuevoCliente);


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
         System.out.println("\n--- Menú de Vendedores ---");
         System.out.println("1. Vender coche");
         System.out.println("2. Reservar coche");
         System.out.println("3. Consultas sobre clientes");
         System.out.println("4. Consultas sobre coches");
         System.out.println("5. Consultas sobre exposiciones");
         System.out.println("6. Salir");
         System.out.print("Selecciona una opción: ");
     }

     public void interfazVendedor() {
         Scanner scanner = new Scanner(System.in);




         int opcion = -1;
         while (opcion != 6) {
             mostrarMenuVendedor();
             opcion = scanner.nextInt();
             scanner.nextLine();

             switch (opcion) {
                 case 1:
                     vendedor.venderCoche(coche);
                     break;
                 case 2:
                    vendedor.reservarCoche();
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
             }
         }

     }

     private void listarCochesEnVenta() {
         director.cochesEnStock();
     }

     private void listarCochesReservados() {
         director.cochesEnReserva();
     }

     private void listarCochesEnReparacion() {
         director.cochesEnReparacion();
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