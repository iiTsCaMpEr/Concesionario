package Personas;

import Vehiculos.Coche;
import Concesionario.Concesionario;
import Vehiculos.Estado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Persona {


    private ArrayList<Coche> cochesComprados;
    private ArrayList<Coche> cochesReservados;

    public Cliente (Concesionario concesionario) {
        super(concesionario);
        this.cochesComprados = new ArrayList<>();
        this.cochesReservados = new ArrayList<>();
    }


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

    public void comprarCoche(Coche coche) {
        cochesComprados.add(coche);

    }

    public void reservarCoche(Coche coche) {
        cochesReservados.add(coche);
        coche.setEstado(Estado.Reservado);
    }

    public void cancelarReserva(Coche coche) {
        cochesReservados.remove(coche);
        coche.setEstado(Estado.Stock);
    }
    public  void imprimirCochesReservados() {
        for (Coche coche : cochesReservados){
            System.out.println(coche.toString());
        }
    }


    // getters and setters


    public List<Coche> getCochesComprados() {
        return cochesComprados;
    }

    public void setCochesComprados(ArrayList<Coche> cochesComprados) {
        this.cochesComprados = cochesComprados;
    }

    public List<Coche> getCochesReservados() {
        return cochesReservados;
    }

    public void setCochesReservados(ArrayList<Coche> cochesReservados) {
        this.cochesReservados = cochesReservados;
    }
}
