package org.example.ejercicio4;

public class CocheIzquierda implements Runnable {

    private Puente puente;

    public CocheIzquierda(Puente puente) {
        this.puente = puente;
    }

    @Override
    public void run() {
        try {

            synchronized (puente) {
                while (!puente.puedeEntrarIzquierda()) {
                    System.out.println("Un coche esperando por la izquierda");
                    this.puente.wait();
                }

                puente.entraI();
            }

            esperar(1000);

            synchronized (puente) {
                puente.saleD();
                puente.notifyAll();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void esperar(int time) throws InterruptedException {
        Thread.sleep(time);
    }
}
