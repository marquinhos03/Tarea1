package org.example;
import java.util.ArrayList;

class Deposito<T> {
    private ArrayList<T> elementos;

    public Deposito() {
        elementos = new ArrayList<>();
    }

    public void add(T elem) {
        elementos.add(elem);
    }

    public T get() {
        if (elementos.isEmpty()) return null;
        return elementos.remove(0);
    }
}