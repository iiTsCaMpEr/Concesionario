package Personas;
import Concesionario.Concesionario;
public abstract class Persona {
    protected Concesionario concesionario;
    protected String nombre;
    protected String direccion;
    protected String dni;
    protected int telefono;


    public Persona(Concesionario concesionario, String nombre, String direccion, String dni, int telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
        this.concesionario = concesionario;
    }


    //getter y setter
    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    private void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    private void setDni(String dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    private void setTelefono(int telefono) {
        this.telefono = telefono;
    }


}

