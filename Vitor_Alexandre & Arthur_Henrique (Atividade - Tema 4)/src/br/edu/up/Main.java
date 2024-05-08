package br.edu.up;

import br.edu.up.Cinema.Filme;
import br.edu.up.Cinema.Sessao;
import br.edu.up.Cinema.FIleManager;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static final String DEFAULT_PATH = "D:\\Documents\\DadosCinema";
    static final String DEFAULT_FILE_NAME = "dados-cinema.txt";

    public static void main(String[] args) throws IOException{



        Scanner scanner = new Scanner(System.in);
        int i,n,m,p = 0; // variáveis auxialiares

        ArrayList<Filme> filmes = new ArrayList<Filme>();

        Filme filme1 = new Filme(0,"GarfieldKart", 93,"Aventura","L","Jorge Ben Jor", "Filmão",LocalDate.parse("2024-03-15"));
        Filme filme2 = new Filme(1,"Esse mesmo", 111,"Suspense","+16","Jorge Ben Jor", "Filmaço",LocalDate.parse("2024-04-20"));
        Filme filme3 = new Filme(2, "Senhor sono", 63, "Terror", "+18", "Kama Pistache", "Show de bola", LocalDate.parse("2024-04-26"));

        filmes.add(filme1);
        filmes.add(filme2);
        filmes.add(filme3);

        ArrayList<Integer> assento1 = new ArrayList<>();
        ArrayList<Integer> assento2 = new ArrayList<>();
        ArrayList<Integer> assento3 = new ArrayList<>();
        ArrayList<Integer> assento4 = new ArrayList<>();
        ArrayList<Integer> assento5 = new ArrayList<>();

        for(i = 0; i < 30; i++) {
            assento1.add(i);
            assento2.add(i);
            assento3.add(i);
            assento4.add(i);
            assento5.add(i);
        }

        Sessao sessao1 = new Sessao(0,filmes.get(0), LocalDate.parse("2024-05-12"), LocalTime.parse("10:15:00"), 7, assento1);
        Sessao sessao2 = new Sessao(1,filmes.get(2), LocalDate.parse("2024-05-12"), LocalTime.parse("20:30:00"), 3, assento2);
        Sessao sessao3 = new Sessao(2,filmes.get(1), LocalDate.parse("2024-05-13"), LocalTime.parse("18:00:00"), 7, assento3);
        Sessao sessao4 = new Sessao(3,filmes.get(0), LocalDate.parse("2024-05-14"), LocalTime.parse("12:45:00"), 2, assento4);
        Sessao sessao5 = new Sessao(4,filmes.get(1), LocalDate.parse("2024-05-14"), LocalTime.parse("17:00:00"), 1, assento5);

        ArrayList<Sessao> sessoes = new ArrayList<Sessao>();

        sessoes.add(sessao1);
        sessoes.add(sessao2);
        sessoes.add(sessao3);
        sessoes.add(sessao4);
        sessoes.add(sessao5);

        System.out.println("========================================================");
        System.out.println("SISTEMA DE GERENCIAMENTO DO CINEMA");
        System.out.println("========================================================");
        do {
            System.out.println("\n========================================================");
            System.out.println("Insira qual método deseja visualizar/alterar");
            System.out.println("1-Filmes em catálogo");
            System.out.println("2-Manipular Sessões disponíveis");
            System.out.println("3-venda e reembolso de ingressos");
            System.out.println("4-Acessar informações dos clientes");
            System.out.println("5-Sair do sistema / Salvar dados");
            System.out.println("========================================================");

            i = scanner.nextInt();

            switch (i){
                case 1:
                    System.out.println(filmes.toString());
                    break;
                case 2:
                    for(n = 0; n < sessoes.size(); n++){
                        sessoes.get(n).getDetalhesSessao();
                    }
                    System.out.println("Selecione o método que busca:\n1-Adicionar nova sessão\n2-Excluir sessão\n3-sair");
                    n = scanner.nextInt();
                    if(n == 1) {
                        sessoes.add(new Sessao().adicionarSessao(sessoes.size(), filmes));

                    } else if(n == 2){
                        System.out.println("Insira o id da sessão que deseja excluir");
                        n = scanner.nextInt();
                        if(n > sessoes.size()-1 || n < 0){
                            System.out.println("Id inválido!");
                        } else{
                            sessoes.remove(n);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Selecione o método que busca:\n1-Comprar ingresso\n2-Cancelar ingresso\n3-sair");
                    p = scanner.nextInt();
                    if (p != 1 && p != 2){
                        break;
                    }
                    System.out.println("Insirao ID para qual sessão deseja manipular um ingresso:");
                    System.out.println("| Id |     Filme      |     Data      |  Horário  | sala |");
                    for(n = 0; n < sessoes.size(); n++){
                        System.out.println("  " + sessoes.get(n).getId() + "     " + sessoes.get(n).getFilme().getTitulo() + "      " + sessoes.get(n).getDataSessao() + "     " + sessoes.get(n).getHoraSessao() + "       " + sessoes.get(n).getNumSala());
                    }
                    System.out.printf("Id: ");
                    m = scanner.nextInt();
                    if(m > sessoes.size()-1 || m < 0){
                        System.out.println("Id inválido!");
                    } else {
                        if(p == 1){
                            sessoes.get(m).venderIngressos();
                        }
                        if (p == 2) {
                            sessoes.get(m).cancelarIngresso();
                        }
                    }
                    break;
                case 4:


                    break;
                case 5:
                    FIleManager fIleManager = new FIleManager();
                    File diretorio = fIleManager.criarDiretorio(DEFAULT_PATH);
                    File arquivo = fIleManager.criarArquivo(diretorio, DEFAULT_FILE_NAME);
                    fIleManager.gravarDados(arquivo, sessoes);
                    break;
                default:
                    System.out.println("Método inválido!");
            }
        } while(i != 5);
    }
}