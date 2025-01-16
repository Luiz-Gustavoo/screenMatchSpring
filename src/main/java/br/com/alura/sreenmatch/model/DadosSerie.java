package br.com.alura.sreenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosSerie(@JsonAlias("Title") String titulo,
                         @JsonAlias("totalSeasons") Integer Totaltemporadas,
                         @JsonAlias("imdbRating") String avaliacao) {
}
