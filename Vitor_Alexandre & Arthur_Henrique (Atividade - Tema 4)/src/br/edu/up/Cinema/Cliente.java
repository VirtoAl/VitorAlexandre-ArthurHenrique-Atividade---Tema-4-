package br.edu.up.Cinema;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cliente {

    private int id;
    private String nome;
    private String CPF;
    private LocalDate dataNascimento;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Cliente(int id, String nome, String CPF, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
    }

    public void getDetalhes(){
        System.out.println("Identificador do cliente: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + CPF);
        System.out.println("Data de Nascimento: " + dataNascimento.format(formatter) + "\n");
    }

    public int getIdade(){
    int anoAtual = LocalDateTime.now().getYear();
    int anoNascimento = dataNascimento.getYear();

    return anoAtual - anoNascimento;
    }

    public String getNome() {
        return nome;
    }
}
