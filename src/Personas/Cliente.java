package Personas;

import Vehiculos.Coche;
import Concesionario.Concesionario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Persona {

    private List<Coche> cochesComprados;
    private List<Coche> cochesReservados;


    public Cliente(Concesionario concesionario, String nombre, String direccion, String dni, int telefono) {
        super(concesionario,nombre, direccion, dni, telefono);

        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.concesionario = concesionario;

        this.cochesComprados = new ArrayList<>();
        this.cochesReservados = new ArrayList<>();

    }
    public Cliente crearClienteDesdeEntradaUsuario(Scanner scanner) {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el DNI del cliente:");
        String dni = scanner.nextLine();

        System.out.println("Ingrese el domicilio del cliente:");
        String domicilio = scanner.nextLine();

        System.out.println("Ingrese el teléfono del cliente:");
        int telefono = scanner.nextInt();

        return new Cliente(concesionario, nombre,dni,domicilio,telefono);
    }

    public void comprarCoche(Coche coche) {
        cochesComprados.add(coche);

    }

    public void reservarCoche(Coche coche) {
        cochesReservados.add(coche);
        coche.reservar();
    }

    public void cancelarReserva(Coche coche) {
        cochesReservados.remove(coche);
        coche.cancelarReserva();
    }


    // getters and setters


    public List<Coche> getCochesComprados() {
        return cochesComprados;
    }

    public void setCochesComprados(List<Coche> cochesComprados) {
        this.cochesComprados = cochesComprados;
    }

    public List<Coche> getCochesReservados() {
        return cochesReservados;
    }

    public void setCochesReservados(List<Coche> cochesReservados) {
        this.cochesReservados = cochesReservados;
    }
}
