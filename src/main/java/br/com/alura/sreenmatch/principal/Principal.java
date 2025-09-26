package br.com.alura.sreenmatch.principal;


import br.com.alura.sreenmatch.model.DadosEpisodio;
import br.com.alura.sreenmatch.model.DadosSerie;
import br.com.alura.sreenmatch.model.DadosTemporada;
import br.com.alura.sreenmatch.model.Episodio;
import br.com.alura.sreenmatch.service.ConsumirAPI;
import br.com.alura.sreenmatch.service.ConverteDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner leitor = new Scanner(System.in);
    private final String ENDERECO = "https://omdbapi.com/?t=";
    private final String API_KEY = "&apikey=7589c63";
    private ConsumirAPI consumirAPI = new ConsumirAPI();
    private ConverteDados converteDados = new ConverteDados();
    private List<DadosSerie> listaSeries = new ArrayList<>();

    public void exibeMenu() {
        var opcao = 1;
        while (opcao != 0) {
            var menu = """
                    \n
                    1 - Buscar séries
                    2 - Buscar episódios
                    
                    0 - sair
                    """;
            System.out.println(menu);
            opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodiosPorSerie();
                    break;
                case 0:
                    System.out.println("finalizando...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
        public void buscarSerieWeb () {
            DadosSerie serie = buscarSerie();
            System.out.println(serie);
        }

        public DadosSerie buscarSerie () {
            System.out.println("Digite o nome da série: ");
            String nomeSerie = leitor.nextLine();

            String consultaSerie = consumirAPI.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
            DadosSerie serieConvertida = converteDados.converteDados(consultaSerie, DadosSerie.class);
            return serieConvertida;
        }

        public void buscarEpisodiosPorSerie () {
            List<DadosTemporada> listaTemporadas = new ArrayList<>();
            DadosSerie serie = buscarSerie();

            for (int i = 1; i < serie.Totaltemporadas(); i++) {
                String consultaTemporadas = consumirAPI.obterDados(ENDERECO + serie.titulo().replace(" ", "+") + "&Season=" + i + API_KEY);
                DadosTemporada temporadaConvertida = converteDados.converteDados(consultaTemporadas, DadosTemporada.class);
                listaTemporadas.add(temporadaConvertida);
            }
            listaTemporadas.forEach(System.out::println);
        }
    }

