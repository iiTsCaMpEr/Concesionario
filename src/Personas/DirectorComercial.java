package Personas;

import Concesionario.Concesionario;
import Inventario.Exposicion;
import Inventario.Reparacion;
import Inventario.TipoReparacion;

import Validaciones.Validaciones;
import Validaciones.VendedorComparator;
import Vehiculos.Coche;
import Vehiculos.Estado;
import Vehiculos.Tipo;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;


public class DirectorComercial extends Persona {

    public DirectorComercial(Concesionario concesionario, String nombre, String direccion, String dni, String telefono) {
        super(concesionario, nombre, direccion, dni, telefono);
    }

        // coches
        public void crearCoche() {
            Scanner scanner = new Scanner(System.in);


            String marca = Validaciones.leerMarcaCoche(scanner);


            String modelo = Validaciones.leerModeloCoche(scanner);


            String matricula = Validaciones.leerMatricula(scanner,concesionario.getCoches(), true);

            System.out.println("Ingrese un precio de venta: ");
            double precioVenta = Validaciones.leerPreciosCompraYVenta(scanner);

            System.out.println("Ingrese un precio de compra: ");
            double precioCompra = Validaciones.leerPreciosCompraYVenta(scanner);;


            System.out.println("Escoja el tipo de coche: ");
            System.out.println("1. Todoterreno");
            System.out.println("2. Turismo");
            System.out.println("3. Industrial");
            Tipo tipo = null;
            int c = scanner.nextInt();
            switch (c) {
                case 1:
                    tipo = Tipo.Todoterreno;
                    break;
                case 2:
                    tipo = Tipo.Turismo;
                    break;
                case 3:
                    tipo = Tipo.Industrial;
                    break;
            }

            HashMap<String, Coche> nuevoCoche = concesionario.getCoches();
            nuevoCoche.put(matricula, new Coche(marca, modelo, matricula, precioVenta, precioCompra, tipo, Estado.Stock,concesionario));
            concesionario.setCoches(nuevoCoche);
        }
        public void modificarCoche() {
        String matricula; double nuevoPrecioCompra; double nuevoPrecioVenta; int nuevoEstado;
        Scanner scanner = new Scanner(System.in);
        matricula = Validaciones.leerMatricula(scanner, concesionario.getCoches(),true);
        Coche coche = concesionario.buscarCochePorMatricula(matricula);
            if (coche != null) {
                System.out.println("Que desea modificar?");
                System.out.println("1. Precio compra");
                System.out.println("2. Precio venta");
                System.out.println("3. Estado");
                int c = scanner.nextInt();
                switch (c) {
                    case 1:
                        System.out.println("Introduce el nuevo precio de compra");
                        nuevoPrecioCompra = Validaciones.leerPreciosCompraYVenta(scanner);
                        coche.setPrecioCompra(nuevoPrecioCompra);
                        break;
                    case 2:
                        System.out.println("Introduce el nuevo precio de venta");
                        nuevoPrecioVenta = Validaciones.leerPreciosCompraYVenta(scanner);
                        coche.setPrecioVenta(nuevoPrecioVenta);
                        break;
                    case 3:
                        System.out.println("1. Stock");
                        System.out.println("2. Reparando");
                        System.out.println("3. Reservado");
                        System.out.println("4. Expuesto");
                        System.out.println("5. Vendido");
                        nuevoEstado = Validaciones.ValidacionSwitch(scanner);
                        switch (nuevoEstado) {
                            case 1:
                                coche.setEstado(Estado.Stock);
                                break;
                            case 2:
                                coche.setEstado(Estado.Reparando);
                                break;
                            case 3:
                                coche.setEstado(Estado.Reservado);
                                break;
                            case 4:
                                coche.setEstado(Estado.Expuesto);
                                break;
                            case 5:
                                coche.setEstado(Estado.Vendido);
                                break;
                        }
                }
            }

            System.out.println("El coche con matrícula " + matricula + " ha sido modificado con los nuevos valores.");
        }
        public void borrarCoche() {
            Scanner scanner = new Scanner(System.in);


            String matricula = Validaciones.leerMatricula(scanner,concesionario.getCoches(),false);


            HashMap<String, Coche> eliminarCoche = concesionario.getCoches();
            eliminarCoche.remove(matricula);
            concesionario.setCoches(eliminarCoche);
        }
        public void cochesEnStock() {

                HashMap<String, Coche> cochesStock = concesionario.listarEnStock();

            for (Coche coche : cochesStock.values()) {

                System.out.println(coche.toString());
            }
        }
        public void cochesEnReserva() {

        HashMap<String, Coche> cochesReservados = concesionario.listarEnReserva();
        for (Coche coche : cochesReservados.values()) {

            System.out.println(coche.toString());
        }
    }
        public void cochesEnReparacion() {

        HashMap<String, Coche> cochesReparacion = concesionario.listarEnReparacion();

        for (Coche coche : cochesReparacion.values()) {

            System.out.println(coche.toString());
        }
    }
        public void imprimirCoches() {
        concesionario.imprimirCoches();
    }

        // vendedores
        public void añadirVendedor() {
        Scanner scanner = new Scanner(System.in);


            String nombre = Validaciones.leerNombreVendedorCompleto(scanner);

        String dni = Validaciones.leerDniVendedor(scanner,concesionario.getVendedores(), true);

        String direccion = Validaciones.leerDireccionVendedor(scanner);
        System.out.println("Ingrese el teléfono del vendedor:");
        String telefono = Validaciones.leerNumeroEntero(scanner);

        HashMap<String, Vendedor> nuevoVendedor = concesionario.getVendedores();
        nuevoVendedor.put(dni, new Vendedor (concesionario, nombre, direccion, dni, telefono));
        concesionario.setVendedores(nuevoVendedor);

    }
        public void modificarVendedor() {
        String dni; String nombre; String direccion; String telefono;
        Scanner scanner = new Scanner(System.in);
        dni = Validaciones.leerDniVendedor(scanner,concesionario.getVendedores(), false);
        Persona persona = concesionario.buscarVendedorPorDni(dni);
        if (persona != null) {
            System.out.println("Que desea modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Dirección");
            System.out.println("3. Teléfono");
            int c = scanner.nextInt();
            switch (c) {
                case 1:
                    nombre = Validaciones.leerNombreVendedorCompleto(scanner);
                    persona.setNombre(nombre);
                    break;
                case 2:
                    direccion = Validaciones.leerDireccionVendedor(scanner);
                    persona.setDireccion(direccion);
                    break;
                case 3:
                    System.out.println("Introduce el nuevo teléfono");
                    telefono = Validaciones.leerNumeroEntero(scanner);
                    persona.setTelefono(telefono);
            }
        }
        System.out.println("El vendedor con dni " + dni + " ha sido modificado con los nuevos valores.");
    }
        public void borrarVendedor() {
            Scanner scanner = new Scanner(System.in);



            String dni = Validaciones.leerDniVendedor(scanner,concesionario.getVendedores(), false);


            HashMap<String, Vendedor> eliminarVendedor = concesionario.getVendedores();
            eliminarVendedor.remove(dni);
            concesionario.setVendedores(eliminarVendedor);

        }
        public void queVentasTieneX_Vendedor() {
            Scanner scanner = new Scanner(System.in);


            System.out.println("A que vendedor desea consultarle las ventas");
            String dni = Validaciones.leerDniVendedor(scanner,concesionario.getVendedores(), false);
            if (concesionario.getClientes().containsKey(dni)){
                Vendedor v = concesionario.getVendedores().get(dni);
                System.out.println("Estos son los coches vendidos por el vendedor: ");
                v.imprimirCochesVendidos();
                v.imprimirSueldo();
            } else {
                System.out.println("El vendedor no existe");
            }
        }
        public void imprimirVendedores() {
        concesionario.imprimirVendedores();
    }
        public void obtenerVendedoresOrdenadosPorCochesVendidos() {

            ArrayList<Vendedor> vendedores = new ArrayList<>(concesionario.getVendedores().values());

            Collections.sort(vendedores, new VendedorComparator());

            for (Vendedor vendedor : vendedores) {
                System.out.println("Vendedor con Dni: " + vendedor.getDni());
                vendedor.imprimirNumCochesVendidos();
                vendedor.imprimirSueldo();

            }
        }

        // clientes
        public void anadirCliente(){
        Scanner scanner = new Scanner(System.in);


            String nombre = Validaciones.leerNombreClienteCompleto(scanner);


        String direccion = Validaciones.leerDireccionCliente(scanner);

        String dni = Validaciones.leerDniCliente(scanner,concesionario.getClientes(),true);

        System.out.println("Teléfono del cliente: ");
        String telefono = Validaciones.leerNumeroEntero(scanner);



        HashMap<String, Cliente> nuevoCliente = concesionario.getClientes();
        nuevoCliente.put(dni, new Cliente(concesionario, nombre, direccion, dni, telefono));
        concesionario.setClientes(nuevoCliente);

    }
        public void modificarCliente() {
        String dni; String nombre; String direccion; String telefono;
        Scanner scanner = new Scanner(System.in);
        dni = Validaciones.leerDniCliente(scanner,concesionario.getClientes(), true);
        Persona persona = concesionario.buscarClientePorDni(dni);
        if (persona != null) {
            System.out.println("Que desea modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Dirección");
            System.out.println("3. Teléfono");
            int c = scanner.nextInt();
            switch (c) {
                case 1:
                    nombre = Validaciones.leerNombreClienteCompleto(scanner);
                    persona.setNombre(nombre);
                    break;
                case 2:

                    direccion = Validaciones.leerDireccionCliente(scanner);
                    persona.setDireccion(direccion);
                    break;
                case 3:
                    System.out.println("Introduce el nuevo teléfono");
                    telefono = Validaciones.leerNumeroEntero(scanner);
                    persona.setTelefono(telefono);
            }
        } else {
            System.out.println("No se encontró un cliente con el dni:  " + dni);
        }

        System.out.println("El cliente con dni " + dni + " ha sido modificado con los nuevos valores.");
    }
        public void borrarCliente() {
        Scanner scanner = new Scanner(System.in);


        String dni = Validaciones.leerDniCliente(scanner,concesionario.getClientes(), false);


        HashMap<String, Cliente> eliminarCliente = concesionario.getClientes();
        eliminarCliente.remove(dni);
        concesionario.setClientes(eliminarCliente);
    }
        public void imprimirClientes() {
            concesionario.imprimirClientes();
        }
        public void queReservasTieneX_Cliente() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("A que cliente desea consultarle las reservas");
        String dni =  Validaciones.leerDniCliente(scanner,concesionario.getClientes(), false);

        if (concesionario.getClientes().containsKey(dni)){
            Cliente c = concesionario.getClientes().get(dni);
            c.imprimirCochesReservados();
        } else {
            System.out.println("El cliente no existe");
        }
    }
        public void queComprasTieneX_Cliente() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("A que cliente desea consultarle las compras");
        String dni =  Validaciones.leerDniCliente(scanner,concesionario.getClientes(), false);

        if (concesionario.getClientes().containsKey(dni)){
            Cliente c = concesionario.getClientes().get(dni);
            c.imprimirCochesComprados();
        } else {
            System.out.println("El cliente no existe");
        }
    }
        public void queClienteComproX_Coche() {
            Scanner scanner = new Scanner(System.in);


            String matricula =Validaciones.leerMatricula(scanner,concesionario.getCoches(),false);

            Coche coche = concesionario.buscarCochePorMatricula(matricula);

            if (coche != null) {
                Cliente clienteComprador = concesionario.buscarClientePorCocheComprado(coche);

                if (clienteComprador != null) {
                    System.out.println("El coche con matrícula " + matricula + " fue comprado por:");
                    System.out.println("Nombre: " + clienteComprador.getNombre());
                    System.out.println("DNI: " + clienteComprador.getDni());
                    System.out.println("Dirección: " + clienteComprador.getDireccion());
                    System.out.println("Teléfono: " + clienteComprador.getTelefono());
                } else {
                    System.out.println("El coche con matrícula " + matricula + " no tiene un cliente asociado.");
                }
            } else {
                System.out.println("El coche con matrícula " + matricula + " no existe en el concesionario.");
            }
        }

        // exposiciones
        public void crearExposicion() {
            Scanner scanner = new Scanner(System.in);


            Integer num = Validaciones.leerNumeroExposicion(scanner);

            scanner.nextLine();

            String direccion = Validaciones.leerDireccionExposicion(scanner);

            System.out.println("Teléfono de la exposición: ");
            String telefono = Validaciones.leerNumeroEntero(scanner);



            HashMap<Integer, Exposicion> nuevaExposicion = concesionario.getExposiciones();
            nuevaExposicion.put(num, new Exposicion(concesionario,num,direccion,telefono));
            concesionario.setExposiciones(nuevaExposicion);

        }
        public void modificarExposicion() {
        Integer numExpo; String direccion; String telefono;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el dni del cliente a modificar: ");
        numExpo = scanner.nextInt();
        Exposicion exposicion = concesionario.buscarExposicionPorNum(numExpo);
        if (exposicion != null) {
            System.out.println("Que desea modificar?");
            System.out.println("1. Numero Exposicion");
            System.out.println("2. Dirección");
            System.out.println("3. Teléfono");
            int c = scanner.nextInt();
            switch (c) {
                case 1:

                    numExpo = Validaciones.leerNumeroExposicion(scanner);
                    exposicion.setNumeroExposicion(numExpo);
                    break;
                case 2:
                    direccion = Validaciones.leerDireccionExposicion(scanner);
                    exposicion.setDireccion(direccion);
                    break;
                case 3:
                    System.out.println("Introduce el nuevo teléfono");
                    telefono = Validaciones.leerNumeroEntero(scanner);
                    exposicion.setTelefono(telefono);
            }
        } else {
            System.out.println("No se encontró una exposición con el numero:  " + numExpo);
        }

        System.out.println("La exposicion con el numero " + numExpo + " ha sido modificado con los nuevos valores.");
    }
        public void eliminarExposicion() {
        Scanner scanner = new Scanner(System.in);


        Integer numExpo = Validaciones.leerNumeroExposicion(scanner);

        scanner.nextLine();

        HashMap<Integer, Exposicion> eliminarExposicion = concesionario.getExposiciones();
        eliminarExposicion.remove(numExpo);
        concesionario.setExposiciones(eliminarExposicion);

    }
        public void imprimirExposiciones(){
        concesionario.imprimirExposiciones();
        }
        public void darDeAltaCocheA_Exposicion() {
            Scanner scanner = new Scanner(System.in);


            Integer numExpo = Validaciones.leerNumeroExposicion(scanner);;

            scanner.nextLine();


            String matricula = Validaciones.leerMatricula(scanner,concesionario.getCoches(),false);


            if (concesionario.getCoches().containsKey(matricula) &&  (concesionario.getExposiciones().containsKey(numExpo))) {
                Coche coche = concesionario.getCoches().get(matricula);

                Exposicion e = concesionario.getExposiciones().get(numExpo);

                if (coche.getEstado() == Estado.Stock) e.darDeAltaCocheEnExposicion(coche);
            }
    }
        public void darDeBajaCocheA_Exposicion() {
        Scanner scanner = new Scanner(System.in);


        Integer numExpo = Validaciones.leerNumeroExposicion(scanner);


        String matricula = Validaciones.leerMatricula(scanner,concesionario.getCoches(),false);

            Exposicion e = concesionario.getExposiciones().get(numExpo);

        if (e.getCochesEnExposicion().contains(matricula) &&  (concesionario.getExposiciones().containsKey(numExpo))) {
            Coche coche = e.getCochesEnExposicion().get(Integer.parseInt(matricula));

            if (coche.getEstado() == Estado.Expuesto) e.darDeBajaCocheDeExposicion(coche);
        }
    }
        public void queCochesHayEnX_Exposicion() {

            concesionario.imprimirExposiciones();

            Scanner scanner = new Scanner(System.in);

            Integer numExpo = Validaciones.leerNumeroExposicion(scanner);

            if (concesionario.getExposiciones().containsKey(numExpo)){
                Exposicion e = concesionario.getExposiciones().get(numExpo);
                e.mostrarCochesEnExposicion();
            } else {
                System.out.println("La exposición no existe");
            }

        }
        // reparaciones
        public void listarCocheEspecificoEnReparacion() {
        HashMap<String, Coche> cochesEnReparacion = concesionario.listarEnReparacion();
        cochesEnReparacion();
        Scanner scanner = new Scanner(System.in);

        if (concesionario == null || concesionario.getCoches() == null) {
            throw new NullPointerException("El concesionario o la lista de coches en reparación están vacíos");  //Imprimir Null
        }

        String matricula = Validaciones.leerMatricula(scanner, concesionario.getCoches(),false);
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
        public void agregarReparacion(){
        Scanner scanner =  new Scanner(System.in);
        String matricula = Validaciones.leerMatricula(scanner, concesionario.getCoches(),false);
        if (concesionario == null || concesionario.listarEnReparacion() == null) {
            throw new NullPointerException("El concesionario o la lista de coches en reparación están vacíos");    //Imprimir Null
        }

        TipoReparacion reparacion = Validaciones.leerTipoReparacion(scanner);

        Coche coche = concesionario.getCoches().get(matricula);
        Date fechaYHoraDeReparacion = new Date();
        coche.agregarReparacion(fechaYHoraDeReparacion,reparacion);

    }
        public void elegirCocheEnReparacion() {
        Scanner scanner = new Scanner(System.in);

        if (concesionario == null || concesionario.getCoches() == null) {
            throw new NullPointerException("El concesionario o la lista de coches en reparación están vacíos");  //Imprimir Null
        }
        String matricula = Validaciones.leerMatricula(scanner, concesionario.getCoches(),false);

        Coche coche = concesionario.getCoches().get(matricula);
        coche.setEstado(Estado.Stock);
    }
}
