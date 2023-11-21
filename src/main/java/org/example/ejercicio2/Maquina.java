package org.example.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Maquina implements Runnable {

    private Deposito deposito;
    private int id;

    List<Vaca> vacas;

    public Maquina(int id, Deposito deposito) {
        this.deposito = deposito;
        this.id = id;

        vacas = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            vacas.add(new Vaca());

    }

    @Override
    public void run() {

        Vaca vaca;
        int cantidad;

        while (vacas.size() > 0) {

            System.out.println("En la maquina " + id + " entra una nueva vaca.");
            vaca = vacas.remove(0);
            cantidad = vaca.getCantidad();

            while (vaca.tieneLeche()) {

                vaca.sacarLeche();
                esperar(100);

                synchronized (deposito) {

                    while (deposito.estaLleno()) {
                        try {
                            deposito.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    deposito.llenar();
                    System.out.println("La maquina " + id + " ha introducido 1L");

                    deposito.notifyAll();
                }

            }
            System.out.println("Se han añadido un total de " + cantidad +"L de la vaca");

        }
        System.out.println("La maquina " + id + " ha terminado.");

    }

    private void esperar(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
