package org.example;

class NoHayProductoException extends Exception {
    public NoHayProductoException(String mensaje) {
        super(mensaje);
    }
}