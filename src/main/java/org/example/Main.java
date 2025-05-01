public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(1, 1000);

        // Compra válida
        Comprador c1 = new Comprador(new Moneda1500(), Expendedor.COCA, exp);
        System.out.println("Bebiste: " + c1.queBebiste());
        System.out.println("Vuelto: $" + c1.cuantoVuelto());

        // No hay más Coca
        Comprador c2 = new Comprador(new Moneda1500(), Expendedor.COCA, exp);

        // Pago insuficiente
        Comprador c3 = new Comprador(new Moneda500(), Expendedor.SPRITE, exp);

        // Pago nulo
        Comprador c4 = new Comprador(null, Expendedor.SPRITE, exp);
    }
}