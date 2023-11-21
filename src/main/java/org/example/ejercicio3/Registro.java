package org.example.ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Registro {
    private String fichero = "registro.reg";
    private static Registro registro;

    public synchronized static Registro getInstance() {
        if (registro == null) {
            registro = new Registro();
        }
        return registro;
    }

    private synchronized String getDate() {

        String linea = "";

        try {

            Process p = new ProcessBuilder("date").start();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {

                linea = br.readLine();

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return linea;
    }

    public synchronized void registrar(String texto){

        texto = getDate() +" " + texto;

        try {
            ProcessBuilder pb = new ProcessBuilder("echo",texto);
            pb.redirectOutput(ProcessBuilder.Redirect.appendTo(new File(fichero)));

            pb.start();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public synchronized String getRegistro(){
        String texto = "";
        String linea = "";

        try {

            Process p = new ProcessBuilder("cat",fichero).start();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {

                while((linea = br.readLine())!=null)
                    texto+=linea+"\n";

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return texto;
    }


}
