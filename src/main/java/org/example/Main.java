package org.example;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase principal de pruebas del expendedor.
 */
public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(1); // Un producto por tipo

        System.out.println("=== COMPRAS VÁLIDAS ===");

        Comprador c2 = new Comprador(new Moneda1000(), 2, exp); // Sprite
        System.out.println("Consumiste: " + c2.queConsumiste());
        System.out.println("Vuelto: $" + c2.cuantoVuelto());

        Comprador c3 = new Comprador(new Moneda1000(), 3, exp); // Fanta
        System.out.println("Consumiste: " + c3.queConsumiste());
        System.out.println("Vuelto: $" + c3.cuantoVuelto());

        Comprador c4 = new Comprador(new Moneda1000(), 4, exp); // Snickers
        System.out.println("Consumiste: " + c4.queConsumiste());
        System.out.println("Vuelto: $" + c4.cuantoVuelto());

        Comprador c5 = new Comprador(new Moneda1000(), 5, exp); // Super8
        System.out.println("Consumiste: " + c5.queConsumiste());
        System.out.println("Vuelto: $" + c5.cuantoVuelto());

        System.out.println("\n=== PRUEBAS DE EXCEPCIONES ===");

        // No hay más CocaCola
        Comprador c6 = new Comprador(new Moneda1000(), 1, exp);

        // Pago insuficiente para Sprite
        Comprador c7 = new Comprador(new Moneda500(), 2, exp);

        // Moneda nula
        Comprador c8 = new Comprador(null, 3, exp);

        // Producto inválido
        try {
            new Comprador(new Moneda1000(), 99, exp);
        } catch (Exception e) {
            System.out.println("Error capturado: " + e.getMessage());
        }

        System.out.println("\n=== ORDENANDO MONEDAS ===");

        ArrayList<Moneda> monedas = new ArrayList<>();
        monedas.add(new Moneda100());
        monedas.add(new Moneda1000());
        monedas.add(new Moneda500());

        System.out.println("Antes de ordenar:");
        for (Moneda m : monedas) {
            System.out.println(m);
        }

        Collections.sort(monedas);

        System.out.println("\nDespués de ordenar:");
        for (Moneda m : monedas) {
            System.out.println(m);
        }
    }
}