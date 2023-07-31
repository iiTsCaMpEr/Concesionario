package Validaciones;

import Inventario.TipoReparacion;
import Personas.Cliente;
import Vehiculos.Coche;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Validaciones {

    public static String leerMatricula(Scanner scanner, Map<String, Coche> coches) {
        String matricula;
        do {
            System.out.println("Ingrese la matrícula del vehículo");
            matricula = scanner.nextLine();
            if (coches == null) {
                System.out.println("Error: El concesionario o la lista de coches es nula. Intente nuevamente.");
            } else if (!coches.containsKey(matricula)) {
                System.out.println("Error: No se encontró ningún coche con esa matrícula. Intente nuevamente.");
            }
        } while (matricula.trim().isEmpty() || coches == null || !coches.containsKey(matricula));
        return matricula;
    }


    public static String leerDniCliente(Scanner scanner, Map<String, Cliente> clientes) {
        String dni;
        do {
            System.out.println("Ingrese el DNI del cliente");
            dni = scanner.nextLine();
            if (clientes == null) {
                System.out.println("Error: El concesionario o la lista de clientes es nula. Intente nuevamente.");
            } else if (!clientes.containsKey(dni)) {
                System.out.println("Error: No se encontró ningún cliente con ese DNI. Intente nuevamente.");
            }
        } while (dni.trim().isEmpty() || clientes == null || !clientes.containsKey(dni));
        return dni;
    }

    public static int ValidacionSwitch(Scanner scanner) {
        int entero = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.println("Selecciona una opción: ");
                entero = scanner.nextInt();
                if (entero >= 1 && entero <= 9) {
                    entradaValida = true;
                } else {
                    System.out.println("Error: Debe ingresar un número entero válido entre 1 y 9. Intente nuevamente.");
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
    public static String validarDNI(String dni) {
        // Expresión regular para verificar que el DNI tenga el formato adecuado (8 números, un guión y una letra mayúscula)
        String regex = "^\\d{8}-[A-Z]$";
        return String.valueOf(dni.matches(regex));
    }
}