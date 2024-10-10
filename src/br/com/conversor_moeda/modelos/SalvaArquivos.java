package br.com.conversor_moeda.modelos;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SalvaArquivos {
    public void gerarArquivo(String menu){
        FileWriter grava = null;
        try {
            String data = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
            String arquivo = "src/br/com/conversor_moeda/arquivos/consulta_"+data+".txt";
            grava = new FileWriter(arquivo, true);
            grava.write(String.format(menu+"\n"));
            grava.flush();

        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            try {
                if(grava != null){
                    grava.close();
                }
            } catch (IOException e) {
                System.out.println("Ocorreram problemas ao salvar o arquivo");
            }
        }
    }
}
