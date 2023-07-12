
import java.util.*;

public class Concesionario {

    private String nombre;
    private HashMap<String, Persona> Personas;
    private HashMap<String, Coche> Coches;
    private HashMap<String, Coche> CochesStock;
    private HashMap<String, Coche> CochesReservados;


    public Concesionario(String nombre) {
        this.nombre = nombre;


        Personas = new HashMap<>();
        Coches = new HashMap<>();
        CochesStock = new HashMap<>();
        CochesReservados = new HashMap<>();

        addCliente();
        addCliente();

    }


    // metodos

    public void interfaz() {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Que tipo de usuario eres");
        System.out.println("1. Cliente");
        System.out.println("2. Vendedor");
        System.out.println("3. Director Comercial");
        System.out.println("4. Mecanico");

        int valor = scanner.nextInt();
        if (valor == 1) {

            System.out.println("Que quieres hacer?");
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

        Personas.put(dni, new Cliente(nombre,direcion,dni,telefono));


        imprimir();

    }

    public void imprimir() {
        for (Map.Entry<String, Persona> entry : Personas.entrySet()) {
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





