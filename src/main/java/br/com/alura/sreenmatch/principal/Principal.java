package br.com.alura.sreenmatch.principal;


import br.com.alura.sreenmatch.model.DadosEpisodio;
import br.com.alura.sreenmatch.model.DadosSerie;
import br.com.alura.sreenmatch.model.DadosTemporada;
import br.com.alura.sreenmatch.service.ConsumirAPI;
import br.com.alura.sreenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitor = new Scanner(System.in);
    private final String ENDERECO = "https://omdbapi.com/?t=";
    private final String API_KEY = "&apikey=7589c63";
    private ConsumirAPI consumirAPI = new ConsumirAPI();
    private ConverteDados converteDados = new ConverteDados();

    public void exibeMenu(){


        System.out.println("Digite o nome da série: ");
        String nomeSerie = leitor.nextLine();

        String consultaSerie = consumirAPI.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie serieConvertida = converteDados.converteDados(consultaSerie, DadosSerie.class);
        System.out.println(serieConvertida);

        List<DadosTemporada> listaTemporadas = new ArrayList<>();

        for(int i = 1; i <= serieConvertida.Totaltemporadas(); i++){
            String consultaTemporadas = consumirAPI.obterDados(ENDERECO + nomeSerie.replace(" ", "+") +"&season=" +i+ API_KEY);
            DadosTemporada temporadaConvertida = converteDados.converteDados(consultaTemporadas, DadosTemporada.class);
            listaTemporadas.add(temporadaConvertida);
            System.out.println("teste");

        }

//        for (DadosTemporada temporada: listaTemporadas) {
//            System.out.println("-------------------------------------------------------");
//            System.out.println("Episódios da temporada: " + temporada.numero());
//            for(DadosEpisodio episodio: temporada.listaEpisodios()) {
//                System.out.println(episodio.titulo());
//            }
//        }
//
//        for(int i = 0; i < serieConvertida.Totaltemporadas(); i++) {
//            List<DadosEpisodio> listaEpisodios = listaTemporadas.get(i).listaEpisodios();
//            System.out.println("--------------------------------------------------------");
//            System.out.println("Episódios da temporada: " + listaTemporadas.get(i).numero());
//            for (int j = 0; j < listaEpisodios.size(); j++) {
//                System.out.println(listaEpisodios.get(j).titulo());
//            }
//        }


        listaTemporadas.forEach(temporada ->
                temporada.listaEpisodios().forEach(episodio ->
                        System.out.println("Temporada: " + temporada.numero() + " Episódio: " + episodio.titulo())));

    }
}
