package org.example.ejercicio2;

public class Operario implements Runnable {

    private Deposito deposito;

    public Operario(Deposito deposito) {
        this.deposito = deposito;
    }

    @Override
    public void run() {

        while (true){

            synchronized (deposito){
                while (!deposito.estaLleno()) {
                    try {
                        deposito.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                deposito.vaciar();

                esperar(5000);

                deposito.notifyAll();
            }
        }

    }

    private void esperar(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
