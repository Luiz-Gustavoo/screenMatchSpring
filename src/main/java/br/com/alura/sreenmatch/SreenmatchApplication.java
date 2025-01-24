package br.com.alura.sreenmatch;

import br.com.alura.sreenmatch.model.DadosEpisodio;
import br.com.alura.sreenmatch.model.DadosSerie;
import br.com.alura.sreenmatch.model.DadosTemporada;
import br.com.alura.sreenmatch.service.ConsumirAPI;
import br.com.alura.sreenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SreenmatchApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumirAPI consumirAPI = new ConsumirAPI();
		ConverteDados converteDados = new ConverteDados();

		String consultaSerie = consumirAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=7589c63");
		DadosSerie serieConvertida = converteDados.converteDados(consultaSerie, DadosSerie.class);
		System.out.println(serieConvertida);

		String consultaEpisodio = consumirAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=7589c63");
		DadosEpisodio episodioConvertido = converteDados.converteDados(consultaEpisodio, DadosEpisodio.class);
		System.out.println(episodioConvertido);

		List<DadosTemporada> listaDeTemporadas = new ArrayList<>();

		for (int i = 1; i <= serieConvertida.Totaltemporadas(); i++) { // itera e consulta as informações de todas as temporadas
			String consultaTemporada = consumirAPI.obterDados("https://omdbapi.com/?t=gilmore+girls&season="+i+"&apikey=7589c63");

			DadosTemporada temporadaConvertida = converteDados.converteDados(consultaTemporada, DadosTemporada.class);
			listaDeTemporadas.add(temporadaConvertida);

			for (DadosTemporada temporada : listaDeTemporadas) {
				System.out.println("--------------------------------------------------");
				System.out.println("Episódios da temporada " + temporada.numero());
				for(DadosEpisodio episodio: temporada.listaEpisodios()) { // itera sobre os episódios da temporada sendo iterada atualmente
					if(episodio.numero() % 2 == 0) {
						System.out.println(episodio);
					}
				}
			}
		}
	}
}