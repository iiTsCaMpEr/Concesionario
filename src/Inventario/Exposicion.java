package Inventario;

import Concesionario.Concesionario;
import Vehiculos.Coche;
import Vehiculos.Estado;

import java.util.ArrayList;
import java.util.List;

public class Exposicion {

    private Integer numeroExposicion;
    private String direccion;
    private String telefono;
    private ArrayList<Coche> cochesEnExposicion;
    
    public Exposicion(Integer numeroExposicion, String direccion, String telefono) {
        this.numeroExposicion = numeroExposicion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cochesEnExposicion = new ArrayList<>();
    }


    public void darDeAltaCocheEnExposicion(Coche coche){
        cochesEnExposicion.add(coche);
        coche.setEstado(Estado.Expuesto);

    }


    public void darDeBajaCocheDeExposicion(Coche coche) {
        cochesEnExposicion.remove(coche);
        coche.setEstado(Estado.Stock);
    }

    public void mostrarCochesEnExposicion() {
        for (Coche coche : cochesEnExposicion) {
            System.out.println("Los coches expuestos son " + coche.toString());
        }
    }


    // Getters y Setters


    public int getNumeroExposicion() {
        return numeroExposicion;
    }

    public void setNumeroExposicion(Integer numeroExposicion) {
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

    public ArrayList<Coche> getCochesEnExposicion() {
        return cochesEnExposicion;
    }

    public void setCochesEnExposicion(ArrayList<Coche> cochesEnExposicion) {
        this.cochesEnExposicion = cochesEnExposicion;
    }

    @Override
    public String toString() {
        return "Exposicion{" +
                "numeroExposicion=" + numeroExposicion +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}


