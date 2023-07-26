package Personas;
import Vehiculos.Coche;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {

    private List<Coche> cochesComprados;
    private List<Coche> cochesReservados;


    public Cliente(String nombre, String direccion, String dni, int telefono) {
        super(nombre, direccion, dni, telefono);

        //this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;

        this.cochesComprados = new ArrayList<>();
        this.cochesReservados = new ArrayList<>();

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

    private void setCochesComprados(List<Coche> cochesComprados) {
        this.cochesComprados = cochesComprados;
    }

    public List<Coche> getCochesReservados() {
        return cochesReservados;
    }

    public void setCochesReservados(List<Coche> cochesReservados) {
        this.cochesReservados = cochesReservados;
    }
}
