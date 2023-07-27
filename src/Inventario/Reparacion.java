package Inventario;

import java.util.Date;

public class Reparacion {

    private String tipo;
    private Date fecha;

    public Reparacion(String tipo, Date fecha) {
        this.tipo = tipo;
        this.fecha = fecha;
    }

    // Getters y Setters

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}