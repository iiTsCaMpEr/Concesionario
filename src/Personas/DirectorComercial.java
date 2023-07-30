package Personas;

import Concesionario.Concesionario;
import Inventario.Exposicion;
import Personas.Persona;

import Vehiculos.Coche;
import Vehiculos.Estado;
import Vehiculos.Tipo;

import java.util.HashMap;
import java.util.Scanner;


public class DirectorComercial extends Persona {

    public DirectorComercial (Concesionario concesionario) {
        super(concesionario);
    }


    public DirectorComercial(Concesionario concesionario, String nombre, String direccion, String dni, String telefono) {
        super(concesionario, nombre, direccion, dni, telefono);

    }

        // coches
        public void crearCoche() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Marca del coche: ");
            String marca = scanner.nextLine();

            System.out.println("Modelo del coche: ");
            String modelo = scanner.nextLine();

            System.out.println("Matricula del coche: ");
            String matricula = scanner.nextLine();

            System.out.println("Precio de venta del coche: ");
            double precioVenta = scanner.nextDouble();

            System.out.println("Precio de compra del coche: ");
            double precioCompra = scanner.nextDouble();


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
        System.out.println("Introduce la matrícula del coche a modificar: ");
        matricula = scanner.nextLine();
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
                        nuevoPrecioCompra = scanner.nextDouble();
                        coche.setPrecioCompra(nuevoPrecioCompra);
                        break;
                    case 2:
                        System.out.println("Introduce el nuevo precio de venta");
                        nuevoPrecioVenta = scanner.nextDouble();
                        coche.setPrecioVenta(nuevoPrecioVenta);
                        break;
                    case 3:
                        System.out.println("1. Stock");
                        System.out.println("2. Reparando");
                        System.out.println("3. Reservado");
                        System.out.println("4. Expuesto");
                        System.out.println("5. Vendido");
                        nuevoEstado = scanner.nextInt();
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
            } else {
                System.out.println("No se encontró un coche con la matrícula " + matricula);
            }

            System.out.println("El coche con matrícula " + matricula + " ha sido modificado con los nuevos valores.");
        }
        public void borrarCoche() {
            Scanner scanner = new Scanner(System.in);


            System.out.println("Introduce la matrícula del coche que deseas borrar: ");
            String matricula = scanner.nextLine();


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
        // vendedores
        public void añadirVendedor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del vendedor:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el DNI del vendedor:");
        String dni = scanner.nextLine();
        System.out.println("Ingrese el domicilio del vendedor:");
        String domicilio = scanner.nextLine();
        System.out.println("Ingrese el teléfono del vendedor:");
        String telefono = scanner.nextLine();

        HashMap<String, Vendedor> nuevoVendedor = concesionario.getVendedores();
        nuevoVendedor.put(dni, new Vendedor (concesionario, nombre, direccion, dni, telefono));
        concesionario.setVendedores(nuevoVendedor);

    }
        public void modificarVendedor() {
        String dni; String nombre; String direccion; String telefono;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el dni del vendedor a modificar: ");
        dni = scanner.nextLine();
        Persona persona = concesionario.buscarVendedorPorDni(dni);
        if (persona != null) {
            System.out.println("Que desea modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Dirección");
            System.out.println("3. Teléfono");
            int c = scanner.nextInt();
            switch (c) {
                case 1:
                    System.out.println("Introduce el nuevo nombre");
                    nombre = scanner.nextLine();
                    persona.setNombre(nombre);
                    break;
                case 2:
                    System.out.println("Introduce la nueva dirección");
                    direccion = scanner.nextLine();
                    persona.setDireccion(direccion);
                    break;
                case 3:
                    System.out.println("Introduce el nuevo teléfono");
                    telefono = scanner.nextLine();
                    persona.setTelefono(telefono);
            }
        } else {
            System.out.println("No se encontró un vendedor con el dni:  " + dni);
        }

        System.out.println("El vendedor con dni " + dni + " ha sido modificado con los nuevos valores.");
    }
        public void borrarVendedor() {
            Scanner scanner = new Scanner(System.in);


            System.out.println("Introduce el dni del vendedor que desea borrar: ");
            String dni = scanner.nextLine();


            HashMap<String, Vendedor> eliminarVendedor = concesionario.getVendedores();
            eliminarVendedor.remove(dni);
            concesionario.setVendedores(eliminarVendedor);

        }
        public void queVentasTieneX_Vendedor() {
            Scanner scanner = new Scanner(System.in);


            System.out.println("A que vendedor desea consultarle las ventas");
            String dni = scanner.nextLine();

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

        // clientes
        public void anadirCliente(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.println("Direccion del cliente: ");
        String direccion = scanner.nextLine();

        System.out.println("DNI cliente: ");
        String dni = scanner.nextLine();

        System.out.println("Teléfono del cliente: ");
        String telefono = scanner.nextLine();



        HashMap<String, Cliente> nuevoCliente = concesionario.getClientes();
        nuevoCliente.put(dni, new Cliente(concesionario, nombre, direccion, dni, telefono));
        concesionario.setClientes(nuevoCliente);

    }
        public void modificarCliente() {
        String dni; String nombre; String direccion; String telefono;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el dni del cliente a modificar: ");
        dni = scanner.nextLine();
        Persona persona = concesionario.buscarClientePorDni(dni);
        if (persona != null) {
            System.out.println("Que desea modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Dirección");
            System.out.println("3. Teléfono");
            int c = scanner.nextInt();
            switch (c) {
                case 1:
                    System.out.println("Introduce el nuevo nombre");
                    nombre = scanner.nextLine();
                    persona.setNombre(nombre);
                    break;
                case 2:
                    System.out.println("Introduce la nueva dirección");
                    direccion = scanner.nextLine();
                    persona.setDireccion(direccion);
                    break;
                case 3:
                    System.out.println("Introduce el nuevo teléfono");
                    telefono = scanner.nextLine();
                    persona.setTelefono(telefono);
            }
        } else {
            System.out.println("No se encontró un cliente con el dni:  " + dni);
        }

        System.out.println("El cliente con dni " + dni + " ha sido modificado con los nuevos valores.");
    }
        public void borrarCliente() {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Introduce el dni del cliente que desea borrar: ");
        String dni = scanner.nextLine();


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
        String dni = scanner.nextLine();

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
        String dni = scanner.nextLine();

        if (concesionario.getClientes().containsKey(dni)){
            Cliente c = concesionario.getClientes().get(dni);
            c.imprimirCochesComprados();
        } else {
            System.out.println("El cliente no existe");
        }
    }
        public void queClienteComproX_Coche() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Introduzca la matricula del coche que quiere consultar por quien fue comprado");
            String matricula = scanner.nextLine();

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

            System.out.println("Número de la exposición: ");
            Integer num = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Direccion de la exposición: ");
            String direccion = scanner.nextLine();

            System.out.println("Teléfono de la exposición: ");
            String telefono = scanner.nextLine();



            HashMap<Integer, Exposicion> nuevaExposicion = concesionario.getExposiciones();
            nuevaExposicion.put(num, new Exposicion(num,direccion,telefono));
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
                    System.out.println("Introduce el nuevo número");
                    numExpo = scanner.nextInt();
                    exposicion.setNumeroExposicion(numExpo);
                    break;
                case 2:
                    System.out.println("Introduce la nueva dirección");
                    direccion = scanner.nextLine();
                    exposicion.setDireccion(direccion);
                    break;
                case 3:
                    System.out.println("Introduce el nuevo teléfono");
                    telefono = scanner.nextLine();
                    exposicion.setTelefono(telefono);
            }
        } else {
            System.out.println("No se encontró un cliente con el dni:  " + numExpo);
        }

        System.out.println("El cliente con dni " + numExpo + " ha sido modificado con los nuevos valores.");
    }
        public void eliminarExposicion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Número de la exposición que desea eliminar: ");
        Integer numExpo = scanner.nextInt();

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

            System.out.println("Introduzca el numero de la exposición: ");
            Integer numExpo = scanner.nextInt();

            scanner.nextLine();

            System.out.println("Introduzca la matrícula del coche que desea añadir: ");
            String matricula = scanner.nextLine();


            if (concesionario.getCoches().containsKey(matricula) &&  (concesionario.getExposiciones().containsKey(numExpo))) {
                Coche coche = concesionario.getCoches().get(matricula);

                Exposicion e = concesionario.getExposiciones().get(numExpo);

                if (coche.getEstado() == Estado.Stock) e.darDeAltaCocheEnExposicion(coche);
            }
    }
        public void darDeBajaCocheA_Exposicion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca el numero de la exposición: ");
        Integer numExpo = scanner.nextInt();

        System.out.println("Introduzca la matrícula del coche que desea dar de baja: ");
        String matricula = scanner.nextLine();

            Exposicion e = concesionario.getExposiciones().get(numExpo);

        if (e.getCochesEnExposicion().contains(matricula) &&  (concesionario.getExposiciones().containsKey(numExpo))) {
            Coche coche = e.getCochesEnExposicion().get(Integer.parseInt(matricula));

            if (coche.getEstado() == Estado.Expuesto) e.darDeBajaCocheDeExposicion(coche);
        }
    }
        public void queCochesHayEnX_Exposicion() {

            concesionario.imprimirExposiciones();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Escriba el numero de exposición de la exposición que desea consultar");
            Integer numExpo = scanner.nextInt();

            if (concesionario.getExposiciones().containsKey(numExpo)){
                Exposicion e = concesionario.getExposiciones().get(numExpo);
                e.mostrarCochesEnExposicion();
            } else {
                System.out.println("La exposición no existe");
            }

        }
        // reparaciones











    // que vendedor ha vendido más




    //agregarCocheComprado(coche);
    //agregarCocheReservado(coche);
    //agregarCocheVendido(coche);
    //queCliente(coche)
    //queCoches(vendedor)

    //venderCoche(coche,vendedor,cliente)
    //reservarCoche(coche,cliente)
    //cambiarExposicion(coche,exposicion)
    //comprar()
    //reservar()
    //cambiarExposicion(exposicion)
    //resolver()



}