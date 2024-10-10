package com.aluracursos.challenge;


import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Logs {
    public void guardarTxt(String texto) throws IOException {
        Date utilDate = new Date();
        Date fecha = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
        DateFormat date_file = new SimpleDateFormat("ddMMyyyy", Locale.US);
        String mensage =  "( "+dateFormat.format(utilDate.getTime())+" ) " +texto;
        FileWriter escritura = new FileWriter("archivo"+date_file.format(fecha.getTime())+".txt",true);
        escritura.write(mensage+"\n");
        escritura.close();
    }
}
