package Personas;

import Concesionario.Concesionario;

public class Mecanico extends Persona {
    public Mecanico (Concesionario concesionario) {
        super(concesionario);

    }
    public Mecanico(Concesionario concesionario, String nombre, String direccion, String dni, int telefono) {
        super(concesionario, nombre, direccion, dni, telefono);
    }
}