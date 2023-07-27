package Personas;
import java.util.Map;

import Concesionario.Concesionario;
import Personas.Persona;

import Vehiculos.Coche;


import java.util.HashMap;

import java.util.Scanner;

public class DirectorComercial extends Persona {


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
            String tipo = scanner.nextLine();

            System.out.println("Estado del coche: ");
            String estado = scanner.nextLine();


            HashMap<String, Coche> nuevoCoche = concesionario.getCoches();
            nuevoCoche.put(matricula, new Coche(marca, modelo, matricula, precioVenta, precioCompra, tipo, estado));
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
        public void cochesEnReparacion() {

            HashMap<String, Coche> cochesReparacion = concesionario.listarEnReparacion();

            for (Coche coche : cochesReparacion.values()) {

                System.out.println(coche.toString());
            }
    }

        public void añadirVendedor() {



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