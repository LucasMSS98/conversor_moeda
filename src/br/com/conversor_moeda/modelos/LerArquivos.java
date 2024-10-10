package br.com.conversor_moeda.modelos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LerArquivos {

    public void lerArquivo(String busca) {
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoSaida = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date data = formatoEntrada.parse(busca);
            String dataFormatada = formatoSaida.format(data);
            String diretorio = "src/br/com/conversor_moeda/arquivos/consulta_"+dataFormatada+".txt";
            FileReader ler = new FileReader(diretorio);
            BufferedReader lerArq = new BufferedReader(ler);
            String linha = lerArq.readLine();
            while(linha != null){
                System.out.printf("%s\n", linha);
                linha = lerArq.readLine();
            }
            ler.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            System.out.println("Formato de data inserido é invalido");
        }

    }
}
