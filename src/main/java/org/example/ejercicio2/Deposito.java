package org.example.ejercicio2;

public class Deposito {

    private static final int CAPACIDAD_MAXIMA = 400;
    private int cantidad;

    public Deposito() {
        cantidad = 0;
    }

    public boolean estaLleno(){
        return cantidad>=CAPACIDAD_MAXIMA;
    }

    public void llenar(){
        cantidad++;
        System.out.println("Deposito cantidad="+cantidad);
    }

    public void vaciar(){
        cantidad=0;
    }
}
