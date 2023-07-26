package Personas;

import Inventario.Exposicion;
import Vehiculos.Coche;

public class DirectorComercial extends Persona {




    public DirectorComercial(String nombre, String direccion, String dni, int telefono) {
        super(nombre, direccion, dni, telefono);
    }

    public void agregarCocheCompradoAListaCliente(Cliente cliente, Coche coche){
        cliente.getCochesComprados().add(coche);
    }

    public void agregarCocheReservadoAListaCliente (Cliente cliente, Coche coche){
        cliente.getCochesReservados().add(coche);
    }

    public void agregarCocheVendidoAListaVendedor (Vendedor vendedor, Coche coche){
        vendedor.getCochesVendidos().add(coche);
    }
    public void agregarCocheAExposicion (Exposicion exposicion, Coche coche){
        exposicion.agregarCoche(coche);
    }
    public void agregarCocheReservadoACliente (Coche coche, Cliente cliente){
        coche.reservar();
    }

    public void agregarCocheCompradoACliente(Cliente cliente1, Coche coche1) {
    }
    //public void


    //queCliente(coche)
    //queCoches(vendedor)
    //cochesStock()
    //venderCoche(coche,vendedor,cliente)
    //reservarCoche(coche,cliente)
    //cambiarExposicion(coche,exposicion)
    //comprar()
    //reservar()
    //cambiarExposicion(exposicion)
    //resolver()
    //anadirCoche(coche)
    //borrarCoche(coche)


}