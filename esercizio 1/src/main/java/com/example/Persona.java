package com.example;

public class Persona {

    private String nome;
    private int età;
    private int a;

    public Persona(String nome, int età, int a) {
        this.nome = nome;
        this.età = età;
        a = a;
    }

    public String getNome() {
        return nome;
    }

    public int getEtà() {
        return età;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Eta: " + età;
    }
}
