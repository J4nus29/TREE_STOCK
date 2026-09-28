import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Objeto que controla el árbol de inventario
        ArbolInventario inventario = new ArbolInventario();

        // Permite recibir datos del usuario
        Scanner entrada = new Scanner(System.in);

        int opcion;

        do {

            System.out.println("\n--- TREE-STOCK ---");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Buscar Producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("\n--- REGISTRAR PRODUCTO ---");

                    System.out.print("Ingrese el ID del producto: ");
                    int id = entrada.nextInt();

                    // Limpia el salto de línea pendiente después de nextInt()
                    entrada.nextLine();

                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = entrada.nextLine();

                    inventario.insertar(id, nombre);

                    System.out.println("Producto registrado correctamente.");
                    break;

                case 2:
                    System.out.println("\n--- INVENTARIO ORDENADO ---");
                    inventario.inorden();
                    break;

                case 3:
                    System.out.println("\n--- BUSCAR PRODUCTO ---");

                    System.out.print("Ingrese el ID del producto: ");
                    int idBuscar = entrada.nextInt();

                    Producto productoEncontrado = inventario.buscar(idBuscar);

                    if (productoEncontrado != null) {
                        System.out.println("Producto encontrado:");
                        System.out.println("ID: " + productoEncontrado.id);
                        System.out.println("Nombre: " + productoEncontrado.nombre);
                    } else {
                        System.out.println("El producto no existe.");
                    }

                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (opcion != 0);

        // Cierra el Scanner
        entrada.close();
    }
}