package br.com.alura.sreenmatch.principal;


import br.com.alura.sreenmatch.model.DadosSerie;
import br.com.alura.sreenmatch.service.ConsumirAPI;
import br.com.alura.sreenmatch.service.ConverteDados;

import java.util.Scanner;

public class Principal {
    private Scanner leitor = new Scanner(System.in);
    private final String ENDERECO = "https://omdbapi.com/?t=";
    private final String API_KEY = "&apikey=7589c63";
    private ConsumirAPI consumirAPI = new ConsumirAPI();
    private ConverteDados converteDados = new ConverteDados();

    public void exibeMenu(){
        System.out.println("Digite o nome da série");
        String nomeSerie = leitor.nextLine();

        String consultaSerie = consumirAPI.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie serieConvertida = converteDados.converteDados(consultaSerie, DadosSerie.class);
        System.out.println(serieConvertida);
    }
}
