package org.example.ejercicio2;

public class Vaca {

    private int cantidad;

    public Vaca() {
        cantidad=(int)(Math.random()*6)+35;
    }

    public boolean tieneLeche(){
       return cantidad>0;
    }
    public void sacarLeche(){
        cantidad--;
    }

    public int getCantidad(){
        return cantidad;
    }
}
