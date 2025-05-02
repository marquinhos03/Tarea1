package org.example;

class Expendedor {

    private Deposito<CocaCola> coca;
    private Deposito<Sprite> sprite;
    private Deposito<Fanta> fanta;
    private Deposito<Snickers> snickers;
    private Deposito<Super8> super8;
    private Deposito<Moneda> monVu;

    public Expendedor(int cantidadProductos) {
        coca = new Deposito<>();
        sprite = new Deposito<>();
        fanta = new Deposito<>();
        snickers = new Deposito<>();
        super8 = new Deposito<>();
        monVu = new Deposito<>();

        for (int i = 0; i < cantidadProductos; i++) {
            coca.add(new CocaCola(i));
            sprite.add(new Sprite(i));
            fanta.add(new Fanta(i));
            snickers.add(new Snickers(i));
            super8.add(new Super8(i));
        }
    }

    public Producto comprarProducto(Moneda m, int numDeposito)
            throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {

        tipoDeProducto cual = tipoDeProducto.identificarProducto(numDeposito);

        if (m == null) {
            throw new PagoIncorrectoException("No se ingresó ninguna moneda");
        }
        else if(m.getValor() < cual.getPrecio()) {
            monVu.add(m);
            throw new PagoInsuficienteException("Dinero insuficiente");
        }

        Producto p = null;
        switch (cual) {
            case COCA: p = coca.get(); break;
            case SPRITE: p = sprite.get(); break;
            case FANTA: p = fanta.get(); break;
            case SNICKERS: p = snickers.get(); break;
            case SUPER8: p = super8.get(); break;
            default: monVu.add(m); return null;
        }

        if (p == null) {
            monVu.add(m);
            throw new NoHayProductoException("Lo sentimos, no hay " + cual.getNombre() + " disponible.");
        }
        else {
            for(int i = m.getValor()/100; i > cual.getPrecio()/100 ; i--) {
                monVu.add(new Moneda100());
            }
            return p;
        }
    }

    public Moneda getVuelto() {
        Moneda m = monVu.get();

        if(m != null) {
            return m;
        }
        else {
            return null;
        }
    }
}