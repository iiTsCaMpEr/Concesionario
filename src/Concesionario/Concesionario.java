package Concesionario;

import Inventario.Exposicion;
import Personas.Cliente;
import Personas.Vendedor;
import Vehiculos.Coche;

import java.util.HashMap;

public class Concesionario {
    private HashMap<String, Coche> coches;
    private HashMap<String, Vendedor> vendedores;
    private HashMap<String, Cliente> clientes;
    private HashMap<Integer, Exposicion> exposiciones;

    public Concesionario() {
        coches = new HashMap<>();
        vendedores = new HashMap<>();
        clientes = new HashMap<>();
        exposiciones = new HashMap<>();
    }


    // Métodos para agregar coches, vendedores, clientes y exposiciones


    // Listado de coches en venta
    public void listarCochesEnVenta() {
        System.out.println("Coches en venta: ");
        for (Coche coche : coches.values()) {
            if (coche.getEstado().equals("En venta"))

                System.out.println(coche.getMarca() + " " + coche.getModelo() + " (Matrícula: " + coche.getMatricula() + ")");

        }
    }

    // Listado de coches reservados
    public void listarCochesReservados() {
        System.out.println("Coches reservados:");
        for (Coche coche : coches.values()) {
            if (coche.getEstado().equals("Reservado")) {
                System.out.println(coche.getMarca() + " " + coche.getModelo() + " (Matrícula: " + coche.getMatricula() + ")");
            }
        }
    }

    // Listado de coches en reparación
    public void listarCochesEnReparacion() {
        System.out.println("Coches en reparación: ");
        for (Coche coche : coches.values()) {
                System.out.println(coche.getMarca() + " " + coche.getModelo() + " (Matrícula: " + coche.getMatricula() + ")");
        }
    }

    // Listado de coches vendidos por un vendedor a comisión
    public void listarCochesVendidosPorVendedor(Vendedor vendedor) {
        System.out.println("Coches vendidos por " + vendedor.getNombre() + ":");
        int contadorCochesVendidos = 0;
        for (Coche coche : vendedor.getCochesVendidos()) {
            System.out.println(coche.getMarca() + " " + coche.getModelo() + " (Matrícula: " + coche.getMatricula() + ")");
            contadorCochesVendidos++;
        }
        System.out.println("Sueldo de " + vendedor.getNombre() + ": " + (contadorCochesVendidos * 200) + " euros");
    }
    // Listado de clientes que tienen un coche reservado
    public void listarClientesConCocheReservado() {
        System.out.println("Coches en venta:");
        for (Coche coche : coches.values()) {
            if (coche.getEstado().equals("Reservado")) {
                System.out.println(coche.getMarca() + " " + coche.getModelo() + " (Matrícula: " + coche.getMatricula() + ")");
            }
        }
    }
    public void reservarCoche(String matricula, String dni) {

            if (coches.containsKey(matricula) && (clientes.containsKey(dni))) {
                Coche coche = coches.get(matricula);
                coches.remove(matricula);
                coche.setEstado("Reservado");

                Cliente cliente = clientes.get(dni);
                cliente.reservarCoche(coche);


            }
        }


    public void añadirCoche (Coche coche) {
        coches.put(coche.getMatricula(), coche);
    }

    public void addVendedor(Vendedor vendedor) {
        vendedores.put(vendedor.getDni(), vendedor);
    }
    public void addCliente(Cliente cliente) {
        clientes.put(cliente.getDni(), cliente);
    }

    public HashMap listarEnStock() { // para el director comercial

        System.out.println("Los coches en stock son: ");


        HashMap<String, Coche> cochesEnVenta = new HashMap<>();
        for (Coche coche : coches.values()) {
            if (coche.getEstado().equals("En venta")) {

                cochesEnVenta.put(coche.getEstado(), coche);
            }
            }
        return cochesEnVenta;

    }
    public HashMap listarEnReserva() {    // para el director comercial

        System.out.println("Los coches en reservados son: ");


        HashMap<String, Coche> cochesReservados = new HashMap<>();
        for (Coche coche : coches.values()) {
            if (coche.getEstado().equals("Reservado")) {

                cochesReservados.put(coche.getEstado(), coche);
            }
        }
        return cochesReservados;

    }
    public HashMap listarEnReparacion() {    // para el director comercial

        System.out.println("Los coches en reparacion son: ");


        HashMap<String, Coche> cochesReparacion = new HashMap<>();
        for (Coche coche : coches.values()) {
            if (coche.getEstado().equals("En reparacion")) {

                cochesReparacion.put(coche.getEstado(), coche);
            }
        }
        return cochesReparacion;

    }


    // getters and setters
    public HashMap<String, Coche> getCoches() {
        return coches;
    }

    public void setCoches(HashMap<String, Coche> coches) {
        this.coches = coches;
    }

    public HashMap<String, Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(HashMap<String, Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public HashMap<Integer, Exposicion> getExposiciones() {
        return exposiciones;
    }

    public void setExposiciones(HashMap<Integer, Exposicion> exposiciones) {
        this.exposiciones = exposiciones;
    }
}