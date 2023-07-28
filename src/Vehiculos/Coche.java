package Vehiculos;

import Inventario.Reparacion;
import Personas.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Coche {
    private String marca;
    private String modelo;
    private String matricula;
    private double precioCompra;
    private double precioVenta;
    private Estado estado;
    private Tipo tipo;
    private List<Reparacion> reparaciones;

    public Coche(){

    }


    public Coche(String marca, String modelo, String matricula, double precioVenta, double precioCompra,  Tipo tipo, Estado estado)  { // constructor para vendedores
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.estado = Estado.Stock;
        this.tipo = tipo;
        this.reparaciones = new ArrayList<>();
    }


    public void agregarReparacion(Reparacion reparacion) {
        reparaciones.add(reparacion);
        estado = Estado.Reparando;

    }

    public void completarReparacion() {
        estado = Estado.Stock;
    }

    // getters and setters


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(List<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}

