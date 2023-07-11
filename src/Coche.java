public class Coche {

    private boolean reservado;
    private String tipo;
    private boolean comprado;
    private boolean vendido;



    public Coche(boolean reservado, String tipo, boolean comprado, boolean vendido) {
        this.reservado = reservado;
        this.tipo = tipo;
        this.comprado = comprado;
        this.vendido = vendido;
    }


    public void comprarCoche() {

     }

    public void reservarCoche() {

    }

    public void cambiarExposicion(/*exposicion*/) {

    }

















    // getters and setters



    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }
}

