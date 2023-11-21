package org.example.ejercicio4;

public class Puente {

    private int circulandoIzqDer;
    private int circulandoDerIzq;

    // Gestionamos el requisito de entrada en el puente
    public boolean puedeEntrarDerecha(){
        return circulandoIzqDer==0;
    }
    public boolean puedeEntrarIzquierda(){
        return circulandoDerIzq==0;
    }


    // Registramos la entrada de coches por el puente y su sentido.
    public void entraI() {
        circulandoIzqDer++;
        System.out.println("Un coche entra por la izquierda izq="+circulandoIzqDer+", der="+circulandoDerIzq);
    }

    public void entraD() {
        circulandoDerIzq++;
        System.out.println("Un coche entra por la derecha izq="+circulandoIzqDer+", der="+circulandoDerIzq);
    }

    // Registramos la salida de coches por el puente y su sentido.
    public void saleI() {
        circulandoDerIzq--;
        System.out.println("Un coche sale por la izquierda izq="+circulandoIzqDer+", der="+circulandoDerIzq);
    }

    public void saleD() {
        circulandoIzqDer--;
        System.out.println("Un coche sale por la derecha izq="+circulandoIzqDer+", der="+circulandoDerIzq);
    }

}
