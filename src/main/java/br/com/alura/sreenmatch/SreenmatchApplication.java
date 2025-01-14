package br.com.alura.sreenmatch;

import br.com.alura.sreenmatch.service.ConsumirAPI;
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
		String respostaAPI = consumirAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(respostaAPI);
	}
}
