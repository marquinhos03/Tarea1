package org.example;

class Comprador {
    private String sabor;
    private int vuelto;

    public Comprador(Moneda m, int cualProducto, Expendedor exp)
            throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {

        Producto p = null;
        p = exp.comprarProducto(m, cualProducto);

        while(exp.getVuelto()!= null) {
            vuelto += 100;
        }

        if(p == null) {
            if(m != null) {
                vuelto = m.getValor();
            }
            else {
                vuelto = 0;
            }
        }
        else {
            switch (cualProducto) {
                case 1: sabor = "cocacola"; break;
                case 2: sabor = "sprite"; break;
                case 3: sabor = "fanta"; break;
                case 4: sabor = "snickers"; break;
                case 5: sabor = "super8"; break;
                default: sabor = "null"; break;
            }
            if(sabor == "null") {
                vuelto -= 100;
            }

        }
    }

    public int cuantoVuelto() {
        return vuelto;
    }

    public String queSabor() {
        return sabor;
    }
}