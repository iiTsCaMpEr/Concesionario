package Personas;

import Vehiculos.Coche;
import Concesionario.Concesionario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vendedor extends Persona {

    private List<Coche> cochesVendidos;

    public Vendedor(Concesionario concesionario, String nombre, String direccion, String dni, int telefono) {
        super(concesionario, nombre, direccion, dni, telefono);

        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.concesionario = concesionario;

        this.cochesVendidos = new ArrayList<>();
    }

    public  Vendedor crearVendedorDesdeEntradaUsuario(Scanner scanner) {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el DNI del cliente:");
        String dni = scanner.nextLine();

        System.out.println("Ingrese el domicilio del cliente:");
        String domicilio = scanner.nextLine();

        System.out.println("Ingrese el teléfono del cliente:");
        int telefono = scanner.nextInt();

        return new Vendedor(concesionario,nombre,dni,domicilio,telefono);
    }


    public void venderCoche(Coche coche) {
        cochesVendidos.add(coche);
        coche.vender();
    }

    public int calcularSueldo() {
        return cochesVendidos.size() * 200;
    }


    // getters and setters


    public List<Coche> getCochesVendidos() {
        return cochesVendidos;
    }

    public void setCochesVendidos(List<Coche> cochesVendidos) {
        this.cochesVendidos = cochesVendidos;
    }


}
