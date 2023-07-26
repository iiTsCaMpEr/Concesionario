package Concesionario;

import Inventario.Exposicion;
import Personas.Cliente;
import Personas.DirectorComercial;
import Personas.Persona;
import Personas.Vendedor;
import Vehiculos.Coche;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("");

        //interfaz interfaz = new interfaz();

        DirectorComercial director = new DirectorComercial("makina", "gaga","6657890U", 2345235);
        Coche coche1 = new Coche("opel", "corsa", "12456OY", 342523.80, 2352626.90, "turismo");
        Coche coche2 = new Coche("opel", "astra", "12456OX", 342523.80, 2352626.90, "turismo");
        Cliente cliente1 = new Cliente("paquito", "DireccionCliente1", "DNI2", 547474745);
        Exposicion expo1 = new Exposicion(45,"afag","69798088");
        Vendedor lalo = new Vendedor("Lalo", "fafas", "2352789U", 55566677);

        director.agregarCocheCompradoACliente(cliente1, coche1);
        director.agregarCocheCompradoACliente(cliente1, coche2);
        director.agregarCocheAExposicion(expo1,coche1);

        List<Coche>cochesCompradosCliente1 = cliente1.getCochesComprados();

        List<Coche> cochesPresentes = expo1.getCochesPresentes();
        System.out.println("Los coches que se encuentran en la exposición número " + expo1.getNumeroExposicion() + " son: " + expo1.getCochesPresentes());
        for (Coche coche : cochesPresentes){
            System.out.println(expo1.getCochesPresentes());
        }

        System.out.println("Coches comprados por " + cliente1.getNombre() + ":");
        for (Coche coche : cochesCompradosCliente1){
            System.out.println(coche.getMarca() + " " + coche.getModelo() + " " + coche.getMatricula());
        }




        Concesionario Ademuz = new Concesionario("Ademuz");


        Persona alberto = new Cliente("pedro","calle", "2334433L", 62262262);



    }
}

// TreeSet<Objeto> objetos = new TreeSet<>(new PrecioComparator());
//  Objeto objeto1 = new Objeto( 1, "", 34)
//  Objeto objeto2 = new Objeto( 2, "", 354)
//  Objeto objeto3 = new Objeto( 3, "", 37)

// objetos.add(objeto1)
// objetos.add(objeto2)
// objetos.add(objeto3)
// objetos.add(objeto1)

// TreeSet<Objeto> ObjetosOrdenados = new TreeSet<>(new PrecioComparator());
// for (Objeto j :
//       objeto) {
//       objetosOrdenados.add(j);
//          }
//    return objetosOrdenados;

// for (Objeto j: objetosOrdenados


