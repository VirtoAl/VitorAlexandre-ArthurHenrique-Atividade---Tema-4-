package br.edu.up.Cinema;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class FIleManager {

    public File criarDiretorio(String path) {
        File diretorio =  new File(path);
        if (!diretorio.exists())
            diretorio.mkdir();

        return diretorio;
    }


    public File criarArquivo(File diretorio, String fileName) throws IOException {
        File file =  new File(diretorio, fileName);
        if (!file.exists())
            file.createNewFile();
        return file;
    }


    public void gravarDados(File file, ArrayList<Sessao> sessoes, double valorFinal) throws IOException {

        FileWriter fileWriter =  new FileWriter(file, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);


        for(int i = 0; i < sessoes.size(); i++){
            printWriter.print("Detalhes da Sessão:\n");
            printWriter.print("ID da Sessão: " + sessoes.get(i).getId() + "\n");
            printWriter.print("Filme: " + sessoes.get(i).getFilme().getTitulo() + "\n");
            printWriter.print("Data da Sessão: " + sessoes.get(i).getDataSessao() + "\n");
            printWriter.print("Hora da Sessão: " + sessoes.get(i).getHoraSessao() + "\n");
            printWriter.print("Número da Sala: " + sessoes.get(i).getNumSala() + "\n");
            printWriter.print("Assentos Disponíveis: " + sessoes.get(i).getAssentosDisponiveis() + "\n");
            printWriter.print("Quantidade de Ingressos Vendidos: " + sessoes.get(i).getIngressosDisponiveis().size() + "\n");
        }
        printWriter.print("\nValor total arrecadado: " + valorFinal);
        printWriter.flush();
        printWriter.close();
    }
}

