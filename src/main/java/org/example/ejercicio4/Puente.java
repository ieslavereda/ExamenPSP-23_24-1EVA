package org.example.ejercicio4;

public class Puente {

    private int circulandoIzqDer;
    private int circulandoDerIzq;

    public boolean puedeEntrarDerecha(){
        return circulandoIzqDer==0;
    }
    public boolean puedeEntrarIzquierda(){
        return circulandoDerIzq==0;
    }
    public void entraI() {
        circulandoIzqDer++;
        System.out.println("Un coche entra por la izquierda izq="+circulandoIzqDer+", der="+circulandoDerIzq);
    }

    public void entraD() {
        circulandoDerIzq++;
        System.out.println("Un coche entra por la derecha izq="+circulandoIzqDer+", der="+circulandoDerIzq);
    }

    public void saleI() {
        circulandoDerIzq--;
        System.out.println("Un coche sale por la izquierda izq="+circulandoIzqDer+", der="+circulandoDerIzq);
    }

    public void saleD() {
        circulandoIzqDer--;
        System.out.println("Un coche sale por la derecha izq="+circulandoIzqDer+", der="+circulandoDerIzq);
    }

}
