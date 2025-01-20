package br.com.alura.sreenmatch;

import br.com.alura.sreenmatch.model.DadosEpisodio;
import br.com.alura.sreenmatch.model.DadosSerie;
import br.com.alura.sreenmatch.service.ConsumirAPI;
import br.com.alura.sreenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SreenmatchApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumirAPI consumirAPI = new ConsumirAPI();
		String consultaSerie = consumirAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");

		ConverteDados converteDados = new ConverteDados();
		DadosSerie serieConvertida = converteDados.obterDados(consultaSerie, DadosSerie.class);
		System.out.println(serieConvertida);

		String consultaEpisodio = consumirAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
		DadosEpisodio episodioConvertido = converteDados.obterDados(consultaEpisodio, DadosEpisodio.class);
	}
}
