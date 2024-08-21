package Supermercado;

class Humane {
    private String nombre;
    private String apellido;
    private int dni;

    public Humane(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String toString() {
        return "Nombre: " + this.nombre + "\nApellido: " + this.apellido + "\nDNI: " + this.dni;
    }
}

class Empleado extends Humane {
    private double sueldo;

    public Empleado(String nombre, String apellido, int dni, double sueldo) {
        super(nombre, apellido, dni);
        this.sueldo = sueldo;
    }

    public String toString() {
        return "\n" + super.toString() + "\nSueldo: " + this.sueldo;
    }
}

class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void reducirCantidad(int cantidadComprada) {
        this.cantidad -= cantidadComprada;
    }

    public String toString() {
        return nombre + " - Precio: $" + precio + " - Cantidad: " + cantidad;
    }
}

class Caja {
    private Empleado empleado;
    private int nroCaja;

    public Caja(Empleado empleado, int nroCaja) {
        this.nroCaja = nroCaja;
        this.empleado = empleado;
        
    }

    public String toString() {
        return this.empleado.toString() + "\nNro de caja: " + this.nroCaja;
    }

    public void procesarCompra(Cliente cliente, Producto[] productosComprados) {
        double total = 0;
        System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Productos comprados:");
        for (Producto producto : productosComprados) {
            System.out.println("- " + producto.getNombre() + " a $" + producto.getPrecio());
            total += producto.getPrecio();
            producto.reducirCantidad(1); 
        }

        if (cliente.esMayorista()) {
            total *= 0.9; 
        }

        System.out.println("Total a pagar: $" + total);
    }
}

class Cliente extends Humane {
    private boolean mayorista;

    public Cliente(String nombre, String apellido, int dni, boolean mayorista) {
        super(nombre, apellido, dni);
        this.mayorista = mayorista;
    }

    public boolean esMayorista() {
        return mayorista;
    }

    public String toString() {
        return "\n" + super.toString() + "\nMayorista: " + this.mayorista;
    }
}

public class Supermercado {
    public static void main(String[] args) {
        
        Empleado empleado = new Empleado("Ana", "Gomez", 87654321, 1500);
        Caja caja = new Caja(empleado, 1);

        
        Cliente cliente = new Cliente("Juan", "Perez", 12345678, true);

        
        Producto[] productos = {
            new Producto("Manzanas", 2.5, 50),
            new Producto("Leche", 1.2, 30),
            new Producto("Pan", 1.0, 20)
        };

        
        caja.procesarCompra(cliente, productos);

        System.out.println(caja);
    }
}
