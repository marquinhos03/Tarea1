package org.example;

class NoHayProductoException extends Exception {
    public NoHayProductoException(String errorMensaje) {
        super(errorMensaje);
    }
}