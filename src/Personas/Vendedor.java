package Personas;
import Inventario.Exposicion;
import Vehiculos.Coche;
import Concesionario.Concesionario;
import Vehiculos.Estado;

import java.util.ArrayList;
import java.util.Scanner;


public class Vendedor extends Persona {
    private ArrayList<Coche> cochesVendidos;

    public Vendedor (Concesionario concesionario) {
        super(concesionario);
        this.cochesVendidos = new ArrayList<>()
        ;

    }
    public Vendedor(Concesionario concesionario, String nombre, String direccion, String dni, String telefono) {
        super(concesionario, nombre, direccion, dni, telefono);
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.concesionario = concesionario;
        this.cochesVendidos = new ArrayList<>();
    }

    // coches
    public void venderCoche() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la matrícula del vehículo que desea vender");
        String matricula = scanner.nextLine();

        System.out.println("Ingrese el DNI del cliente que va a hacer la compra");
        String dni = scanner.nextLine();

        if (concesionario.getCoches().containsKey(matricula) && (concesionario.getClientes().containsKey(dni))) {
            Coche coche = concesionario.getCoches().get(matricula);
            coche.setEstado(Estado.Vendido);

            Cliente cliente = concesionario.getClientes().get(dni);
            cliente.comprarCoche(coche);

            cochesVendidos.add(coche);

        }





        }
    public void cancelarReserva() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente que quiere cancelar su reserva");
        String dni = scanner.nextLine();

        System.out.println("Ingrese la matrícula del vehículo para cancelar su reserva");
        String matricula = scanner.nextLine();

        if (concesionario.getCoches().containsKey(matricula) && (concesionario.getClientes().containsKey(dni))) {
            Coche coche = concesionario.getCoches().get(matricula);
            coche.setEstado(Estado.Stock);


            Cliente cliente = concesionario.getClientes().get(dni);
            cliente.cancelarReserva(coche);

        }
    }
    public void reservarCoche() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la matrícula del vehículo que desea reservar");
        String matricula = scanner.nextLine();

        System.out.println("Ingrese el DNI del cliente que va a hacer la reserva");
        String dni = scanner.nextLine();

        if (concesionario.getCoches().containsKey(matricula) && (concesionario.getClientes().containsKey(dni))) {
            Coche coche = concesionario.getCoches().get(matricula);
            coche.setEstado(Estado.Reservado);

            Cliente cliente = concesionario.getClientes().get(dni);
            cliente.reservarCoche(coche);


        }

    }
    public void imprimirCochesVendidos() {
        for (Coche coche : cochesVendidos){
            System.out.println(coche.toString());
        }
    }
    public void verCochesEnStock() {
        concesionario.listarCochesEnVenta();
    }

    public void imprimirSueldo() {
        int sueldo = cochesVendidos.size() * 200;
        System.out.println("El sueldo del vendedor con DNI" + getDni() + " es :" + sueldo);
    }
    // clientes
    public void verListaDeClientes() {
        concesionario.imprimirClientes();
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
    public void queComprasTieneX_Cliente() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("A que cliente desea consultarle las compras");
        String dni = scanner.nextLine();

        if (concesionario.getClientes().containsKey(dni)){
            Cliente c = concesionario.getClientes().get(dni);
            c.imprimirCochesComprados();
        } else {
            System.out.println("El cliente no existe");
        }
    }
    public void queClienteComproX_Coche() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca la matricula del coche que quiere consultar por quien fue comprado");
        String matricula = scanner.nextLine();

        Coche coche = concesionario.buscarCochePorMatricula(matricula);

        if (coche != null) {
            Cliente clienteComprador = concesionario.buscarClientePorCocheComprado(coche);

            if (clienteComprador != null) {
                System.out.println("El coche con matrícula " + matricula + " fue comprado por:");
                System.out.println("Nombre: " + clienteComprador.getNombre());
                System.out.println("DNI: " + clienteComprador.getDni());
                System.out.println("Dirección: " + clienteComprador.getDireccion());
                System.out.println("Teléfono: " + clienteComprador.getTelefono());
            } else {
                System.out.println("El coche con matrícula " + matricula + " no tiene un cliente asociado.");
            }
        } else {
            System.out.println("El coche con matrícula " + matricula + " no existe en el concesionario.");
        }
    }
    // exposiciones
    public void imprimirExposiciones(){
        concesionario.imprimirExposiciones();
    }


    // getters and setters
    public ArrayList<Coche> getCochesVendidos() {
        return cochesVendidos;
    }
    public void setCochesVendidos(ArrayList<Coche> cochesVendidos) {
        this.cochesVendidos = cochesVendidos;
    }


}