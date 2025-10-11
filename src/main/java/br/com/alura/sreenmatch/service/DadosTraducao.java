package br.com.alura.sreenmatch.service;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTraducao(@JsonAlias("responseData") DadosResposta dadosResposta){ // pega o campo responseData do retorno. Como é um DadosResposta, pode ser usado em outro record para pegar outros campos
}
