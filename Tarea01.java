import java.util.Scanner;
public class Tarea01 {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int opcion = Integer.parseInt(scanner.nextLine());

            ejecutarOpcion(opcion, scanner, tienda);
        }
    }

    public static void mostrarMenu() {
        System.out.println("\nBienvenido a la Tienda");
        System.out.println("1. Mostrar productos");
        System.out.println("2. Buscar producto");
        System.out.println("3. Agregar producto");
        System.out.println("4. Modificar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Realizar compra");
        System.out.println("7. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public static void ejecutarOpcion(int opcion, Scanner scanner, Tienda tienda) {
        switch (opcion) {
            case 1:
                tienda.mostrarProductos();
                break;
            case 2:
                buscarProducto(scanner, tienda);
                break;
            case 3:
                agregarProducto(scanner, tienda);
                break;
            case 4:
                modificarProducto(scanner, tienda);
                break;
            case 5:
                eliminarProducto(scanner, tienda);
                break;
            case 6:
                realizarCompra(scanner, tienda);
                break;
            case 7:
                System.out.println("¡Gracias por usar nuestra tienda en línea!");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public static void buscarProducto(Scanner scanner, Tienda tienda) {
        System.out.print("Ingrese el nombre o categoría del producto a buscar: ");
        String termino = scanner.nextLine();
        tienda.buscarProducto(termino);
    }

    public static void agregarProducto(Scanner scanner, Tienda tienda) {
        System.out.print("Ingrese el nombre del nuevo producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese el stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la categoría: ");
        String categoria = scanner.nextLine();
        Producto nuevoProducto = new Producto(nombre, descripcion, precio, stock, categoria);
        tienda.agregarProducto(nuevoProducto);
    }

    public static void modificarProducto(Scanner scanner, Tienda tienda) {
        System.out.print("Ingrese el índice del producto a modificar: ");
        int indiceMod = scanner.nextInt();
        scanner.nextLine();
        if (indiceMod >= 0 && indiceMod < tienda.productos.size()) {
            Producto productoMod = tienda.productos.get(indiceMod);
        } else {
            System.out.println("Índice de producto no válido.");
        }
    }

    public static void eliminarProducto(Scanner scanner, Tienda tienda) {
        System.out.print("Ingrese el índice del producto a eliminar: ");
        int indiceElim = scanner.nextInt();
        scanner.nextLine();
        tienda.eliminarProducto(indiceElim);
    }

    public static void realizarCompra(Scanner scanner, Tienda tienda) {
        System.out.print("Ingrese el índice del producto a comprar: ");
        int indiceCompra = scanner.nextInt();
        System.out.print("Ingrese la cantidad a comprar: ");
        int cantidadCompra = scanner.nextInt();
        scanner.nextLine();
        Producto productoCompra = tienda.productos.get(indiceCompra);
        productoCompra.realizarCompra(cantidadCompra);
    }
}

