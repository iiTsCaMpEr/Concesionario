package Concesionario;

import Inventario.Exposicion;
import Personas.Cliente;
import Personas.Vendedor;
import Vehiculos.Coche;

import java.util.HashMap;

public class Concesionario {
    private HashMap<String, Coche> coches;
    private HashMap<String, Vendedor> vendedores;
    private HashMap<String, Cliente> clientes;
    private HashMap<Integer, Exposicion> exposiciones;

    public Concesionario() {
        coches = new HashMap<>();
        vendedores = new HashMap<>();
        clientes = new HashMap<>();
        exposiciones = new HashMap<>();
    }


    // Métodos para agregar coches, vendedores, clientes y exposiciones


    // Listado de coches en venta
    public void listarCochesEnVenta() {
        System.out.println("Coches en venta: ");
        for (Coche coche : coches.values()) {

                System.out.println(coche.getMarca() + " " + coche.getModelo() + " (Matrícula: " + coche.getMatricula() + ")");

        }
    }

    // Listado de coches reservados
    public void listarCochesReservados() {
        System.out.println("Coches reservados:");
        for (Coche coche : coches.values()) {
            if (coche.getEstado().equals("Reservado")) {
                System.out.println(coche.getMarca() + " " + coche.getModelo() + " (Matrícula: " + coche.getMatricula() + ")");
            }
        }
    }

    // Listado de coches en reparación
    public void listarCochesEnReparacion() {
        System.out.println("Coches en reparación: ");
        for (Coche coche : coches.values()) {
                System.out.println(coche.getMarca() + " " + coche.getModelo() + " (Matrícula: " + coche.getMatricula() + ")");
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
    public void listarCochesEnReservados() {
        System.out.println("Coches en venta:");
        for (Coche coche : coches.values()) {
            if (coche.getEstado().equals("Reservado")) {
                System.out.println(coche.getMarca() + " " + coche.getModelo() + " (Matrícula: " + coche.getMatricula() + ")");
            }
        }
    }
    public void reservarCoche(String matricula, String dni) {

            if (coches.containsKey(matricula) && (clientes.containsKey(dni))) {
                Coche coche = coches.get(matricula);
                coches.remove(matricula);
                coche.setEstado("Reservado");

                Cliente cliente = clientes.get(dni);
                cliente.reservarCoche(coche);


            }
        }


    public void añadirCoche (Coche coche) {
        coches.put(coche.getMatricula(), coche);
    }

    public void addVendedor(Vendedor vendedor) {
        vendedores.put(vendedor.getDni(), vendedor);
    }
    public void addCliente(Cliente cliente) {
        clientes.put(cliente.getDni(), cliente);
    }

    public void calcularEnStock() {

        if (coches.containsKey("En venta")) {

        }

    }


    // getters and setters
    public HashMap<String, Coche> getCoches() {
        return coches;
    }

    public void setCoches(HashMap<String, Coche> coches) {
        this.coches = coches;
    }

    public HashMap<String, Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(HashMap<String, Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public HashMap<Integer, Exposicion> getExposiciones() {
        return exposiciones;
    }

    public void setExposiciones(HashMap<Integer, Exposicion> exposiciones) {
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

    public void Interfaz.Interfaz() {


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
