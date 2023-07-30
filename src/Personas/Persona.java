package Personas;
import Concesionario.Concesionario;

public abstract class Persona {

    protected Concesionario concesionario;
    protected String nombre;
    protected String direccion;
    protected String dni;
    protected String telefono;


    public Persona(Concesionario concesionario, String nombre, String direccion, String dni, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
        this.concesionario = concesionario;
    }
    public Persona (Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    //getter y setter
    public String getNombre() {
        return nombre;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    protected void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getDni() {
        return dni;
    }
    public String getTelefono() {
        return telefono;
    }
    protected void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    @Override
    public String toString() {
        return  "Nombre : " + nombre +
                "  ||  Dni : " + dni +
                "  ||  Dirección : " + direccion +
                "  ||  Telefono : " + telefono;
    }
}

