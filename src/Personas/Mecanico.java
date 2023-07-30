package Personas;

import Concesionario.Concesionario;
import Excepciones.InvalidException;
import Excepciones.NoSuchMatriculaException;
import Inventario.Reparacion;
import Inventario.TipoReparacion;
import Validaciones.Validaciones;
import Vehiculos.Coche;
import Vehiculos.Estado;
import Vehiculos.Tipo;

import java.text.SimpleDateFormat;
import java.util.*;

public class Mecanico extends Persona {
    public Mecanico(Concesionario concesionario) {
        super(concesionario);

    }

    public Mecanico(Concesionario concesionario, String nombre, String direccion, String dni, String telefono) {
        super(concesionario, nombre, direccion, dni, telefono);
    }

    public void agregarReparacion(){
        Scanner scanner =  new Scanner(System.in);
        String matricula = Validaciones.leerMatricula(scanner, concesionario.getCoches());
        if (concesionario == null || concesionario.listarEnReparacion() == null) {
            throw new NullPointerException("El concesionario o la lista de coches en reparación están vacíos");    //Imprimir Null
        }

        TipoReparacion reparacion = Validaciones.leerTipoReparacion(scanner);

        Coche coche = concesionario.getCoches().get(matricula);
        Date fechaYHoraDeReparacion = new Date();
        coche.agregarReparacion(fechaYHoraDeReparacion,reparacion);

    }


    public void cochesEnReparacion() {
        if (concesionario == null || concesionario.listarEnReparacion() == null) {
            throw new NullPointerException("El concesionario o la lista de coches en reparación están vacíos");    //Imprimir Null
        }

        HashMap<String, Coche> cochesReparacion = concesionario.listarEnReparacion();

        for (Coche coche : cochesReparacion.values()) {

            System.out.println(coche.toString());

        }
    }

    public void elegirCocheEnReparacion() {
        Scanner scanner = new Scanner(System.in);

        if (concesionario == null || concesionario.getCoches() == null) {
            throw new NullPointerException("El concesionario o la lista de coches en reparación están vacíos");  //Imprimir Null
        }
        String matricula = Validaciones.leerMatricula(scanner, concesionario.getCoches());

        Coche coche = concesionario.getCoches().get(matricula);
        coche.setEstado(Estado.Stock);
    }

    public void listarCocheEspecificoEnReparacion() {
        HashMap<String, Coche> cochesEnReparacion = concesionario.listarEnReparacion();
        cochesEnReparacion();
        Scanner scanner = new Scanner(System.in);

        if (concesionario == null || concesionario.getCoches() == null) {
            throw new NullPointerException("El concesionario o la lista de coches en reparación están vacíos");  //Imprimir Null
        }

        String matricula = Validaciones.leerMatricula(scanner, concesionario.getCoches());
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

        }
    }
}

