public class DirectorComercial extends Persona{




    public DirectorComercial(String nombre, String direccion, String dni, int telefono) {
        super(nombre, direccion, dni, telefono);
    }

    public void agregarCocheCompradoACliente(Cliente cliente, Coche coche){
        cliente.getCochesComprados().add(coche);
    }

    public void agregarCocheReservadoACliente (Cliente cliente, Coche coche){
        cliente.getCochesReservados().add(coche);
    }

    public void agregarCocheVendidoAVendedor (Vendedor vendedor, Coche coche){
        vendedor.getCochesVendidos().add(coche);
    }
    public void agregarCocheAExposicion (Exposicion exposicion, Coche coche){
        exposicion.agregarCoche(coche);
    }


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