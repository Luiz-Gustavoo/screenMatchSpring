package br.com.alura.sreenmatch.principal;


import java.util.Scanner;

public class Principal {
    private Scanner leitor = new Scanner(System.in);
    private final String ENDERECO = "https://omdbapi.com/?t=";
    private final String API_KEY = "&apikey=7589c63";

    public void exibeMenu(){
        System.out.println("Digite o nome da série");
        String nomeSerie = leitor.nextLine();

    }
}
