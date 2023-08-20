import java.util.ArrayList;
import java.util.List;
public class Tienda {
    public List<Producto> productos;

        public Tienda() {
            productos = new ArrayList<>();
        }

        public void mostrarProductos() {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }

        public void buscarProducto(String termino) {
            for (Producto producto : productos) {
                if (producto.getNombre().equalsIgnoreCase(termino) || producto.getCategoria().equalsIgnoreCase(termino)) {
                    System.out.println(producto);
                }
            }
        }

        public void agregarProducto(Producto producto) {
            productos.add(producto);
            System.out.println("Producto agregado con éxito.");
        }

        public void modificarProducto(int indice, Producto nuevoProducto) {
            if (indice >= 0 && indice < productos.size()) {
                productos.set(indice, nuevoProducto);
                System.out.println("Producto modificado con éxito.");
            } else {
                System.out.println("Índice de producto no válido.");
            }
        }

        public void eliminarProducto(int indice) {
            if (indice >= 0 && indice < productos.size()) {
                productos.remove(indice);
                System.out.println("Producto eliminado con éxito.");
            } else {
                System.out.println("Índice de producto no válido.");
            }
        }
}
