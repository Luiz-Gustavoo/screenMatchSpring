package br.com.alura.sreenmatch.model;


import java.util.OptionalDouble;

public class Serie {
    private String titulo;
    private Integer Totaltemporadas;
    private Double avaliacao;
    private Categoria genero;
    private String atores;
    private String poster;
    private String sinopse;

    Serie(DadosSerie dadosSerie) {
        this.titulo = dadosSerie.titulo();
        this.Totaltemporadas = dadosSerie.Totaltemporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0);
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        this.sinopse = dadosSerie.sinopse();
    }
}
