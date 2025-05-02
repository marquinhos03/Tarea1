package org.example;

abstract class Moneda implements Comparable<Moneda> {

    public Moneda() {}

    public abstract int getValor();

    @Override
    public String toString() {
        return this.hashCode() + " " + this.getValor();
    }

    @Override
    public int compareTo(Moneda moneda) {
        return Integer.compare(this.getValor(), moneda.getValor());
    }
}
