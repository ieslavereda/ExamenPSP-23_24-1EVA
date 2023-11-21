package org.example.ejercicio4;

public class CocheDerecha implements Runnable {

    private Puente puente;

    public CocheDerecha(Puente puente) {
        this.puente = puente;
    }

    @Override
    public void run() {
        try {


            synchronized (puente) {
                // Comprobamos si podemos pasar
                while (!puente.puedeEntrarDerecha()) {
                    //System.out.println("Coche esperando por la derecha");
                    this.puente.wait();// Hay coches en sentido contrario, por lo que esperamos.
                }

                puente.entraD();// Notificamos al puente que hemos entrado
            }

            esperar(1000);// Tiempo en pasar por el puente

            synchronized (puente) {
                puente.saleI();// Notificamos al puente que salimos
                puente.notifyAll();// Notificamos al resto de hilos para ver si pueden acceder
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void esperar(int time) throws InterruptedException {
        Thread.sleep(time);
    }
}