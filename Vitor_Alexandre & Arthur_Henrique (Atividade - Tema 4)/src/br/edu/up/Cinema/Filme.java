package br.edu.up.Cinema;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Filme {

    // id = numero de identificaçao do filme
    private int id;
    private String titulo;
    private int duracaoMin;
    private String genero;
    private Integer classificacao;
    private String diretor;
    private String sinopse;
    // LocalDate = variavel pra usar datas
    private LocalDate dataLancamento;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Filme(int id, String titulo, int duracaoMin, String genero, Integer classificacao, String diretor, String sinopse, LocalDate dataLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.duracaoMin = duracaoMin;
        this.genero = genero;
        this.classificacao = classificacao;
        this.diretor = diretor;
        this.sinopse = sinopse;
        this.dataLancamento = dataLancamento;
    }

    public void getDetalhes(){
        System.out.println("Numero de identificacao: " + id);
        System.out.println("Titulo: " + titulo);
        System.out.println("Duraçao: " + duracaoMin +" min");
        System.out.println("Genero: " +  genero);
        System.out.println("Classificaçao: " + classificacao);
        System.out.println("Diretor: " + diretor);
        System.out.println("Sinopse: " + sinopse);
        System.out.println("Data de lançamento: " + dataLancamento + "\n");
    }

    public Integer getClassificacao() {
        return classificacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Numero de identificacao: " + id +
                "\nTitulo: " + titulo + "\nDuração: " + duracaoMin + " min" + "\nGenero: " + genero + "\nClassificação: " + classificacao + "\nDiretor: " + diretor + "\nSinopse: " + sinopse + "\nData de Lançamento: " + dataLancamento.format(formatter) + "\n\n";
    }
}
