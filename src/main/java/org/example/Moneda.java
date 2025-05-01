package org.example;

abstract class Moneda {
    private static int contadorSerie = 0;
    private int serie;

    public Moneda() {
        this.serie = contadorSerie++;
    }

    public int getSerie() {
        return serie;
    }

    public abstract int getValor();
}