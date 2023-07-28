package Personas;

import Concesionario.Concesionario;
import Inventario.Reparacion;
import Inventario.TipoReparacion;
import Vehiculos.Coche;
import Vehiculos.Estado;
import Vehiculos.Tipo;

import java.util.*;

public class Mecanico extends Persona {
    public Mecanico(Concesionario concesionario) {
        super(concesionario);

    }

    public Mecanico(Concesionario concesionario, String nombre, String direccion, String dni, int telefono) {
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

    public void elegirCocheParaVerReparaciones(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique la matrícula del coche del cual desea ver las reparaciones");
        String matricula = scanner.nextLine();
        HashMap reparaciones = concesionario.listarEnReparacion();
        ArrayList<Reparacion> reparacionesCoche = new ArrayList<>();

        for(Object reparacion : reparaciones.values()){
            if (concesionario.getCoches().equals(matricula)){
                reparacionesCoche.add((Reparacion) reparacion);
            }
            if (reparacionesCoche.isEmpty()){
                System.out.println("No hay reparaciones en este coche");
            } else {
                reparacionesCoche.sort(Comparator.comparing(Reparacion::getFecha).reversed());
                System.out.println("Reparaciones del coche " + matricula);
                for (Reparacion reparacion1: reparacionesCoche){
                    System.out.println(reparacion.toString());
                }
            }
        }



    }




}