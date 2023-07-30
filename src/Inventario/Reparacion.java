package Inventario;
import Personas.Mecanico;

import java.util.Date;


public class Reparacion {

    private TipoReparacion tipo;
    private Date fecha;

    public Reparacion(TipoReparacion tipo, Date fecha) {
        this.tipo = tipo;
        this.fecha = fecha;
    }


    // Getters y Setters

    public TipoReparacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoReparacion tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}


