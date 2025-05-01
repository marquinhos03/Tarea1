package org.example;

class PagoInsuficienteException extends Exception {
    public PagoInsuficienteException(String errorMensaje) {
        super(errorMensaje);
    }
}