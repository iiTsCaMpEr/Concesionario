public class Reparacion {

    private String tipoReparacion;
    private boolean reparacionResuelta;



    public Reparacion(String tipoReparacion, boolean reparacionResuelta) {
        this.tipoReparacion = tipoReparacion;
        this.reparacionResuelta = reparacionResuelta;
    }
    public void resolverReparacion () {

    }




    // getters and setters



    public String getTipoReparacion() {
        return tipoReparacion;
    }

    public void setTipoReparacion(String tipoReparacion) {
        this.tipoReparacion = tipoReparacion;
    }

    public boolean isReparacionResuelta() {
        return reparacionResuelta;
    }

    public void setReparacionResuelta(boolean reparacionResuelta) {
        this.reparacionResuelta = reparacionResuelta;
    }
}

// public void CambiarEstadoCoche (CochesStock, isReparacionResuelta)
// public void ReparacionCoche (CochesenReparacion, CochesStock)
// public void ConsultasReparacionesCoche (Coche, ListaCochesReparacion)