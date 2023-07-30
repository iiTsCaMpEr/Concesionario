package Personas;

import Concesionario.Concesionario;
import Excepciones.NoSuchMatriculaException;
import Inventario.Reparacion;
import Inventario.TipoReparacion;
import Vehiculos.Coche;
import Vehiculos.Estado;
import Vehiculos.Tipo;

import java.text.SimpleDateFormat;
import java.util.*;

public class Mecanico extends Persona {

    public Mecanico(Concesionario concesionario, String nombre, String direccion, String dni, String telefono) {
        super(concesionario, nombre, direccion, dni, telefono);
    }

    public void agregarReparacion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique la matrícula del coche que necesite ser reparado");
        String matricula = scanner.nextLine();

        System.out.println("Elija tipo de reparación: mecánica, eléctrica, chapa o revisión. ");
        TipoReparacion reparacion = TipoReparacion.valueOf(scanner.nextLine());

        Coche coche = concesionario.getCoches().get(matricula);
        Date fechaYHoraDeReparacion = new Date();


        coche.agregarReparacion(fechaYHoraDeReparacion,reparacion);
    }
    public void cochesEnReparacion() {

        System.out.println("Los coches en reparacion son: ");

        HashMap<String, Coche> cochesReparacion = concesionario.listarEnReparacion();

        for (Coche coche : cochesReparacion.values()) {

            System.out.println(coche.toString());

        }
    }
    public void elegirCocheEnReparacion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique la matrícula del coche que ha sido reparado");
        String matricula = scanner.nextLine();

        Coche coche = concesionario.getCoches().get(matricula);
        coche.setEstado(Estado.Stock);
    }
        public void listarCocheEspecificoEnReparacion(){
    HashMap<String, Coche> cochesEnReparacion = concesionario.listarEnReparacion();

    cochesEnReparacion();
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

