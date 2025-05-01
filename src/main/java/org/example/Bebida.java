package org.example;

abstract class Bebida {
    private int serie;

    public Bebida(int serie) {
        this.serie = serie;
    }

    public int getSerie() {
        return this.serie;
    }

    public abstract String beber();
}