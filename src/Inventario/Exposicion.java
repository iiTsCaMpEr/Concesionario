package Inventario;

import Concesionario.Concesionario;
import Vehiculos.Coche;
import Vehiculos.Estado;
import java.util.ArrayList;

public class Exposicion {

    private Integer numeroExposicion;
    private String direccion;
    private String telefono;
    private ArrayList<Coche> cochesEnExposicion;
    private Concesionario concesionario;

    public Exposicion(Concesionario concesionario,Integer numeroExposicion, String direccion, String telefono) {
        this.numeroExposicion = numeroExposicion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cochesEnExposicion = new ArrayList<>();
        this.concesionario = concesionario;
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

    public void setNumeroExposicion(Integer numeroExposicion) {
        this.numeroExposicion = numeroExposicion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public ArrayList<Coche> getCochesEnExposicion() {
        return cochesEnExposicion;
    }
    @Override
    public String toString() {
        return  "Numero Exposición : " + numeroExposicion +
                "  ||  Dirección : " + direccion +
                "  ||  Telefono : " + telefono;
    }
}