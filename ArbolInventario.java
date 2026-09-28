public class ArbolInventario {

    // Raíz del árbol
    private Producto raiz;

    // Constructor
    public ArbolInventario() {
        raiz = null;
    }

    // Inserta un producto en el árbol
    public void insertar(int id, String nombre) {
        Producto nuevo = new Producto(id, nombre);

        if (raiz == null) {
            raiz = nuevo;
        } else {
            insertarRecursivo(raiz, nuevo);
        }
    }

    // Método recursivo para encontrar la posición del nuevo producto
    private void insertarRecursivo(Producto actual, Producto nuevo) {

        if (nuevo.id < actual.id) {

            if (actual.izquierdo == null) {
                actual.izquierdo = nuevo;
            } else {
                insertarRecursivo(actual.izquierdo, nuevo);
            }

        } else if (nuevo.id > actual.id) {

            if (actual.derecho == null) {
                actual.derecho = nuevo;
            } else {
                insertarRecursivo(actual.derecho, nuevo);
            }

        } else {
            System.out.println("El ID ya existe.");
        }
    }

    // Muestra los productos ordenados por ID
    public void inorden() {
        inordenRecursivo(raiz);
    }

    // Método recursivo para recorrer el árbol
    private void inordenRecursivo(Producto actual) {

        if (actual != null) {

            // Primero recorre el lado izquierdo
            inordenRecursivo(actual.izquierdo);

            // Luego muestra el producto actual
            System.out.println("ID: " + actual.id + " - Nombre: " + actual.nombre);

            // Finalmente recorre el lado derecho
            inordenRecursivo(actual.derecho);
        }
    }

    // Busca un producto por su ID
    public Producto buscar(int id) {
        return buscarRecursivo(raiz, id);
    }

    // Método recursivo para realizar la búsqueda
    private Producto buscarRecursivo(Producto actual, int id) {

        if (actual == null) {
            return null;
        }

        if (id == actual.id) {
            return actual;
        }

        if (id < actual.id) {
            return buscarRecursivo(actual.izquierdo, id);
        }

        return buscarRecursivo(actual.derecho, id);
    }
}