package org.example;

/**
 * Clase que representa un Snickers.
 */
public class Snickers extends Dulce {
    /**
     * Constructor para Snickers.
     * @param serie Número de serie único.
     */
    public Snickers(int serie) {
        super(serie);
    }

    @Override
    public String consumir() {
        return "snickers";
    }
}