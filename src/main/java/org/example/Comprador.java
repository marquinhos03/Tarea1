package org.example;

class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cual, Expendedor exp) {
        try {
            Bebida b = exp.comprarBebida(m, cual);
            sonido = b.beber();
        } catch (PagoIncorrectoException | PagoInsuficienteException | NoHayProductoException e) {
            sonido = null;
            System.out.println("Error: " + e.getMessage());
        }

        vuelto = 0;
        Moneda mon;
        while ((mon = exp.getVuelto()) != null) {
            vuelto += mon.getValor();
        }
    }

    public int cuantoVuelto() {
        return vuelto;
    }

    public String queBebiste() {
        return sonido;
    }
}