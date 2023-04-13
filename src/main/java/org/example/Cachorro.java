package org.example;

public class Cachorro {

    private int id;
    private String nome;
    private String raca;
    private Double peso;

    public Cachorro(int id, String nome, String raca, Double peso) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return String.format("%5d%-20s%-20s%15.2f", id, nome, raca, peso);
    }
}
