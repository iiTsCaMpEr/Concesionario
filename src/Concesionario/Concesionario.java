package Concesionario;

import Interfaz.Interfaz;
import Inventario.Exposicion;
import Personas.Cliente;
import Personas.Mecanico;
import Personas.Vendedor;
import Vehiculos.Coche;
import Vehiculos.Estado;

import java.util.ArrayList;
import java.util.HashMap;

public class Concesionario {
    private Interfaz interfaz;
    private HashMap<String, Coche> coches;
    private HashMap<String, Vendedor> vendedores;
    private HashMap<String, Cliente> clientes;
    private HashMap<Integer, Exposicion> exposiciones;
    private HashMap<String, Mecanico> mecanicos;

    public Concesionario() {
        coches = new HashMap<>();
        vendedores = new HashMap<>();
        clientes = new HashMap<>();
        exposiciones = new HashMap<>();
        mecanicos = new HashMap<>();
    }


    // Métodos para agregar coches, vendedores, clientes y exposiciones y vergotas


    public void listarCochesEnVenta() {
        System.out.println("Coches en venta: ");
        for (Coche coche : coches.values()) {
            if (coche.getEstado() == (Estado.Stock))

                System.out.println("Matricula : " + coche.getMatricula() +
                        "  ||  Marca : " + coche.getMarca() +
                        "  ||  Modelo : " + coche.getModelo() +
                        "  ||  Tipo : " + coche.getTipo() +
                        "  ||  Precio compra : " + coche.getPrecioCompra() + " €" +
                        "  ||  Precio venta : " + coche.getPrecioVenta() + " €");

        }
} // para los clientes y vendedores


    public void añadirCoche (Coche coche) {
        coches.put(coche.getMatricula(), coche);
    }

    public void addVendedor(Vendedor vendedor) {
        vendedores.put(vendedor.getDni(), vendedor);
    }
    public void addCliente(Cliente cliente) {
        clientes.put(cliente.getDni(), cliente);
    }
    public void addMecanico(Mecanico mecanico) {
        mecanicos.put(mecanico.getDni(), mecanico);
    }

    public HashMap listarEnStock() {

        System.out.println("Los coches en stock son: ");


        HashMap<String, Coche> cochesEnVenta = new HashMap<>();
        for (Coche coche : coches.values()) {
            if (coche.getEstado() == Estado.Stock) {

                cochesEnVenta.put(coche.getMatricula(), coche);
            }
            }
        return cochesEnVenta;

    } // para el director comercial
    public HashMap listarEnReserva() {

        System.out.println("Los coches en reservados son: ");


        HashMap<String, Coche> cochesReservados = new HashMap<>();
        for (Coche coche : coches.values()) {
            if (coche.getEstado() == Estado.Reservado) {

                cochesReservados.put(coche.getMatricula(), coche);
            }
        }
        return cochesReservados;

    } // para el director comercial
    public HashMap listarEnReparacion() {


        HashMap<String, Coche> cochesReparacion = new HashMap<>();
        for (Coche coche : coches.values()) {
            if (coche.getEstado() == (Estado.Reparando)) {

                cochesReparacion.put(coche.getMatricula(), coche);
            }
        }
        return cochesReparacion;

    } // para el director comercial
    public Coche buscarCochePorMatricula(String matricula) {
        HashMap<String, Coche> coches = getCoches();
        return coches.get(matricula);
    } // para el director comercial
    public Cliente buscarClientePorDni(String dni) {
        HashMap<String, Cliente> clientes = getClientes();
        return clientes.get(dni);
    } // para el director comercial
    public Mecanico buscarMecanicoPorDni(String dni) {
        HashMap<String, Mecanico> mecanico = getMecanicos();
        return mecanico.get(dni);
    }  // para el login
    public Vendedor buscarVendedorPorDni(String dni) {
        HashMap<String, Vendedor> vendedores = getVendedores();
        return vendedores.get(dni);
    } // para el director comercial
    public Exposicion buscarExposicionPorNum(Integer numExpo) {
        HashMap<Integer, Exposicion> exposiciones = getExposiciones();
        return exposiciones.get(numExpo);
    } // para el director comercial
    public Cliente buscarClientePorCocheComprado(Coche coche) {

        for (Cliente cliente : clientes.values()) {

            ArrayList<Coche> cochesComprados = cliente.getCochesComprados();

            if (cochesComprados.contains(coche)) {
                return cliente;
            }
        }
        return null; // Si no se encontró ningún cliente que haya comprado el coche, devolvemos null
    } // para el director comercial

    public void imprimirVendedores() {
        for (Vendedor vendedor : vendedores.values()) {

            System.out.println(vendedor.toString());


        }
    }
    public void imprimirClientes() {
        for (Cliente cliente : clientes.values()) {

            System.out.println(cliente.toString());
        }
    }
    public void imprimirExposiciones() {
        for (Exposicion exposicion : exposiciones.values()) {

            System.out.println(exposicion.toString());
        }
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
    public HashMap<String, Mecanico> getMecanicos() {
        return mecanicos;
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