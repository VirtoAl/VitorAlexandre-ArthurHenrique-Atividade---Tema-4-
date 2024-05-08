package br.edu.up.Cinema;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sessao {

    private int id;
    private Filme filme;
    private LocalDate dataSessao;
    private LocalTime horaSessao;
    private int numSala;
    private List<Integer> assentosDisponiveis;
    private List<Ingresso> ingressosDisponiveis;

    Scanner scanner = new Scanner(System.in);

    // Construtor
    public Sessao(int id, Filme filme, LocalDate dataSessao, LocalTime horaSessao, int numSala, List<Integer> assentosDisponiveis) {
        this.id = id;
        this.filme = filme;
        this.dataSessao = dataSessao;
        this.horaSessao = horaSessao;
        this.numSala = numSala;
        this.assentosDisponiveis = assentosDisponiveis;
        this.ingressosDisponiveis = new ArrayList<>();
    }

    public Sessao(int id) {
        this.id = id;
    }
    public Sessao(){

    }

    // Método para vender ingressos
    public void venderIngressos() {
        System.out.println("Mapa de Assentos disponíveis:");
        for (int i = 0; i < assentosDisponiveis.size(); i++) {
            System.out.print(assentosDisponiveis.get(i) + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.print("\nInsira qual assento deseja comprar: ");

        Integer assento = scanner.nextInt();

            if (assentosDisponiveis.contains(assento)) {
                // Remover o assento vendido da lista de assentos disponíveis
                assentosDisponiveis.remove(assento);
                // Criar e adicionar um novo ingresso à lista de ingressos disponíveis
                Ingresso novoIngresso = new Ingresso(this.id, assento);
                ingressosDisponiveis.add(novoIngresso);
                System.out.println("Ingresso para o assento " + assento + " vendido com sucesso!");
            } else {
                System.out.println("Assento " + assento + " não está disponível para venda.");
            }
    }

    public void cancelarIngresso() {

        System.out.println("Insira qual assento deseja reembolsar");
        Integer assento = scanner.nextInt();
        boolean ingressoEncontrado = false;
        for (Ingresso ingresso : ingressosDisponiveis) {
            if (ingresso.getAssento() == assento) {
                // Adicionar o assento cancelado de volta à lista de assentos disponíveis
                assentosDisponiveis.add(assento);
                // Remover o ingresso cancelado da lista de ingressos disponíveis
                ingressosDisponiveis.remove(ingresso);
                ingressoEncontrado = true;
                System.out.println("Ingresso para o assento " + assento + " cancelado com sucesso!");
                break;
            }
        }
        if (!ingressoEncontrado) {
            System.out.println("Não foi possível encontrar um ingresso para o assento " + assento + ".");
        }
    }

    public Sessao adicionarSessao(int id, ArrayList<Filme> filmes) {
        Sessao sessao = new Sessao(id);
        int i = 0;
        String aux = "";
        ArrayList<Integer> assentos = new ArrayList<>();

        System.out.println("Insira o Id do filme da sessão: ");
        for(i = 0; i < filmes.size(); i++){
            System.out.println(filmes.get(i).getId() + " - " + filmes.get(i).getTitulo());
        }
        i = scanner.nextInt();
        sessao.filme = filmes.get(i);
        System.out.print("Insira o dia marcado para nova sessão de cinema: ");
        aux = scanner.next();
        sessao.dataSessao = LocalDate.parse(aux);

        System.out.print("Insira a hora marcada para nova sessão de cimnema: ");
        aux = scanner.next();
        sessao.horaSessao = LocalTime.parse(aux);

        System.out.print("Insira a sala onde a sessão ocorrerá(1 - 10): ");
        i = scanner.nextInt();
        while(i < 1 || i > 10){
            System.out.println("Sala inváida, insira entre 1 e 10!");
            System.out.print("Insira a sala onde a sessão ocorrerá(1 - 10): ");
            i = scanner.nextInt();
        }
        sessao.numSala = i;

        for(i = 0; i < 30; i++) {
            assentos.add(i);
        }
        sessao.assentosDisponiveis = assentos;
        sessao.ingressosDisponiveis = new ArrayList<>();
        return sessao;
    }

    public void getDetalhesSessao() {
        System.out.println("Detalhes da Sessão:");
        System.out.println("ID da Sessão: " + id);
        System.out.println("Filme: " + filme.getTitulo());
        System.out.println("Data da Sessão: " + dataSessao);
        System.out.println("Hora da Sessão: " + horaSessao);
        System.out.println("Número da Sala: " + numSala);
        System.out.println("Assentos Disponíveis: " + assentosDisponiveis);
        System.out.println("Quantidade de Ingressos Vendidos: " + ingressosDisponiveis.size());
        System.out.println();
    }

    public int getId() {
        return id;
    }

    public List<Integer> getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public List<Ingresso> getIngressosDisponiveis() {
        return ingressosDisponiveis;
    }

    public LocalDate getDataSessao() {
        return dataSessao;
    }

    public LocalTime getHoraSessao() {
        return horaSessao;
    }

    public int getNumSala() {
        return numSala;
    }

    public Filme getFilme() {
        return filme;
    }
}


