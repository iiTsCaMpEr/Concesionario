import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona{

    private List<Coche> cochesVendidos;

    public Vendedor(String nombre, String direccion, String dni, int telefono) {
        super(nombre, direccion, dni, telefono);

        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;

        this.cochesVendidos = new ArrayList<>();
    }


    public void venderCoche(Coche coche) {
        cochesVendidos.add(coche);
        coche.vender();
    }

    public int calcularSueldo() {
        return cochesVendidos.size() * 200;
    }


    // getters and setters


    public List<Coche> getCochesVendidos() {
        return cochesVendidos;
    }

    private void setCochesVendidos(List<Coche> cochesVendidos) {
        this.cochesVendidos = cochesVendidos;
    }


}
