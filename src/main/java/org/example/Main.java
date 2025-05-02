package org.example;

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(1);
        Moneda m = null;
        Comprador c = null;

        // Compra válida
        try {
            m = new Moneda100();
            c = new Comprador(m, 1, exp);
            System.out.println("Bebiste: " + c.queSabor()+", Vuelto: $"+ c.cuantoVuelto());
        } catch (PagoInsuficienteException | PagoIncorrectoException | NoHayProductoException e) {
            System.out.println(e.getMessage());
        }

        // No hay más Coca
        try {
            m = new Moneda1000();
            c = new Comprador(m, 1, exp);
            System.out.println("Bebiste: " + c.queSabor()+", Vuelto: $"+ c.cuantoVuelto());
        } catch (PagoInsuficienteException | PagoIncorrectoException | NoHayProductoException e) {
            System.out.println(e.getMessage());
        }

        // Pago insuficiente
        try {
            m = new Moneda100();
            c = new Comprador(m, 2, exp);
            System.out.println("Bebiste: " + c.queSabor()+", Vuelto: $"+ c.cuantoVuelto());
        } catch (PagoInsuficienteException | PagoIncorrectoException | NoHayProductoException e) {
            System.out.println(e.getMessage());
        }

        // Pago nulo
        try {
            m = null;
            c = new Comprador(m, 2, exp);
            System.out.println("Bebiste: " + c.queSabor()+", Vuelto: $"+ c.cuantoVuelto());
        } catch (PagoInsuficienteException | PagoIncorrectoException | NoHayProductoException e) {
            System.out.println(e.getMessage());
        }
    }
}