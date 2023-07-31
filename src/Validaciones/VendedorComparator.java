package Validaciones;

import Personas.Vendedor;
import Personas.Vendedor;

import java.util.Comparator;

public class VendedorComparator implements Comparator<Vendedor> {
    private Vendedor vendedor;
    @Override
    public int compare(Vendedor v1, Vendedor v2) {
        // Comparar por la cantidad de coches vendidos (puedes usar los métodos de Vendedor para obtener esta información)
        int cantidadCochesVendidosV1 = v1.getCochesVendidos().size();
        int cantidadCochesVendidosV2 = v2.getCochesVendidos().size();

        // Ordenar en orden descendente, para que el vendedor con más coches vendidos esté primero
        return Integer.compare(cantidadCochesVendidosV2, cantidadCochesVendidosV1);
    }
}
