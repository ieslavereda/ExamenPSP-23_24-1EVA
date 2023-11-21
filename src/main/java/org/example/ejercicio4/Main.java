package org.example.ejercicio4;

public class Main {
    public static void main(String[] args) {

        Puente puente = new Puente();

        // Hilo que simula la llegada de coches al puente por la derecha
        Thread productorDerecha = new Thread(() -> {

            while (true){
                esperarAleatorio();
                new Thread(new CocheDerecha(puente)).start();
            }

        });

        // Hilo que simula la llegada de coches al puente por la izquierda
        Thread productorIzquierda = new Thread(() -> {

            while (true){
                esperarAleatorio();
                new Thread(new CocheIzquierda(puente)).start();
            }

        });


        productorDerecha.start();
        productorIzquierda.start();


    }

    private static void esperarAleatorio() {
        try {
            Thread.sleep((int)(Math.random()*4000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}