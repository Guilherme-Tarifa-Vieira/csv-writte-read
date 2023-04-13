package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        ListaObj<Cachorro> listaObj = new ListaObj<>(7);


        Cachorro c1 = new Cachorro(1, "Luna", "Vira-lata", 5.10);
        Cachorro c2 = new Cachorro(2, "Spike", "Vira-lata", 15.10);
        Cachorro c3 = new Cachorro(3, "Junin", "Vira-lata", 22.10);
        Cachorro c4 = new Cachorro(4, "Raul", "Vira-lata", 1.10);


        listaObj.adiciona(c1);
        listaObj.adiciona(c2);
        listaObj.adiciona(c3);
        listaObj.adiciona(c4);


        System.out.printf("%-5s%-20s%-20s%15s\n", "ID", "NOME", "RACA", "PESO");
        listaObj.exibe();
        gravar(listaObj, "dogs");
        ler("dogs");

    }

    public static void gravar(ListaObj<Cachorro> obj, String nomeArq) {
        FileWriter arq = null;
        Formatter ext = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        try {
            arq = new FileWriter(nomeArq);
            ext = new Formatter(arq);

        } catch (IOException e) {

            System.out.println("Erro ao abrir arquivo: " + e);
            e.printStackTrace();
            System.exit(1);

        }

        try {

            for (int i = 0; i < obj.getTamanho(); i++) {

                Cachorro ca = obj.getElemento(i);
                ext.format("%d;%s;%s;%.2f\n", ca.getId(), ca.getNome(), ca.getRaca(), ca.getPeso());

            }


        } catch (FormatterClosedException e) {
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
            e.printStackTrace();
            System.exit(1);

        } finally {

            ext.close();

            try {

                arq.close();
            } catch (IOException e) {

                System.out.println("Erro ao fechar arquivo");
                deuRuim = true;

            }

            if (deuRuim) {

                System.exit(1);
            }

        }


    }

    public static void ler(String nomeArq) {
        FileReader arq = null;
        Scanner scan = null;
        Boolean deuRuim = null;

        nomeArq += ".csv";

        try {

            arq = new FileReader(nomeArq);
            scan = new Scanner(arq).useDelimiter(";|\\n");

        } catch (FileNotFoundException e) {

            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }


        try {
            System.out.printf("%-5s%-20s%-20s%15s\n", "ID", "NOME", "RACA", "PESO");


            while (scan.hasNext()) {
                int id = scan.nextInt();
                String nome = scan.next();
                String raca = scan.next();
                Double peso = scan.nextDouble();

                System.out.printf("%-5d%-20s%-20s%15.2f\n", id, nome, raca, peso);


            }
        } catch (NoSuchElementException e) {

            System.out.println("Arquivo com problemas!");
            deuRuim = true;

        } catch (IllegalStateException e) {

            System.out.println("Arquivo com problemas!");
            deuRuim = true;

        } finally {

            scan.close();


            if (deuRuim) {

                System.exit(1);
            }

        }


    }


}