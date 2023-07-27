package Personas;

import Vehiculos.Coche;
import Concesionario.Concesionario;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Persona {

    private HashMap<String, Coche> cochesComprados;
    private HashMap<String, Coche> cochesReservados;


    public Cliente(Concesionario concesionario,String nombre, String direccion, String dni, int telefono) {
        super(concesionario,nombre, direccion, dni, telefono);

        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;

        this.cochesComprados = new HashMap<>();
        this.cochesReservados = new HashMap<>();

    }

    public void comprarCoche(Coche coche) {
        //cochesComprados.put(coche);

    }

    public void reservarCoche(Coche coche) {
        cochesReservados.put(coche.getMatricula(), coche);
        coche.reservar();
    }



    public void cancelarReserva(Coche coche) {
        cochesReservados.remove(coche);
        coche.cancelarReserva();
    }


    // getters and setters


    public HashMap<String, Coche> getCochesComprados() {
        return cochesComprados;
    }

    public void setCochesComprados(HashMap<String, Coche> cochesComprados) {
        this.cochesComprados = cochesComprados;
    }

    public HashMap<String,Coche> getCochesReservados() {
        return cochesReservados;
    }

    public void setCochesReservados(HashMap<String, Coche> cochesReservados) {
        this.cochesReservados = cochesReservados;
    }
}
