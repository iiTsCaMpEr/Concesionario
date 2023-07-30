package Personas;

import Concesionario.Concesionario;
import Excepciones.InvalidException;
import Excepciones.NoSuchMatriculaException;
import Inventario.Reparacion;
import Inventario.TipoReparacion;
import Vehiculos.Coche;
import Vehiculos.Estado;
import Vehiculos.Tipo;

import java.text.SimpleDateFormat;
import java.util.*;

public class Mecanico extends Persona {
    public Mecanico(Concesionario concesionario) {
        super(concesionario);

    }

    public Mecanico(Concesionario concesionario, String nombre, String direccion, String dni, int telefono) throws InvalidException {
        super(concesionario, nombre, direccion, dni, telefono);
    }

    public void agregarReparacion() {
        Scanner scanner = new Scanner(System.in);
        String matricula;
        do {
            System.out.println("Indique la matrícula del coche que necesite ser reparado");
            matricula = scanner.nextLine();
        } while (matricula.trim().isEmpty());

        TipoReparacion reparacion = null;
        do {
            System.out.println("Elija tipo de reparación: mecanica, electrica, chapa o revision. ");
            String tipoReparacionStr = scanner.nextLine();

            try {
                reparacion = TipoReparacion.valueOf(tipoReparacionStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Tipo de reparación inválido. Por favor, elija mecanica, electrica, chapa o revision.");
            }
        } while (reparacion == null);

        //if (concesionario == null || concesionario.getCoches() == null) {
           // throw new NullPointerException("El concesionario o la lista de coches es nula");   // Comprobar si la lista está vacía
       // }

        Coche coche = concesionario.getCoches().get(matricula);
        if (coche == null) {
            throw new NoSuchMatriculaException("No se encontró ningún coche con esa matrícula");
        }

        Date fechaYHoraDeReparacion = new Date();
        coche.agregarReparacion(fechaYHoraDeReparacion, reparacion);
    }



    public void cochesEnReparacion() {
        if (concesionario==null || concesionario.listarEnReparacion() == null){
            //throw new NullPointerException("El concesionario o la lista de coches en reparación están vacíos");    //Imprimir Null
        }

        HashMap<String, Coche> cochesReparacion = concesionario.listarEnReparacion();

        for (Coche coche : cochesReparacion.values()) {

            System.out.println(coche.toString());

        }
    }

    public void elegirCocheEnReparacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique la matrícula del coche que ha sido reparado");
        String matricula = scanner.nextLine();

        if (concesionario == null || concesionario.getCoches() == null){
           // throw new NullPointerException("El concesionario o la lista de coches en reparación están vacíos");
        }

        Coche coche = concesionario.getCoches().get(matricula);
        if (coche == null){
            throw new NoSuchMatriculaException("\"No se encontró ningún coche con esa matrícula\"");
        }
        coche.setEstado(Estado.Stock);
    }

    public void listarCochesEnReparacion() {
        HashMap<String, Coche> cochesEnReparacion = concesionario.listarEnReparacion();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la matrícula del coche que desea consultar las reparaciones: ");
        String matricula = scanner.nextLine();
        Coche coche = cochesEnReparacion.get(matricula);
        if (coche != null) {
            List<Reparacion> reparaciones = coche.getReparaciones();
            Collections.sort(reparaciones, (r1, r2) -> r2.getFecha().compareTo(r1.getFecha()));
            for (Reparacion reparacion : reparaciones) {
                SimpleDateFormat a = new SimpleDateFormat("dd/MM/yyyy");
                String fechaReparacion = a.format(reparacion.getFecha());
                System.out.println("Fecha de reparación: " + fechaReparacion);
                System.out.println("Tipo de reparación: " + reparacion.getTipo().toString());
                System.out.println("-------------------------");
            }
        } else {
            throw new NoSuchMatriculaException("No se encontró ningún coche con esa matrícula en reparación.");
        }
    }
}

