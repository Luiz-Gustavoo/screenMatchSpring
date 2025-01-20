package br.com.alura.sreenmatch.service;

public interface IConverteDados {
    <T> T converteDados(String json, Class<T> classe);
}
