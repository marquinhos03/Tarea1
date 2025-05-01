package org.example;
import java.util.ArrayList;

class Deposito<T> {
    private ArrayList<T> deposito;

    public Deposito() {
        deposito = new ArrayList<>();
    }

    public void add(T elemento) {
        deposito.add(elemento);
    }

    public T get() {
        if (deposito.isEmpty()) {
            return null;
        } else {
            return deposito.remove(0);
        }
    }
}