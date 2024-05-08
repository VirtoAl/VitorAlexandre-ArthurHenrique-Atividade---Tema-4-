package br.edu.up.Cinema;

import java.time.LocalDate;

public class Cliente {

    private int id;
    private String nome;
    private String CPF;
    private LocalDate dataNascimento;


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
        System.out.println("Data de Nascimento: " + dataNascimento);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", CPF='" + CPF + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }

    public String getNome() {
        return nome;
    }
}
