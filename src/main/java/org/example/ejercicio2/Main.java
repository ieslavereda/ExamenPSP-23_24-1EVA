package org.example.ejercicio2;

import org.example.ejercicio3.Registro;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Deposito deposito = new Deposito();
        Operario operario = new Operario(deposito);

        List<Maquina> maquinas = new ArrayList<>();

        for(int i=1;i<=10;i++)
            maquinas.add(new Maquina(i,deposito));

        for(Maquina maquina : maquinas)
            new Thread(maquina).start();



        new Thread(operario).start();



    }
}
