package org.example;

class PagoIncorrectoException extends Exception {
    public PagoIncorrectoException(String errorMensaje) {
        super(errorMensaje);
    }
}