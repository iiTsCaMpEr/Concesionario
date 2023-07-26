package Concesionario;

import Inventario.Exposicion;
import Personas.Cliente;
import Personas.Vendedor;
import Vehiculos.Coche;

import java.util.ArrayList;
import java.util.List;

public class Concesionario {
    private List<Coche> coches;
    private List<Vendedor> vendedores;
    private List<Cliente> clientes;
    private List<Exposicion> exposiciones;

    public Concesionario(String nombre) {
        coches = new ArrayList<>();
        vendedores = new ArrayList<>();
        clientes = new ArrayList<>();
        exposiciones = new ArrayList<>();
    }


    // Métodos para agregar coches, vendedores, clientes y exposiciones
    // ...

    // Listado de coches en venta
    public void listarCochesEnVenta() {
        System.out.println("Coches en venta:");
        for (Coche coche : coches) {
            if (coche.getEstado().equals("En Venta")) {
                System.out.println(coche.getMarca() + " " + coche.getModelo() + " (Matrícula: " + coche.getMatricula() + ")");
            }
        }
    }

    // Listado de coches reservados
    public void listarCochesReservados() {
        System.out.println("Coches reservados:");
        for (Coche coche : coches) {
            if (coche.getEstado().equals("Reservado")) {
                System.out.println(coche.getMarca() + " " + coche.getModelo() + " (Matrícula: " + coche.getMatricula() + ")");
            }
        }
    }

    // Listado de coches en reparación
    public void listarCochesEnReparacion() {
        System.out.println("Coches en reparación:");
        for (Coche coche : coches) {
            if (coche.getEstado().equals("En Reparación")) {
                System.out.println(coche.getMarca() + " " + coche.getModelo() + " (Matrícula: " + coche.getMatricula() + ")");
            }
        }
    }

    // Listado de coches vendidos por un vendedor a comisión
    public void listarCochesVendidosPorVendedor(Vendedor vendedor) {
        System.out.println("Coches vendidos por " + vendedor.getNombre() + ":");
        int contadorCochesVendidos = 0;
        for (Coche coche : vendedor.getCochesVendidos()) {
            System.out.println(coche.getMarca() + " " + coche.getModelo() + " (Matrícula: " + coche.getMatricula() + ")");
            contadorCochesVendidos++;
        }
        System.out.println("Sueldo de " + vendedor.getNombre() + ": " + (contadorCochesVendidos * 200) + " euros");
    }

    // Listado de clientes que tienen un coche reservado
    public void listarClientesConReserva() {
        System.out.println("Clientes con coches reservados:");
        for (Cliente cliente : clientes) {
            List<Coche> cochesReservados = cliente.getCochesReservados();
            if (!cochesReservados.isEmpty()) {
                System.out.println("Personas.Cliente: " + cliente.getNombre() + " (DNI: " + cliente.getDni() + ")");
                System.out.println("Coches reservados:");
                for (Coche coche : cochesReservados) {
                    System.out.println(coche.getMarca() + " " + coche.getModelo() + " (Matrícula: " + coche.getMatricula() + ")");
                }
            }
        }
    }



    // Personas.Cliente que compró un determinado coche
    public void clienteQueComproCoche(Coche coche) {
        System.out.println("Personas.Cliente que compró el coche " + coche.getMarca() + " " + coche.getModelo() + " (Matrícula: " + coche.getMatricula() + "):");
        for (Cliente cliente: clientes) {
            List<Coche> cochesComprados = cliente.getCochesComprados();
            if (cochesComprados.contains(coche)) {
                System.out.println("Comprador: " + cliente.getNombre() + " (DNI: " + cliente.getDni() + ")");
                break; // Mostramos solo un vendedor que vendió el coche
            }
        }
    }

    public void addVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }


    // getters and setters


    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Exposicion> getExposiciones() {
        return exposiciones;
    }

    public void setExposiciones(List<Exposicion> exposiciones) {
        this.exposiciones = exposiciones;
    }
}


/*  import java.util.*;

public class Concesionario.Concesionario {

    private String nombre;
    private HashMap<String, Personas.Persona> Personas;
    private HashMap<String, Vehiculos.Coche> Coches;
    private HashMap<String, Vehiculos.Coche> CochesStock;
    private HashMap<String, Vehiculos.Coche> CochesReservados;

    private HashMap<String,Inventario.Reparacion> CochesEnReparacion;



    public Concesionario.Concesionario(String nombre) {
        this.nombre = nombre;


        Personas = new HashMap<>();
        Coches = new HashMap<>();
        CochesStock = new HashMap<>();
        CochesReservados = new HashMap<>();
        CochesEnReparacion = new HashMap<>();

        addCliente();
        addCliente();

    }


    // metodos

    public void interfaz() {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Que tipo de usuario eres");
        System.out.println("1. Personas.Cliente");
        System.out.println("2. Personas.Vendedor");
        System.out.println("3. Director Comercial");
        System.out.println("4. Mecanico");

        int valor = scanner.nextInt();
        if (valor == 1) {

            System.out.println("Que quieres hacer");
            System.out.println("1. Comprar un coche");
            System.out.println("2. Reservar un coche");
            valor = scanner.nextInt();

        }
        if (valor == 2) {

            System.out.println("Que quieres hacer?");
            System.out.println("1. Vender un coche");
            System.out.println("2. Reservar un coche");
            System.out.println("3. Consultar datos cliente");
            System.out.println("4. Consultar datos de un coche");
            System.out.println("5. Consultar datos de una exposicion");


        }

        if(valor ==3)

    {


    }

}





    public void addCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("nombre");
        String nombre = scanner.nextLine();


        System.out.println("dirección");
        String direcion = scanner.nextLine();


        System.out.println("dni");
        String dni = scanner.nextLine();

        System.out.println("telefono");
        int telefono = scanner.nextInt();

        Personas.put(dni, new Personas.Cliente(nombre,direcion,dni,telefono));


        imprimir();

    }

    public void imprimir() {
        for (Map.Entry<String, Personas.Persona> entry : Personas.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());


        }
    }


        public void queCliente () {

        }
        public void queCoches () {

        }
        public void cochesStock () {

        }
        public void venderCoche () {

        }
        public void reservarCoche () {

        }
        public void cambiarExposicion () {

        }
    }
*/
