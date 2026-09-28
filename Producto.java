public class Producto {

    // Datos del producto
    int id;
    String nombre;

    // Punteros hacia los hijos del nodo
    Producto izquierdo;
    Producto derecho;

    // Constructor
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;

        // Inicialmente el nodo no tiene hijos
        this.izquierdo = null;
        this.derecho = null;
    }
}