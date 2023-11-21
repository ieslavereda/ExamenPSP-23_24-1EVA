package org.example.ejercicio4;

public class CocheDerecha implements Runnable{

    private Puente puente;

    public CocheDerecha(Puente puente) {
        this.puente = puente;
    }

    @Override
    public void run() {
        try {

            while (true) {

                esperar((int)(Math.random()*2000));

                synchronized (puente) {
                    while (!puente.puedeEntrarDerecha()) {
                        System.out.println("Un coche esperando por la derecha");
                        this.puente.wait();
                    }

                    puente.entraD();
                }

                esperar(2000);

                synchronized (puente){
                    puente.saleI();
                    puente.notifyAll();
                }

            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void esperar(int time) throws InterruptedException {
        Thread.sleep(time);
    }
}