package org.example;

class Expendedor {
    public static final int COCA = 1;
    public static final int SPRITE = 2;

    private Deposito<Bebida> coca;
    private Deposito<Bebida> sprite;
    private Deposito<Moneda> monVu;
    private int precio;
    private int serieContador = 0;

    public Expendedor(int numBebidas, int precioBebidas) {
        this.precio = precioBebidas;
        coca = new Deposito<>();
        sprite = new Deposito<>();
        monVu = new Deposito<>();

        for (int i = 0; i < numBebidas; i++) {
            coca.add(new CocaCola(serieContador++));
            sprite.add(new Sprite(serieContador++));
        }
    }

    public Bebida comprarBebida(Moneda m, int cual)
        throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        if (m == null) throw new PagoIncorrectoException("No se ingresó ninguna moneda");

        Deposito<Bebida> deposito;
        switch (cual) {
            case COCA:
                deposito = coca;
                break;
            case SPRITE:
                deposito = sprite;
                break;
            default:
                monVu.add(m);
                throw new NoHayProductoException("El producto no existe");
        }

        if (m.getValor() < precio) {
            monVu.add(m);
            throw new PagoInsuficienteException("Dinero insuficiente");
        }

        Bebida bebida = deposito.get();
        if (bebida == null) {
            monVu.add(m);
            throw new NoHayProductoException("No quedan bebidas de ese tipo");
        }

        int vuelto = m.getValor() - precio;
        while (vuelto >= 100) {
            monVu.add(new Moneda100());
            vuelto -= 100;
        }

        return bebida;
    }

    public Moneda getVuelto() {
        return monVu.get();
    }
}