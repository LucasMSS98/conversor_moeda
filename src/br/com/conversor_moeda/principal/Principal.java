package br.com.conversor_moeda.principal;

import br.com.conversor_moeda.modelos.LerArquivos;
import br.com.conversor_moeda.modelos.MenuUsuario;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        MenuUsuario interfaceUsuario = new MenuUsuario();
        LerArquivos ler = new LerArquivos();
        Scanner sc = new Scanner(System.in);
        interfaceUsuario.menu();
        System.out.println("Deseja ler o arquivo de operações? 1-sim 2-nao");
        if(sc.nextInt() == 1){
            System.out.println("Insira uma data para consulta (dd/mm/aaaa)");
            ler.lerArquivo(sc.next());
        }


    }
}