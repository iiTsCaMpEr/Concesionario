package Validaciones;

import Inventario.TipoReparacion;
import Personas.Cliente;
import Personas.Mecanico;
import Personas.Vendedor;
import Vehiculos.Coche;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {

    public static String leerMatricula(Scanner scanner, Map<String, Coche> coches, boolean esCreacionCoche) {
        String matricula;
        boolean matriculaValida = false;
        do {
            System.out.println("Ingrese la matrícula del vehículo");
            matricula = scanner.nextLine();
            if (validarMatricula(matricula)) {
                matriculaValida = true;
            } else {
                System.out.println("Error: La matrícula es de formato inválido o no corresponde a ninguna matrícula registrada. Recuerde, el formato de matrícula es 1234-AAA");
            }
        } while (!matriculaValida);
        return matricula;
    }

    public static final String formatoSoloLetras = "^[A-Za-z]+$";

    private static final String FORMATO_DIRECCION = "^[A-Za-záéíóúÁÉÍÓÚñÑ\\s]+,\\s*\\d+(,\\s*[A-Za-záéíóúÁÉÍÓÚñÑ\\s]+)?$";

    public static String leerDireccionExposicion(Scanner scanner) {
        String direccionExposicion;
        boolean direccionValida = false;

        do {
            System.out.print("Ingresa la dirección de la exposición (Calle, Número, Localidad): ");
            direccionExposicion = scanner.nextLine();

            if (validarDireccion(direccionExposicion)) {
                direccionValida = true;
            } else {
                System.out.println("Error: Ingresa una dirección válida en formato 'Calle, Número, Localidad'. Inténtalo nuevamente.");
            }
        } while (!direccionValida);

        return direccionExposicion;
    }

    public static String leerDireccionVendedor(Scanner scanner) {
        String direccionVendedor;
        boolean direccionValida = false;

        do {
            System.out.print("Ingresa la dirección del vendedor (Calle, Número, Localidad): ");
            direccionVendedor = scanner.nextLine();

            if (validarDireccion(direccionVendedor)) {
                direccionValida = true;
            } else {
                System.out.println("Error: Ingresa una dirección válida en formato 'Calle, Número, Localidad'. Inténtalo nuevamente.");
            }
        } while (!direccionValida);

        return direccionVendedor;
    }
    public static String leerDireccionCliente(Scanner scanner) {
        String direccionCliente;
        boolean direccionValida = false;

        do {
            System.out.print("Ingresa la dirección del cliente (Calle, Número, Localidad): ");
            direccionCliente = scanner.nextLine();

            if (validarDireccion(direccionCliente)) {
                direccionValida = true;
            } else {
                System.out.println("Error: Ingresa una dirección válida en formato 'Calle, Número, Localidad'. Inténtalo nuevamente.");
            }
        } while (!direccionValida);

        return direccionCliente;
    }
    public static String leerDireccionMecanico(Scanner scanner) {
        String direccionMecanico;
        boolean direccionValida = false;

        do {
            System.out.print("Ingresa la dirección del mecánico (Calle, Número, Localidad): ");
            direccionMecanico = scanner.nextLine();

            if (validarDireccion(direccionMecanico)) {
                direccionValida = true;
            } else {
                System.out.println("Error: Ingresa una dirección válida en formato 'Calle, Número, Localidad'. Inténtalo nuevamente.");
            }
        } while (!direccionValida);

        return direccionMecanico;
    }

    public static String leerMarcaCoche(Scanner scanner) {
        String marcaCoche;
        do {
            System.out.println("Ingrese la marca del coche: ");
            marcaCoche = scanner.nextLine();
            if (!validarSoloLetras(marcaCoche)) {
                System.out.println("Error: El nombre del coche debe contener solo letras. Inténtalo nuevamente.");
            }
        } while (!validarSoloLetras(marcaCoche));
        return marcaCoche;
    }

    public static String leerModeloCoche(Scanner scanner) {
        String modeloCoche;
        do {
            System.out.print("Ingresa el modelo del coche: ");
            modeloCoche = scanner.nextLine();
            if (!validarSoloLetras(modeloCoche)) {
                System.out.println("Error: El modelo del coche debe contener solo letras. Inténtalo nuevamente.");
            }
        } while (!validarSoloLetras(modeloCoche));

        return modeloCoche;
    }

    public static double leerPreciosCompraYVenta(Scanner scanner) {
        double numero = 0;
        boolean numeroValido = false;

        do {
            if (scanner.hasNextDouble()) {
                numero = scanner.nextDouble();
                numeroValido = true;
            } else {
                System.out.println("Error: Debes ingresar un número válido. Inténtalo nuevamente.");
                scanner.nextLine();
            }
        } while (!numeroValido);

        return numero;
    }


    public static String leerDniCliente(Scanner scanner, Map<String, Cliente> clientes, boolean esCreacionCliente) {
        String dni;
        boolean dniValido = false;

        do {
            System.out.println("Ingrese el DNI del cliente");
            dni = scanner.nextLine();

            if (validarDNI(dni)) {
                if (esCreacionCliente && clientes.containsKey(dni)) {
                    System.out.println("Error: El DNI ya está registrado en la base de datos. Introduzca otro DNI.");
                } else {
                    dniValido = true;
                }
            } else {
                System.out.println("Error: El DNI es de formato inválido. Recuerde, el formato de DNI es 12345678-A");
            }
        } while (!dniValido);

        return dni;
    }
    public static String leerNombreVendedorCompleto(Scanner scanner) {
        String nombreVendedorCompleto;
        boolean nombreValido = false;

        do {
            System.out.print("Ingresa el nombre completo del vendedor (nombre y apellido): ");
            nombreVendedorCompleto = scanner.nextLine();

            String[] partesNombre = nombreVendedorCompleto.split("\\s+");

            if (partesNombre.length == 2 && validarSoloLetras(partesNombre[0]) && validarSoloLetras(partesNombre[1])) {
                nombreValido = true;
            } else {
                System.out.println("Error: Ingresa un nombre válido y un apellido válido (solo letras, separados por un espacio). Inténtalo nuevamente.");
            }
        } while (!nombreValido);

        return nombreVendedorCompleto;
    }
    public static String leerNombreClienteCompleto(Scanner scanner) {
        String nombreClienteCompleto;
        boolean nombreValido = false;

        do {
            System.out.print("Ingresa el nombre completo del cliente (nombre y apellido): ");
            nombreClienteCompleto = scanner.nextLine();

            String[] partesNombre = nombreClienteCompleto.split("\\s+");

            if (partesNombre.length == 2 && validarSoloLetras(partesNombre[0]) && validarSoloLetras(partesNombre[1])) {
                nombreValido = true;
            } else {
                System.out.println("Error: Ingresa un nombre válido y un apellido válido (solo letras, separados por un espacio). Inténtalo nuevamente.");
            }
        } while (!nombreValido);

        return nombreClienteCompleto;
    }
    public static String leerNombreMecanicoCompleto(Scanner scanner) {
        String nombreMecanicoCompleto;
        boolean nombreValido = false;

        do {
            System.out.print("Ingresa el nombre completo del mecánico (nombre y apellido): ");
            nombreMecanicoCompleto = scanner.nextLine();

            String[] partesNombre = nombreMecanicoCompleto.split("\\s+");

            if (partesNombre.length == 2 && validarSoloLetras(partesNombre[0]) && validarSoloLetras(partesNombre[1])) {
                nombreValido = true;
            } else {
                System.out.println("Error: Ingresa un nombre válido y un apellido válido (solo letras, separados por un espacio). Inténtalo nuevamente.");
            }
        } while (!nombreValido);

        return nombreMecanicoCompleto;
    }



    public static String leerDniVendedor(Scanner scanner, Map<String, Vendedor> vendedores, boolean esCreacionVendedor) {
        String dni;
        boolean dniValido = false;

        do {
            System.out.println("Ingrese el DNI del vendedor");
            dni = scanner.nextLine();

            if (validarDNI(dni)) {
                if (vendedores.containsKey(dni)) {
                    System.out.println("Error: El DNI ya está registrado en la base de datos. Introduzca otro DNI.");
                } else {
                    dniValido = true;
                }
            } else {
                System.out.println("Error: El DNI es de formato inválido. Recuerde, el formato de DNI es 12345678-A");
            }
        } while (!dniValido);

        return dni;
    }
    public static String leerDniMecanico(Scanner scanner, Map<String, Mecanico> mecanicos, boolean esCreacionMecanico) {
        String dni;
        boolean dniValido = false;

        do {
            System.out.println("Ingrese el DNI del mecánico");
            dni = scanner.nextLine();

            if (validarDNI(dni)) {
                if (mecanicos.containsKey(dni)) {
                    System.out.println("Error: El DNI ya está registrado en la base de datos. Introduzca otro DNI.");
                } else {
                    dniValido = true;
                }
            } else {
                System.out.println("Error: El DNI es de formato inválido. Recuerde, el formato de DNI es 12345678-A");
            }
        } while (!dniValido);

        return dni;
    }

    public static int ValidacionSwitch(Scanner scanner) {
        int entero = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.println("Selecciona una opción: ");
                entero = scanner.nextInt();
                if (entero >= 0 && entero <= 9) {
                    entradaValida = true;
                } else {
                    System.out.println("Error: Debe ingresar un número entero válido entre 0 y 9. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero válido. Intente nuevamente.");
                scanner.nextLine();
            }
        } while (!entradaValida);
        return entero;

    }

    public static TipoReparacion leerTipoReparacion(Scanner scanner) {
        TipoReparacion reparacion;
        do {
            System.out.println("Elija el tipo de reparación: mecánica, eléctrica, chapa, revisión");
            String tipoReparacionInput = scanner.nextLine();
            try {
                reparacion = TipoReparacion.valueOf(tipoReparacionInput);
            } catch (IllegalArgumentException e) {
                reparacion = null;
            }

            if (reparacion == null) {
                System.out.println("Error: Opción inválida. Intente nuevamente.");
            }
        } while (reparacion == null);

        return reparacion;
    }

    private static boolean validarDNI(String dni) {
        return dni.matches("^\\d{8}-[A-Z]$");
    }

    public static boolean validarMatricula(String matricula) {
        String formatoMatriculaValido = "^[0-9]{4}-[A-Z]{3}$";
        Pattern pattern = Pattern.compile(formatoMatriculaValido);
        Matcher matcher = pattern.matcher(matricula);
        return matcher.matches();
    }

    public static boolean validarSoloLetras(String input) {
        Pattern pattern = Pattern.compile(formatoSoloLetras);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static String leerNumeroEntero(Scanner scanner) {
        String numeroEntero = null;
        boolean numeroValido = false;

        do {
            if (scanner.hasNext()) {
                numeroEntero = scanner.nextLine();
                numeroValido = true;
            } else {
                System.out.println("Error: Debes ingresar un número entero válido. Inténtalo nuevamente.");
                scanner.nextLine();
            }
        } while (!numeroValido);

        return numeroEntero;

    }
    public static int leerNumeroExposicion(Scanner scanner) {
        int numeroExposicion = 0;
        boolean numeroValido = false;

        do {
            System.out.print("Ingresa el número de exposición: ");
            if (scanner.hasNextInt()) {
                numeroExposicion = scanner.nextInt();
                numeroValido = true;
            } else {
                System.out.println("Error: Debes ingresar un número entero válido. Inténtalo nuevamente.");
                scanner.nextLine();
            }
        } while (!numeroValido);

        return numeroExposicion;
    }

    private static boolean validarDireccion(String direccion) {
        return direccion.matches(FORMATO_DIRECCION);
    }
}
