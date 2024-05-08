package br.edu.up;

import br.edu.up.Cinema.Cliente;
import br.edu.up.Cinema.Filme;
import br.edu.up.Cinema.Sessao;
import br.edu.up.Cinema.FIleManager;


import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static final String DEFAULT_PATH = "C:\\Users\\autologon\\Documents";
    static final String DEFAULT_FILE_NAME = "dados-cinema.txt";

    public static void main(String[] args) throws IOException{

        Scanner scanner = new Scanner(System.in);
        int i,n,m,p,x,z = 0; // variáveis auxialiares
        double valor = 0;
        double valorFinal = 0;
        String aux = "";

        ArrayList<Filme> filmes = new ArrayList<Filme>();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        ArrayList<Integer> assento1 = new ArrayList<>();
        ArrayList<Integer> assento2 = new ArrayList<>();
        ArrayList<Integer> assento3 = new ArrayList<>();
        ArrayList<Integer> assento4 = new ArrayList<>();
        ArrayList<Integer> assento5 = new ArrayList<>();
        ArrayList<Sessao> sessoes = new ArrayList<Sessao>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        Filme filme1 = new Filme(0,"GarfieldKart", 93,"Aventura",0,"Jorge Ben Jor", "Filmão",LocalDate.parse("15/05/2024", formatter));
        Filme filme2 = new Filme(1,"Duna parte 2", 111,"Sci-Fi",16,"Denis Villeneuve", "Cinema",LocalDate.parse("20/04/2024", formatter));
        Filme filme3 = new Filme(2," Senhor sono", 63, "Terror", 18, "Kama Pistache", "Show de bola", LocalDate.parse("26/04/2024", formatter));

        Cliente cliente = new Cliente(0, "Nunca Vi Pedreiro Chamado Enzo", "666.666.666-66", LocalDate.parse("02/12/1984", formatter));
        Cliente cliente1 = new Cliente(1, "Ratanja Pinheiro", "433.263.287-36", LocalDate.parse("28/09/2014", formatter));
        Cliente cliente2 = new Cliente(2, "Resenhilson da Silva", "323.432.423-54", LocalDate.parse("22/12/1962", formatter));

        filmes.add(filme1);
        filmes.add(filme2);
        filmes.add(filme3);

        clientes.add(cliente);
        clientes.add(cliente1);
        clientes.add(cliente2);


        for(i = 1; i <= 30; i++) {
            assento1.add(i);
            assento2.add(i);
            assento3.add(i);
            assento4.add(i);
            assento5.add(i);
        }

        Sessao sessao1 = new Sessao(0,filmes.get(0), LocalDate.parse("12/05/2024", formatter), LocalTime.parse("10:15:00"), 7, assento1);
        Sessao sessao2 = new Sessao(1,filmes.get(2), LocalDate.parse("12/05/2024", formatter), LocalTime.parse("20:30:00"), 3, assento2);
        Sessao sessao3 = new Sessao(2,filmes.get(1), LocalDate.parse("13/05/2024", formatter), LocalTime.parse("18:00:00"), 7, assento3);
        Sessao sessao4 = new Sessao(3,filmes.get(0), LocalDate.parse("14/05/2024", formatter), LocalTime.parse("12:45:00"), 2, assento4);
        Sessao sessao5 = new Sessao(4,filmes.get(1), LocalDate.parse("14/05/2024", formatter), LocalTime.parse("17:00:00"), 1, assento5);

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

            valor = 0;
            for(n = 0; n < sessoes.size(); n++){
                for(m = 0; m < sessoes.get(n).getIngressosDisponiveis().size(); m++){
                    valor += sessoes.get(n).getIngressosDisponiveis().get(m).getValor();
                }
            }
            valorFinal = valor;

            switch (i){
                case 1:
                    System.out.println(filmes.toString());
                    break;
                case 2:
                    for(n = 0; n < sessoes.size(); n++){
                        sessoes.get(n).getDetalhesSessao();
                    }
                    System.out.println("Valor total arrecadado: " + valorFinal + "\n");
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
                            for(m = 0; m < sessoes.size(); m++){
                                sessoes.get(m).setId(m);
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Selecione o método que busca:\n1-Comprar ingresso\n2-Cancelar ingresso\n3-sair");
                    p = scanner.nextInt();
                    if (p != 1 && p != 2){
                        break;
                    }
                    System.out.print("Insira o Id do cliente que será cobrado (pagante de meia apenas com 12 ou menos anos): ");
                    x = scanner.nextInt();
                    System.out.println(clientes.get(x).getNome() + " tem " + clientes.get(x).getIdade() + " anos");


                    System.out.println("Insirao ID para qual sessão deseja manipular um ingresso:");
                    System.out.println("| Id |     Filme      |     Data      |  Horário  | sala |");
                    for(n = 0; n < sessoes.size(); n++){
                        System.out.println("  " + sessoes.get(n).getId() + "     " + sessoes.get(n).getFilme().getTitulo() + "      " + sessoes.get(n).getDataSessao().format(formatter) + "     " + sessoes.get(n).getHoraSessao() + "       " + sessoes.get(n).getNumSala());
                    }
                    System.out.printf("Id: ");
                    m = scanner.nextInt();
                    if(m > sessoes.size()-1 || m < 0){
                        System.out.println("Id inválido!");
                    } else {
                        if(clientes.get(x).getIdade() < sessoes.get(m).getFilme().getClassificacao()){
                            System.out.println("Não é permitida a entrada de menores de " + sessoes.get(m).getFilme().getClassificacao() + " anos para este filme!");
                            break;
                        }
                        if(p == 1){
                            if(clientes.get(x).getIdade() <= 12){
                                sessoes.get(m).venderIngressos(n,clientes.get(x),15.75);
                            } else {
                                sessoes.get(m).venderIngressos(n,clientes.get(x),31.50);
                            }
                        }
                        if (p == 2) {

                            if(clientes.get(x).getIdade() <= 12){
                                sessoes.get(m).cancelarIngresso();
                                valor -= 15.75;
                            } else {
                                sessoes.get(m).cancelarIngresso();
                                valor -= 31.50;
                            }
                        }
                    }
                    break;
                case 4:
                    for(n = 0; n < clientes.size(); n++){
                        clientes.get(n).getDetalhes();
                    }


                    break;
                case 5:
                    FIleManager fIleManager = new FIleManager();
                    File diretorio = fIleManager.criarDiretorio(DEFAULT_PATH);
                    File arquivo = fIleManager.criarArquivo(diretorio, DEFAULT_FILE_NAME);
                    fIleManager.gravarDados(arquivo, sessoes, valorFinal);
                    break;
                default:
                    System.out.println("Método inválido!");
            }

        } while(i != 5);
    }
}
