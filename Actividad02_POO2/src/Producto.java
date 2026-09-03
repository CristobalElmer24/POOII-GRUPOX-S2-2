public class Producto {
    private String nombreProducto;
    private int cantidad;

    public Producto(String nombreProducto, int cantidad) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String toString() {
        return nombreProducto + " - Cantidad: " + cantidad;
    }
}