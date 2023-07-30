package Personas;
import Excepciones.NoSuchMatriculaException;
import Inventario.Exposicion;
import Vehiculos.Coche;
import Concesionario.Concesionario;
import Vehiculos.Estado;
import Validaciones.Validaciones;

import java.util.ArrayList;
import java.util.Scanner;

public class Vendedor extends Persona {
    private ArrayList<Coche> cochesVendidos;

    public Vendedor(Concesionario concesionario, String nombre, String direccion, String dni, String telefono) {
        super(concesionario, nombre, direccion, dni, telefono);
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.concesionario = concesionario;
        this.cochesVendidos = new ArrayList<>();
    }

    // coches
    public void venderCoche() {
        Scanner scanner = new Scanner(System.in);

        if (concesionario == null || concesionario.getCoches() == null || concesionario.getClientes() == null) {
            throw new NullPointerException("El concesionario, la lista de coches o la lista de clientes es nula");
        }

        String matricula = Validaciones.leerMatricula(scanner, concesionario.getCoches());
        String dni = Validaciones.leerDniCliente(scanner, concesionario.getClientes());

        Coche coche = concesionario.getCoches().get(matricula);
        Cliente cliente = concesionario.getClientes().get(dni);

        coche.setEstado(Estado.Vendido);
        cliente.comprarCoche(coche);
        cochesVendidos.add(coche);
    }
    public void cancelarReserva() {
        Scanner scanner = new Scanner(System.in);

                    if (concesionario == null || concesionario.getCoches() == null || concesionario.getClientes() == null) {
                        throw new NullPointerException("El concesionario, la lista de coches o la lista de clientes es nula");
                    }

                    String matricula = Validaciones.leerMatricula(scanner, concesionario.getCoches());
                    String dni = Validaciones.leerDniCliente(scanner, concesionario.getClientes());

                    Coche coche = concesionario.getCoches().get(matricula);
                    Cliente cliente = concesionario.getClientes().get(dni);

                    coche.setEstado(Estado.Stock);
                    cliente.cancelarReserva(coche);
            }
    public void reservarCoche() {
        Scanner scanner = new Scanner(System.in);

        if (concesionario == null || concesionario.getCoches() == null || concesionario.getClientes() == null) {
            throw new NullPointerException("El concesionario, la lista de coches o la lista de clientes es nula");
        }
        String matricula =Validaciones.leerMatricula(scanner,concesionario.getCoches());
        String dni = Validaciones.leerDniCliente(scanner,concesionario.getClientes());

        Coche coche = concesionario.getCoches().get(matricula);
        Cliente cliente = concesionario.getClientes().get(dni);

        coche.setEstado(Estado.Reservado);
        cliente.reservarCoche(coche);


        }
    public void imprimirCochesVendidos() {
        for (Coche coche : cochesVendidos){
            System.out.println(coche.toString());
        }
    }
    public void verCochesEnStock() {
        concesionario.listarCochesEnVenta();
    }

    public void imprimirSueldo() {
        int sueldo = cochesVendidos.size() * 200;
        System.out.println("El sueldo del vendedor con DNI" + getDni() + " es :" + sueldo);
    }
    // clientes
    public void verListaDeClientes() {
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
    public void imprimirExposiciones(){
        concesionario.imprimirExposiciones();
    }

    // getters and setters
    public ArrayList<Coche> getCochesVendidos() {
        return cochesVendidos;
    }
}