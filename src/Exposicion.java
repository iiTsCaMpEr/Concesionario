public class Exposicion {

    private String tipoExpo;
    private int numeroExpo;
    private String telefonoExpo;
    private String direccionExpo;

    public Exposicion(String tipoExpo, int numeroExpo, String telefonoExpo, String direccionExpo) {
        this.tipoExpo = tipoExpo;
        this.numeroExpo = numeroExpo;
        this.telefonoExpo = telefonoExpo;
        this.direccionExpo = direccionExpo;
    }












// getters and setters

    public String getTipoExpo() {
        return tipoExpo;
    }

    public void setTipoExpo(String tipoExpo) {
        this.tipoExpo = tipoExpo;
    }

    public int getNumeroExpo() {
        return numeroExpo;
    }

    public void setNumeroExpo(int numeroExpo) {
        this.numeroExpo = numeroExpo;
    }

    public String getTelefonoExpo() {
        return telefonoExpo;
    }

    public void setTelefonoExpo(String telefonoExpo) {
        this.telefonoExpo = telefonoExpo;
    }

    public String getDireccionExpo() {
        return direccionExpo;
    }

    public void setDireccionExpo(String direccionExpo) {
        this.direccionExpo = direccionExpo;
    }


}
