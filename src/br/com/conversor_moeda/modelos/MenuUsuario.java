package br.com.conversor_moeda.modelos;

import br.com.conversor_moeda.conexao.ConsultaMoeda;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUsuario {

    public void menu() {
        Scanner sc = new Scanner(System.in);
        ConsultaMoeda consulta = new ConsultaMoeda();
        ConversaoMoeda converte = new ConversaoMoeda();
        SalvaArquivos salvaArquivos = new SalvaArquivos();
        GerarLog gerarLog = new GerarLog();
        String menu =
                """
                        ****************************************************************
                        
                        Selecione a opção que deseja converter a moeda:
                        
                        1)Converter Dolar => Real;
                        2)Converter Real => Dolar;
                        3)Converter Dolar => Peso argentino;
                        4)Converter Peso argentino => Dolar;
                        5)Converter Dolar => Boliviano boliviano;
                        6)Converter Boliviano boliviano => Dolar;
                        7)Converter Dolar => Peso Chileno;
                        8)Converter Peso Chileno => Dolar;
                        9)Converter Dolar => Peso Colombiano;
                        10)Converter Peso Colombiano => Dolar;
                        11)Nenhuma opção anterior;
                        12)Sair;
                        
                        ****************************************************************
                        """;
        int x = 0;
        while (x != 12) {
            try {
                String menuRetorno;
                System.out.println(menu);
                x = sc.nextInt();
                switch (x) {
                    case 1:
                        System.out.println("informe o valor que deseja converter:");
                        menuRetorno = converte.converteDolarReal(sc.nextDouble());
                        salvaArquivos.gerarArquivo(menuRetorno);
                        gerarLog.gerarLog(menuRetorno, "Opçao 1");
                        System.out.println(menuRetorno);
                        break;
                    case 2:
                        System.out.println("informe o valor que deseja converter:");
                        menuRetorno = converte.converteRealDolar(sc.nextDouble());
                        salvaArquivos.gerarArquivo(menuRetorno);
                        gerarLog.gerarLog(menuRetorno, "Opçao 2");
                        System.out.println(menuRetorno);
                        break;
                    case 3:
                        System.out.println("informe o valor que deseja converter:");
                        menuRetorno = converte.converterDolarPesoArg(sc.nextDouble());
                        salvaArquivos.gerarArquivo(menuRetorno);
                        gerarLog.gerarLog(menuRetorno, "Opçao 3");
                        System.out.println(menuRetorno);
                        break;
                    case 4:
                        System.out.println("informe o valor que deseja converter:");
                        menuRetorno = converte.converterPesoArgDolar(sc.nextDouble());
                        salvaArquivos.gerarArquivo(menuRetorno);
                        gerarLog.gerarLog(menuRetorno, "Opçao 4");
                        System.out.println(menuRetorno);
                        break;
                    case 5:
                        System.out.println("informe o valor que deseja converter:");
                        menuRetorno = converte.converterDolarBob(sc.nextDouble());
                        salvaArquivos.gerarArquivo(menuRetorno);
                        gerarLog.gerarLog(menuRetorno, "Opçao 5");
                        System.out.println(menuRetorno);
                        break;
                    case 6:
                        System.out.println("informe o valor que deseja converter:");
                        menuRetorno = converte.converterBobDolar(sc.nextDouble());
                        salvaArquivos.gerarArquivo(menuRetorno);
                        gerarLog.gerarLog(menuRetorno, "Opçao 6");
                        System.out.println(menuRetorno);
                        break;
                    case 7:
                        System.out.println("informe o valor que deseja converter:");
                        menuRetorno = converte.converterDolarPesoChi(sc.nextDouble());
                        salvaArquivos.gerarArquivo(menuRetorno);
                        gerarLog.gerarLog(menuRetorno, "Opçao 7");
                        System.out.println(menuRetorno);
                        break;
                    case 8:
                        System.out.println("informe o valor que deseja converter:");
                        menuRetorno = converte.converterPesoChiDolar(sc.nextDouble());
                        salvaArquivos.gerarArquivo(menuRetorno);
                        gerarLog.gerarLog(menuRetorno, "Opçao 8");
                        System.out.println(menuRetorno);
                        break;
                    case 9:
                        System.out.println("informe o valor que deseja converter:");
                        menuRetorno = converte.converterDolarPesoCol(sc.nextDouble());
                        salvaArquivos.gerarArquivo(menuRetorno);
                        gerarLog.gerarLog(menuRetorno, "Opçao 9");
                        System.out.println(menuRetorno);
                        break;
                    case 10:
                        System.out.println("informe o valor que deseja converter:");
                        menuRetorno = converte.converterPesoColDolar(sc.nextDouble());
                        salvaArquivos.gerarArquivo(menuRetorno);
                        gerarLog.gerarLog(menuRetorno, "Opçao 10");
                        System.out.println(menuRetorno);
                        break;
                    case 11:
                        System.out.println("informe a moeda de origem:");
                        String moeda = sc.next();
                        System.out.println("informe a moeda de destino:");
                        String moedaConversao = sc.next();
                        System.out.println("informe o valor que deseja converter:");
                        menuRetorno = converte.converterMoeda(moeda,moedaConversao, sc.nextDouble());
                        salvaArquivos.gerarArquivo(menuRetorno);
                        gerarLog.gerarLog(menuRetorno, "Opçao 11");
                        System.out.println(menuRetorno);
                    case 12:
                        break;
                    default:
                        System.out.println("Opção invalida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada Invalida, utilize apenas numeros!");
                sc.next();
            }catch (NullPointerException e){
                System.out.println("Moeda inserida é invalida");
                System.out.println("Deseja saber quais moedas estao disponiveis para conversao? 1- sim 2- não");
                if(sc.nextInt() == 1){
                    String json = consulta.ConsultarMoeda("USD");
                    JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String jsonFormatado = gson.toJson(jsonObject.getAsJsonObject("conversion_rates").keySet());
                    System.out.println(jsonFormatado);
                }
            }
            if (x != 12) {
                System.out.println("Deseja fazer uma nova conversão? 1- sim 2- não");
                if (sc.nextInt() == 2) {
                    x = 12;
                }
            }

        }
    }
}
