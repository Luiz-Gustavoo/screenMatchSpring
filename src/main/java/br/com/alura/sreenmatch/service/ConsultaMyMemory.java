package br.com.alura.sreenmatch.service;

import java.net.URLEncoder;

public class ConsultaMyMemory {
    static ConsumirAPI consumirAPI = new ConsumirAPI();
    static ConverteDados converteDados = new ConverteDados();

    public static String obterTraducao(String texto){
        try {

            String textoTraduzir = URLEncoder.encode(texto);
            String langpair = URLEncoder.encode("en|pt-br");

            String retornoApi = consumirAPI.obterDados("https://api.mymemory.translated.net/get?q="+textoTraduzir+"&langpair="+langpair);
            DadosTraducao dadosTraducao = converteDados.converteDados(retornoApi, DadosTraducao.class);

            return dadosTraducao.dadosResposta().textoTraduzido();
        } catch (Exception e){
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
        return null;
    }
}
