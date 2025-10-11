package br.com.alura.sreenmatch.service;

import java.net.URLEncoder;

public class ConsultaMyMemory {
    ConsumirAPI consumirAPI = new ConsumirAPI();
    ConverteDados converteDados = new ConverteDados();

    public String retornaDados(String texto){
        try {

            String textoTraduzir = URLEncoder.encode(texto);
            String langpair = URLEncoder.encode("en|pt-br");

            String retornoApi = consumirAPI.obterDados("https://api.mymemory.translated.net/get?q="+textoTraduzir+"&langpair="+langpair);
            System.out.println(retornoApi);
            DadosTraducao dadosTraducao = converteDados.converteDados(retornoApi, DadosTraducao.class);
            System.out.println(dadosTraducao);
            return retornoApi;
        } catch (Exception e){
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
        return "erro";
    }
}
