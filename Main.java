import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Almacen almacen = new Almacen();

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Ingresar productos");
            System.out.println("2. Ver productos");
            System.out.println("3. Vender productos");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    ingresarProductos(scanner, almacen);
                    break;
                case 2:
                    verProductos(scanner, almacen);
                    break;
                case 3:
                    venderProductos(scanner, almacen);
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void ingresarProductos(Scanner scanner, Almacen almacen) {
        // Solicitar datos para un electrodoméstico
        System.out.println("\nIngresar productos:");
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Crear instancia de Electrodomestico y agregar al almacen
        Electrodomestico electrodomestico = new Electrodomestico(codigo, descripcion, valor, stock);
        almacen.agregarElectrodomestico(electrodomestico);
    }

    private static void verProductos(Scanner scanner, Almacen almacen) {
        // Mostrar los productos en el almacen
        almacen.mostrarProductos();

        // Preguntar al usuario si desea modificar algún producto
        System.out.print("¿Desea modificar algún producto? (s/n): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.print("Ingrese el código del producto que desea modificar: ");
            String codigoModificar = scanner.nextLine();
            Electrodomestico productoModificar = almacen.buscarProducto(codigoModificar);
            if (productoModificar != null) {
                System.out.println("Producto encontrado:");
                System.out.println("Código: " + productoModificar.getCodigo());
                System.out.println("Descripción: " + productoModificar.getDescripcion());
                System.out.println("Valor: " + productoModificar.getValor());
                System.out.println("Stock: " + productoModificar.getStock());
                System.out.println("\n¿Qué desea modificar?");
                System.out.println("1. Precio");
                System.out.println("2. Stock");
                System.out.print("Ingrese una opción: ");
                int opcionModificar = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea después de nextInt()
                switch (opcionModificar) {
                    case 1:
                        System.out.print("Nuevo precio: ");
                        double nuevoPrecio = scanner.nextDouble();
                        productoModificar.setValor(nuevoPrecio);
                        break;
                    case 2:
                        System.out.print("Nuevo stock: ");
                        int nuevoStock = scanner.nextInt();
                        productoModificar.setStock(nuevoStock);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("Producto no encontrado.");
            }
        }
    }

    private static void venderProductos(Scanner scanner, Almacen almacen) {
        // Mostrar los productos en el almacen
        almacen.mostrarProductos();

        // Solicitar el código del producto a vender
        System.out.print("Ingrese el código del producto que desea vender: ");
        String codigoVender = scanner.nextLine();
        Electrodomestico productoVender = almacen.buscarProducto(codigoVender);
        if (productoVender != null) {
            almacen.comprar(codigoVender);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}
