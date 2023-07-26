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
    private String estado;
    private String tipo;
    private List<Reparacion> reparaciones;
    private Cliente clienteQueCompro;

    public Coche(String marca, String modelo, String matricula, double precioCompra, double precioVenta, String tipo) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.estado = "En Venta"; // Por defecto, un coche nuevo está en venta
        this.tipo = tipo;
        this.reparaciones = new ArrayList<>();
    }

    public void agregarReparacion(Reparacion reparacion) {
        reparaciones.add(reparacion);
        estado = "En Reparación";
    }

    public void completarReparacion() {
        estado = "Reparado";
    }

    public void vender() {
        estado = "Vendido";
    }

    public void reservar() {
        estado = "Reservado";
    }

    public void cancelarReserva() {
        estado = "En Venta";
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(List<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }
}

