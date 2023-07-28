package Personas;

import Concesionario.Concesionario;
import Inventario.Exposicion;
import Personas.Persona;

import Vehiculos.Coche;
import Vehiculos.Estado;
import Vehiculos.Tipo;

import java.util.HashMap;
import java.util.Scanner;


public class DirectorComercial extends Persona {

    public DirectorComercial (Concesionario concesionario) {
        super(concesionario);
    }


    public DirectorComercial(Concesionario concesionario, String nombre, String direccion, String dni, int telefono) {
        super(concesionario, nombre, direccion, dni, telefono);

    }

        public void crearCoche() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Marca del coche: ");
            String marca = scanner.nextLine();

            System.out.println("Modelo del coche: ");
            String modelo = scanner.nextLine();

            System.out.println("Matricula del coche: ");
            String matricula = scanner.nextLine();

            System.out.println("Precio de venta del coche: ");
            double precioVenta = scanner.nextDouble();

            System.out.println("Precio de compra del coche: ");
            double precioCompra = scanner.nextDouble();

            System.out.println("Tipo de coche: ");
            scanner.nextLine();
            Tipo tipo = Tipo.valueOf(scanner.nextLine());

            HashMap<String, Coche> nuevoCoche = concesionario.getCoches();
            nuevoCoche.put(matricula, new Coche(marca, modelo, matricula, precioVenta, precioCompra, tipo, Estado.Stock));
            concesionario.setCoches(nuevoCoche);
        }
        public void borrarCoche() {
            Scanner scanner = new Scanner(System.in);


            System.out.println("Introduce la matrícula del coche que deseas borrar: ");
            String matricula = scanner.nextLine();


            HashMap<String, Coche> nuevoCoche = concesionario.getCoches();
            nuevoCoche.remove(matricula);
            concesionario.setCoches(nuevoCoche);
        }
        public void cochesEnStock() {

                HashMap<String, Coche> cochesStock = concesionario.listarEnStock();

            for (Coche coche : cochesStock.values()) {

                System.out.println(coche.toString());
            }
        }
        public void cochesEnReserva() {

        HashMap<String, Coche> cochesReservados = concesionario.listarEnReserva();
        for (Coche coche : cochesReservados.values()) {

            System.out.println(coche.toString());
        }
    }
        public void queVentasTieneX_Vendedor() {
            Scanner scanner = new Scanner(System.in);


            System.out.println("A que vendedor desea consultarle las ventas");
            String dni = scanner.nextLine();

            if (concesionario.getClientes().containsKey(dni)){
                Vendedor v = concesionario.getVendedores().get(dni);
                System.out.println("Estos son los coches vendidos por el vendedor: ");
                v.imprimirCochesVendidos();
                v.imprimirSueldo();
            } else {
                System.out.println("El vendedor no existe");
            }
        }
        public void queReservasTieneX_Cliente() {
            Scanner scanner = new Scanner(System.in);


            System.out.println("A que cliente desea consultarle las reservas");
            String dni = scanner.nextLine();

            if (concesionario.getClientes().containsKey(dni)){
                Cliente c = concesionario.getClientes().get(dni);
                c.imprimirCochesReservados();
            } else {
                System.out.println("El cliente no existe");
            }


    }
        public void cochesEnReparacion() {

            HashMap<String, Coche> cochesReparacion = concesionario.listarEnReparacion();

            for (Coche coche : cochesReparacion.values()) {

                System.out.println(coche.toString());
            }
    }
        public void añadirVendedor() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el nombre del vendedor:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el DNI del vendedor:");
            String dni = scanner.nextLine();
            System.out.println("Ingrese el domicilio del vendedor:");
            String domicilio = scanner.nextLine();
            System.out.println("Ingrese el teléfono del vendedor:");
            int telefono = scanner.nextInt();

            HashMap<String, Vendedor> nuevoVendedor = concesionario.getVendedores();
            nuevoVendedor.put(dni, new Vendedor (concesionario, nombre, direccion, dni, telefono));
            concesionario.setVendedores(nuevoVendedor);

        }
        public void anadirCliente(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.println("Direccion del cliente: ");
        String direccion = scanner.nextLine();

        System.out.println("DNI cliente: ");
        String dni = scanner.nextLine();

        System.out.println("Teléfono del cliente: ");
        int telefono = scanner.nextInt();



        HashMap<String, Cliente> nuevoCliente = concesionario.getClientes();
        nuevoCliente.put(dni, new Cliente(concesionario, nombre, direccion, dni, telefono));
        concesionario.setClientes(nuevoCliente);

    }
        public void añadirExposicion() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Número de la exposición: ");
            Integer num = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Direccion de la exposición: ");
            String direccion = scanner.nextLine();

            System.out.println("Teléfono de la exposición: ");
            String telefono = scanner.nextLine();



            HashMap<Integer, Exposicion> nuevaExposicion = concesionario.getExposiciones();
            nuevaExposicion.put(num, new Exposicion(num,direccion,telefono));
            concesionario.setExposiciones(nuevaExposicion);

        }

        public void darDeAltaCocheA_Exposicion() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Introduzca el numero de la exposición: ");
            Integer numExpo = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Introduzca la matrícula del coche que desea añadir: ");
            String matricula = scanner.nextLine();


            if (concesionario.getCoches().containsKey(matricula) &&  (concesionario.getExposiciones().containsKey(numExpo))) {
                Coche coche = concesionario.getCoches().get(matricula);

                Exposicion e = concesionario.getExposiciones().get(numExpo);

                if (coche.getEstado() == Estado.Stock) e.darDeAltaCocheEnExposicion(coche);
            }
    }
        public void darDeBajaCocheA_Exposicion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca el numero de la exposición: ");
        Integer numExpo = scanner.nextInt();

        System.out.println("Introduzca la matrícula del coche que desea dar de baja: ");
        String matricula = scanner.nextLine();

            Exposicion e = concesionario.getExposiciones().get(numExpo);

        if (e.getCochesEnExposicion().contains(matricula) &&  (concesionario.getExposiciones().containsKey(numExpo))) {
            Coche coche = e.getCochesEnExposicion().get(Integer.parseInt(matricula));

            if (coche.getEstado() == Estado.Expuesto) e.darDeBajaCocheDeExposicion(coche);
        }
    }
        public void queCochesHayEnX_Exposicion() {

            concesionario.imprimirExposiciones();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Escriba el numero de exposición de la exposición que desea consultar");
            Integer numExpo = scanner.nextInt();

            if (concesionario.getExposiciones().containsKey(numExpo)){
                Exposicion e = concesionario.getExposiciones().get(numExpo);
                e.mostrarCochesEnExposicion();
            } else {
                System.out.println("La exposición no existe");
            }

        }


    // que vendedor ha vendido más




    //agregarCocheComprado(coche);
    //agregarCocheReservado(coche);
    //agregarCocheVendido(coche);
    //queCliente(coche)
    //queCoches(vendedor)

    //venderCoche(coche,vendedor,cliente)
    //reservarCoche(coche,cliente)
    //cambiarExposicion(coche,exposicion)
    //comprar()
    //reservar()
    //cambiarExposicion(exposicion)
    //resolver()



}