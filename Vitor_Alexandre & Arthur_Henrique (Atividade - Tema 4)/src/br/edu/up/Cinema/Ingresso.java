package br.edu.up.Cinema;

public class Ingresso {

    // Identificador do ingresso
    private int id;
    private int idSessao; // Alteração: Armazena apenas o ID da sessão
    private Cliente cliente; // Alteração: Removido inicializador e associado ao cliente real
    private int assento;
    private double valor;

    // Construtor
    public Ingresso(int id, int idSessao, Cliente cliente, int assento, double valor) {
        this.id = id;
        this.idSessao = idSessao;
        this.cliente = cliente;
        this.assento = assento;
        this.valor = valor;
    }

    public Ingresso(int id, Integer assento, Integer idSessao, Cliente cliente, double valor) {
        this.id = id;
        this.assento = assento;
        this.idSessao = idSessao;
        this.cliente = cliente;
        this.valor = valor;
    }

    public void getDetalhes() {
        System.out.println("Numero do Ingresso: " + id);
        System.out.println("Sessao ID: " + idSessao);
        System.out.println("Cliente: " + cliente.getNome()); // Supondo que Cliente tenha um método getNome()
        System.out.println("Assento: " + assento);
        System.out.println("Valor pago: " + valor + " reais");
    }

    public double getValor() {
        return valor;
    }

    public int getAssento() {
        return assento;
    }

    // Métodos getters e setters, se necessário
}