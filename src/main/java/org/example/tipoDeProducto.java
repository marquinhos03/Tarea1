package org.example;

public enum tipoDeProducto {
    COCA(1,500) {
        public Producto elegirProducto(int serie) {
            return new CocaCola(serie);
        }
    },
    SPRITE(2,400) {
        public Producto elegirProducto(int serie) {
            return new Sprite(serie);
        }
    },
    FANTA(3,300) {
        public Producto elegirProducto(int serie) {
            return new Fanta(serie);
        }
    },
    SNICKERS(4,600) {
        public Producto elegirProducto(int serie) {
            return new Snickers(serie);
        }
    },
    SUPER8(5,700) {
        public Producto elegirProducto(int serie) {
            return new Super8(serie);
        }
    };

    private final int cual;
    private final int precio;
    public abstract Producto elegirProducto(int serie);

    tipoDeProducto(int cual, int precio) {
        this.cual = cual;
        this.precio = precio;
    }

    public static tipoDeProducto identificarProducto(int num) {
        for(tipoDeProducto cual : values()) {
            if(cual.getCual() == num) {
                return cual;
            }
        }
        return null;
    }

    public int getCual() {
        return cual;
    }

    public int getPrecio() {
        return precio;
    }
}
