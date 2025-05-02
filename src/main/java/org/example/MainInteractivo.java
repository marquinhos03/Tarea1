package org.example;
import java.util.Scanner; //Scanner para recibir entradas del usuario

/**
 * Clase con main interactivo para simular compras desde la consola.
 */
public class MainInteractivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Expendedor exp = new Expendedor(5); // Carga inicial con más productos

        System.out.println("=== EXPENDEDOR ===");

        boolean seguir = true;
        while (seguir) {
            System.out.println("\n--- MENU DE PRODUCTOS ---");
            for (int i = 0; i < TipoProducto.values().length; i++) {
                TipoProducto tipo = TipoProducto.values()[i];
                System.out.println((i + 1) + ". " + tipo.getNombre() + " - $" + tipo.getPrecio());
            }
            System.out.println("0. Salir");

            System.out.print("Seleccione el número del producto: ");
            int opcionProducto = scanner.nextInt();

            if (opcionProducto == 0) {
                seguir = false;
                System.out.println("Fin expendedor");
                break;
            }

            System.out.println("\n--- MONEDAS DISPONIBLES ---");
            System.out.println("1. $100");
            System.out.println("2. $500");
            System.out.println("3. $1000");
            System.out.println("4. $1500");
            System.out.print("Seleccione el número de la moneda: ");
            int opcionMoneda = scanner.nextInt();

            Moneda moneda = null;
            switch (opcionMoneda) {
                case 1:
                    moneda = new Moneda100(); break;
                case 2:
                    moneda = new Moneda500(); break;
                case 3:
                    moneda = new Moneda1000(); break;
                default:
                    System.out.println("Opción de moneda no válida. Se intentará comprar sin moneda.");
                    break;
            }

            try {
                Comprador comprador = new Comprador(moneda, opcionProducto, exp);
                System.out.println("Consumiste: " + comprador.queConsumiste());
                System.out.println("Vuelto: $" + comprador.cuantoVuelto());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }

        scanner.close();
    }
}