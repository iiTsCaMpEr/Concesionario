package Interfaz;

import Inventario.Exposicion;
import Inventario.Reparacion;
import Personas.Cliente;
import Personas.DirectorComercial;
import Concesionario.Concesionario;
import Personas.Mecanico;
import Personas.Vendedor;
import Validaciones.Validaciones;
import Vehiculos.Coche;
import Vehiculos.Estado;


import java.util.List;
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
         director = new DirectorComercial(concesionario, "Director" , ".", "12345678-A", "123456789");
         cliente = new Cliente(concesionario, "Pedro", ".", "11122233-B", "987654321");
         vendedor = new Vendedor(concesionario, "Carlos", ".", "44422211-4", "555111333");
         mecanico = new Mecanico(concesionario , "Paco", ".", "33322211-C", "333222111");
 }
        public void interfazPrograma() {
        Scanner scanner = new Scanner(System.in);


         int opcion = -1;
         while (opcion != 0) {
             mostrarMenuIdentificaion();
             opcion = Validaciones.ValidacionSwitch(scanner);
             scanner.nextLine();


             switch (opcion) {
                 case 1:
                     loginCliente();
                     break;
                 case 2:
                     loginVendedor();
                     break;
                 case 3:
                     interfazDirectorComercial();
                     break;
                 case 4:
                     loginMecanico();
                     break;
                 case 0:
                     System.out.println("¡Hasta luego!");
                     System.exit(0);
             }
         }
     } // identificar tipo de usuario

        public static void mostrarMenuIdentificaion() {
         System.out.println("\n--- IDENTIFIQUESE ---");
         System.out.println("\n--- ¿Que tipo de usuario es? ---");
         System.out.println("1. Cliente");
         System.out.println("2. Vendedor");
         System.out.println("3. Director Comercial");
         System.out.println("4. Mecánico");
         System.out.println("0. Salir");

     }

        private void mostrarMenuDirectorComercial() {
         System.out.println("\n--- Menú Director Comercial ---");
         System.out.println("1. Menu Coches");
         System.out.println("2. Menu Clientes");
         System.out.println("3. Menu Vendedores");
         System.out.println("4. Menu Exposiciones");
         System.out.println("5. Menu Reparaciones");
         System.out.println("6. Otras consultas");
         System.out.println("0. Salir");
     }

             // director comercial
             public void interfazDirectorComercial() {
         Scanner scanner = new Scanner(System.in);


         int opcion = -1;
         while (opcion != 0) {
             mostrarMenuDirectorComercial();
             opcion = Validaciones.ValidacionSwitch(scanner);
             scanner.nextLine();

             switch (opcion) {
                 case 1:
                     iDirectorCoches();
                     break;
                 case 2:
                     iDirectorClientes();
                     break;
                 case 3:
                     iDirectorVendedores();
                     break;
                 case 4:
                     iDirectorExposiciones();
                     break;
                 case 5:
                     iDirectorReparaciones();
                     break;
                 case 6:
                     iDirectorOtrasConsultas();
                     break;
                 case 0:
                     System.out.println("¡Hasta luego!");
                     break;
             }
         }
     }
             private void iDirectorCoches() {
         Scanner scanner = new Scanner(System.in);


         int opcion = -1;
         while (opcion != 0) {
             mostrarMenuDirectorComercialCoches();
             opcion = Validaciones.ValidacionSwitch(scanner);
             scanner.nextLine();

             switch (opcion) {
                 case 1:
                     director.crearCoche();
                     director.cochesEnStock();
                     mensajeTodoCorrecto();
                     break;
                 case 2:
                     director.imprimirCoches();
                     director.modificarCoche();
                     mensajeTodoCorrecto();
                     break;
                 case 3:
                     director.imprimirCoches();
                     director.borrarCoche();
                     mensajeTodoCorrecto();
                     break;
                 case 4:
                     director.cochesEnStock();
                     mensajeTodoCorrecto();
                     break;
                 case 5:
                     director.cochesEnReparacion();
                     mensajeTodoCorrecto();
                     break;
                 case 6:
                     director.cochesEnReserva();
                     mensajeTodoCorrecto();
                     break;
                 case 0:

                     break;
             }
         }
     }
             private void mostrarMenuDirectorComercialCoches () {
         System.out.println("\n--- Menú Coches Del Director Comercial ---");
         System.out.println("1.  Crear coche");
         System.out.println("2.  Modificar Coche");
         System.out.println("3.  Eliminar coche");
         System.out.println("4.  Listar coches en stock");
         System.out.println("5.  Listar coches en reparación");
         System.out.println("6.  Listar coches reservados");
         System.out.println("0.  Salir");
     }
             private void iDirectorExposiciones() {
         Scanner scanner = new Scanner(System.in);


         int opcion = -1;
                 while (opcion != 0) {
             mostrarMenuDirectorComercialExposiciones();
             opcion = Validaciones.ValidacionSwitch(scanner);
             scanner.nextLine();

             switch (opcion) {
                 case 1:
                     director.crearExposicion();
                     mensajeTodoCorrecto();
                     break;
                 case 2:
                     director.modificarExposicion();
                     mensajeTodoCorrecto();
                     break;
                 case 3:
                     director.imprimirExposiciones();
                     director.eliminarExposicion();
                     mensajeTodoCorrecto();
                     break;
                 case 4:
                     director.imprimirExposiciones();
                     mensajeTodoCorrecto();
                     break;
                 case 5:
                     director.imprimirExposiciones();
                     director.queCochesHayEnX_Exposicion();
                     break;
                 case 6:
                     director.darDeAltaCocheA_Exposicion();
                     break;
                 case 7:
                     director.darDeBajaCocheA_Exposicion();
                     break;
                 case 0:

                     break;
             }
         }
     }
             private void mostrarMenuDirectorComercialExposiciones () {
         System.out.println("\n--- Menú de Exposiciones del Director Comercial ---");
         System.out.println("1.  Crear Exposición");
         System.out.println("2.  Modificar Exposición");
         System.out.println("3.  Eliminar Exposición");
         System.out.println("4.  Listar Exposiciones");
         System.out.println("5.  Listar coches en una exposición");
         System.out.println("6.  Dar de alta un coche");
         System.out.println("7.  Dar de baja un coche");
         System.out.println("0.  Salir");
     }
             private void iDirectorReparaciones() {
         Scanner scanner = new Scanner(System.in);


         int opcion = -1;
                 while (opcion != 0) {
             mostrarMenuDirectorComercialReparaciones();
             opcion = Validaciones.ValidacionSwitch(scanner);
             scanner.nextLine();

             switch (opcion) {
                 case 1:
                     director.agregarReparacion();
                     mensajeTodoCorrecto();
                     break;
                 case 2:
                     director.cochesEnReparacion();
                     director.elegirCocheEnReparacion();
                     mensajeTodoCorrecto();
                     break;
                 case 3:
                     director.listarCocheEspecificoEnReparacion();
                     break;
                 case 0:
                     break;
             }
         }
     }
             private void mostrarMenuDirectorComercialReparaciones () {
         System.out.println("\n--- Menú de Reparaciones del Director Comercial ---");
         System.out.println("1. Agregar coche a reparaciones");
         System.out.println("2. Devolver coche a stock");
         System.out.println("0. Consultar reparaciones de cualquier coche");
     }
             private void iDirectorOtrasConsultas() {
         Scanner scanner = new Scanner(System.in);


                 int opcion = -1;
                 while (opcion != 0) {
                     mostrarMenuDirectorComercialOtrasConsultas();
                     opcion = Validaciones.ValidacionSwitch(scanner);
                     scanner.nextLine();
                     switch (opcion) {
                         case 1:
                             break;
                         case 2:
                             break;
                         case 3:
                             break;
                         case 4:
                             break;
                         case 5:
                             break;
                         case 6:
                             break;
                         case 7:
                             break;
                         case 0:

                     break;
             }
         }
     }
             private void mostrarMenuDirectorComercialOtrasConsultas () {
         System.out.println("\n--- Menú de Otras Consultas del Director Comercial ---");
         System.out.println("1.  ");
         System.out.println("0.  Salir");
     }
             private void iDirectorClientes() {
             Scanner scanner = new Scanner(System.in);


             int opcion = -1;
             while (opcion != 0) {
             mostrarMenuDirectorComercialClientes();
             opcion = Validaciones.ValidacionSwitch(scanner);
             scanner.nextLine();

             switch (opcion) {
                 case 1:
                     director.anadirCliente();
                     director.imprimirClientes();
                     mensajeTodoCorrecto();
                     break;
                 case 2:
                     director.modificarCliente();
                     mensajeTodoCorrecto();
                     break;
                 case 3:
                     director.borrarCliente();
                     mensajeTodoCorrecto();
                     break;
                 case 4:
                     director.imprimirClientes();
                     mensajeTodoCorrecto();
                     break;
                 case 5:
                     director.queReservasTieneX_Cliente();
                     mensajeTodoCorrecto();
                     break;
                 case 6:
                     director.queComprasTieneX_Cliente();
                     mensajeTodoCorrecto();
                     break;
                 case 7:
                    director.queClienteComproX_Coche();
                    mensajeTodoCorrecto();
                     break;
                 case 0:

                     break;
             }
         }
     }
             private void mostrarMenuDirectorComercialClientes () {
         System.out.println("\n--- Menú de Clientes el Director Comercial ---");
         System.out.println("1.  Crear cliente");
         System.out.println("2.  Modificar Cliente");
         System.out.println("3.  Eliminar Cliente");
         System.out.println("4.  Listar Clientes");
         System.out.println("5.  Consultar reservas de clientes");
         System.out.println("6.  Consultar compras de clientes");
         System.out.println("7.  Consultar que cliente compró un coche");
         System.out.println("0.  Salir");

     }
             private void iDirectorVendedores() {
         Scanner scanner = new Scanner(System.in);


         int opcion = -1;
         while (opcion != 0) {
             mostrarMenuDirectorComercialVendedores();
             opcion = Validaciones.ValidacionSwitch(scanner);
             scanner.nextLine();

             switch (opcion) {
                 case 1:
                     director.añadirVendedor();
                     director.imprimirVendedores();
                     mensajeTodoCorrecto();
                     break;
                 case 2:director.imprimirVendedores();
                     director.modificarVendedor();
                     mensajeTodoCorrecto();
                     break;
                 case 3:
                     director.imprimirVendedores();
                     director.borrarVendedor();
                     mensajeTodoCorrecto();
                     break;
                 case 4:
                     director.imprimirVendedores();
                     mensajeTodoCorrecto();
                     break;
                 case 5:
                     director.imprimirVendedores();
                     director.queVentasTieneX_Vendedor();
                     mensajeTodoCorrecto();
                     break;
                 case 6:
                     director.obtenerVendedoresOrdenadosPorCochesVendidos();
                     mensajeTodoCorrecto();
                     break;
                 case 7:
                     break;
             }
         }
     }
             private void mostrarMenuDirectorComercialVendedores () {
         System.out.println("\n--- Menú de Vendedores del Director Comercial ---");
         System.out.println("1.  Crear Vendedor");
         System.out.println("2.  Modificar Vendedor");
         System.out.println("3.  Eliminar Vendedor");
         System.out.println("4.  Listar Vendedores");
         System.out.println("5.  Consultar ventas que tiene un vendedor");
         System.out.println("6.  Mostrar vendedores ordenados por coches vendidos");
         System.out.println("0.  Salir");

     }
                 // mecanico
             public static void mostrarMenuMecanico () {
                 System.out.println("\n--- Menú de Mecánico ---");
                 System.out.println("1. Agregar coche a reparaciones");
                 System.out.println("2. Devolver coche a stock");
                 System.out.println("3. Consultar reparaciones de cualquier coche");
                 System.out.println("0. Salir");
             }
             public void loginMecanico () {
         Scanner scanner = new Scanner(System.in);
         System.out.println("¿Es usted un mecanico existente? (S/N)");
         String respuesta = scanner.nextLine();
         if (respuesta.equalsIgnoreCase("S")) {
             String dniMecanico = Validaciones.leerDniMecanico(scanner,concesionario.getMecanicos(), false);
             Mecanico mecanicoExistente = concesionario.buscarMecanicoPorDni(dniMecanico);
             if (mecanicoExistente != null) {
                 interfazMecanico(mecanicoExistente);
             } else {
                 System.out.println("Mecanico no encontrado.");
             }
         } else if (respuesta.equalsIgnoreCase("N")) {
             System.out.println("Crear nuevo mecanico:");

             String nombre = Validaciones.leerNombreMecanicoCompleto(scanner);

             String direccion = Validaciones.leerDireccionMecanico(scanner);

             String dni = Validaciones.leerDniMecanico(scanner,concesionario.getMecanicos(), true);
             System.out.print("Teléfono: ");
             String telefono = Validaciones.leerNumeroEntero(scanner);
             Mecanico nuevoMecanico = new Mecanico(concesionario, nombre, direccion, dni, telefono);
             concesionario.addMecanico(nuevoMecanico);
             System.out.println("¡Nuevo mecánico creado exitosamente!");
         }
     }
             public void interfazMecanico (Mecanico mecanico) {
                 Scanner scanner = new Scanner(System.in);

                 int opcion = -1;
                 while (opcion != 0) {
                     mostrarMenuMecanico();
                     opcion = Validaciones.ValidacionSwitch(scanner);
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
                             mecanico.listarCocheEspecificoEnReparacion();
                             break;
                         case 0:
                             System.out.println("¡Hasta luego!");
                             break;
                     }
                 }
             }
              // cliente
             public static void mostrarMenuCliente () {
         System.out.println("\n--- Menú de Clientes ---");
         System.out.println("1. Consultar coches en stock");
         System.out.println("2. Consultar coches reservados");
         System.out.println("3. Consultar coches comprados");
         System.out.println("0. Salir");
         System.out.print("Selecciona una opción: ");
     }
             public void loginCliente () {
         Scanner scanner = new Scanner(System.in);
         System.out.println("¿Es usted un cliente existente? (S/N)");
         String respuesta = scanner.nextLine();
         if (respuesta.equalsIgnoreCase("S")) {
             String dniCliente = Validaciones.leerDniCliente(scanner,concesionario.getClientes(), false);
             Cliente clienteExistente = concesionario.buscarClientePorDni(dniCliente);
             if (clienteExistente != null) {
                 interfazCliente(clienteExistente);
             } else {
                 System.out.println("Cliente no encontrado.");
             }
         } else if (respuesta.equalsIgnoreCase("N")) {

             System.out.println("Crear nuevo cliente:");

             String nombre = Validaciones.leerNombreClienteCompleto(scanner);

             String direccion = Validaciones.leerDireccionCliente(scanner);

             String dni = Validaciones.leerDniCliente(scanner,concesionario.getClientes(), true);
             System.out.print("Teléfono: ");
             String telefono = Validaciones.leerNumeroEntero(scanner);
             Cliente nuevoCliente = new Cliente(concesionario, nombre, direccion, dni, telefono);
             concesionario.addCliente(nuevoCliente);
             System.out.println("¡Nuevo cliente creado exitosamente!");
         }
     }
             public void interfazCliente (Cliente cliente){
         Scanner scanner = new Scanner(System.in);
         int opcion = -1;
         while (opcion != 0) {
             mostrarMenuCliente();
             opcion = scanner.nextInt();
             scanner.nextLine();
             switch (opcion) {
                 case 1:
                     cliente.imprimirCochesEnVenta();
                     break;
                 case 2:
                     cliente.imprimirCochesReservados();
                     break;
                 case 3:
                     cliente.imprimirCochesComprados();
                 case 0:
                     break;
             }
         }
     }
                // vendedor
             public void mostrarMenuVendedor () {
                 System.out.println("\n--- Menú de Vendedores ---");
                 System.out.println("1. Vender coche");
                 System.out.println("2. Reservar coche");
                 System.out.println("3. Cancelar reserva de cliente");
                 System.out.println("4. Consultas sobre clientes");
                 System.out.println("5. Consultas sobre coches");
                 System.out.println("6. Consultas sobre exposiciones");
                 System.out.println("0. Salir");
             }
             public void interfazVendedor (Vendedor vendedor) {
                 Scanner scanner = new Scanner(System.in);


                 int opcion = -1;
                 while (opcion != 0) {
                     mostrarMenuVendedor();
                     opcion = Validaciones.ValidacionSwitch(scanner);

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
                             interfazVendedorConsultasClientes();
                             break;
                         case 5:
                             interfazVendedorConsultasCoches();
                             break;
                         case 6:
                             interfazVendedorConsultasExposiciones();
                             break;
                         case 0:

                             break;
                     }
                 }
             }
             public void loginVendedor () {
         Scanner scanner = new Scanner(System.in);
         System.out.println("¿Es usted un vendedor existente? (S/N)");
         String respuesta = scanner.nextLine();
         if (respuesta.equalsIgnoreCase("S")) {
             String dniVendedor = Validaciones.leerDniVendedor(scanner,concesionario.getVendedores(),false);
             Vendedor vendedorExistente = concesionario.buscarVendedorPorDni(dniVendedor);
             if (vendedorExistente != null) {
                 interfazVendedor(vendedorExistente);
             } else {
                 System.out.println("Vendedor no encontrado.");
             }
         } else if (respuesta.equalsIgnoreCase("N")) {
             System.out.println("Crear nuevo vendedor:");

             String nombre = Validaciones.leerNombreVendedorCompleto(scanner);

             String direccion = Validaciones.leerDireccionVendedor(scanner);

             String dni = Validaciones.leerDniVendedor(scanner,concesionario.getVendedores(),true);
             System.out.print("Teléfono: ");
             String telefono = Validaciones.leerNumeroEntero(scanner);
             Vendedor nuevoVendedor = new Vendedor(concesionario, nombre, direccion, dni, telefono);
             concesionario.addVendedor(nuevoVendedor);
             System.out.println("¡Nuevo vendedor creado exitosamente!");
         }
     }
             public void mostrarMenuVendedorConsultasClientes () {
         System.out.println("\n--- Menú de clientes de Vendedores ---");
         System.out.println("1.  Listar Clientes");
         System.out.println("2.  Consultar reservas de clientes");
         System.out.println("3.  Consultar compras de clientes");
         System.out.println("0.  Salir");
     }
             public void interfazVendedorConsultasClientes () {
         Scanner scanner = new Scanner(System.in);


         int opcion = -1;
         while (opcion != 0) {
             mostrarMenuVendedorConsultasClientes();
             opcion = Validaciones.ValidacionSwitch(scanner);
             scanner.nextLine();

             switch (opcion) {
                 case 1:
                     vendedor.verListaDeClientes();
                     break;
                 case 2:
                     vendedor.queReservasTieneX_Cliente();
                     break;
                 case 3:
                     vendedor.queComprasTieneX_Cliente();
                     break;
                 case 0:

                     break;
             }
         }
     }
             public void mostrarMenuVendedorConsultasCoches () {
         System.out.println("\n--- Menú de coches de Vendedores ---");
         System.out.println("1.  Ver coches en stock");
         System.out.println("2.  Imprimir coches vendidos");
         System.out.println("3.  Consultar compras de clientes");
         System.out.println("4.  Consultar que cliente compro un coche determinado");
         System.out.println("5.  Consultar que reservas tiene un cliente");
         System.out.println("0.  Salir");

     }
             public void interfazVendedorConsultasCoches () {
         Scanner scanner = new Scanner(System.in);


         int opcion = -1;
                 while (opcion != 0) {
             mostrarMenuVendedorConsultasCoches();
             opcion = Validaciones.ValidacionSwitch(scanner);
             scanner.nextLine();

             switch (opcion) {
                 case 1:
                     vendedor.verCochesEnStock();
                     break;
                 case 2:
                     vendedor.imprimirCochesVendidos();
                     break;
                 case 3:
                     vendedor.queComprasTieneX_Cliente();
                     break;
                 case 4:
                     vendedor.queClienteComproX_Coche();
                     break;
                 case 5:
                     vendedor.queReservasTieneX_Cliente();
                     break;
                 case 6:
                     break;
             }
         }
     }
             public void mostrarMenuVendedorConsultasExposiciones () {
         System.out.println("\n--- Menú de exposiciones de Vendedores ---");
         System.out.println("1.  Listar Exposiciones");
         System.out.println("0.  Salir");;

     }
             public void interfazVendedorConsultasExposiciones () {
         Scanner scanner = new Scanner(System.in);


         int opcion = -1;
         while (opcion != 0) {
             mostrarMenuVendedorConsultasExposiciones();
             opcion = Validaciones.ValidacionSwitch(scanner);
             scanner.nextLine();

             switch (opcion) {
                 case 1:
                     vendedor.imprimirExposiciones();
                     break;
                 case 0:

                     break;
             }
         }
     }
             public void mensajeTodoCorrecto () {
                 System.out.println("Proceso finalizado correctamente");
             }
         }