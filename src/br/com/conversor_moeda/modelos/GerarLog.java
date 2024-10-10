package br.com.conversor_moeda.modelos;

import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;


public class GerarLog {
    public void gerarLog(String menu, String opcao){
        FileWriter grava = null;

        try {
            ZonedDateTime dataHora = ZonedDateTime.now();
            String arquivo = "src/br/com/conversor_moeda/logs/"+dataHora.toString().replaceAll("[:,/]",".")+".log";
            grava = new FileWriter(arquivo, true);
            grava.write(String.format(menu + " - " + opcao + " - " + dataHora + "\n"));
            grava.flush();

        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try {
                if(grava != null){
                    grava.close();
                }
            } catch (IOException e) {
                System.out.println("Ocorreram problemas ao salvar o log");
            }
        }
    }
}
