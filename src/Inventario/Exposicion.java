package Inventario;

import java.util.ArrayList;
import Vehiculos.Coche;
import java.util.List;

public class Exposicion {

    private int numeroExposicion;
    private String direccion;
    private String telefono;
    private List<Coche> cochesPresentes;

    public Exposicion(int numeroExposicion, String direccion, String telefono) {
        this.numeroExposicion = numeroExposicion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cochesPresentes = new ArrayList<>();
    }


    public void agregarCoche(Coche coche) {
        cochesPresentes.add(coche);
    }

    public void eliminarCoche(Coche coche) {
        cochesPresentes.remove(coche);
    }


    // Getters y Setters


    public int getNumeroExposicion() {
        return numeroExposicion;
    }

    public void setNumeroExposicion(int numeroExposicion) {
        this.numeroExposicion = numeroExposicion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Coche> getCochesPresentes() {
        return cochesPresentes;
    }

    public void setCochesPresentes(List<Coche> cochesPresentes) {
        this.cochesPresentes = cochesPresentes;
    }
}

