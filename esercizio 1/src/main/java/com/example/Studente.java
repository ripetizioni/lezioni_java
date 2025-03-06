package com.example;

public class Studente extends Persona {

    private String corsoDiLaurea;

    public Studente(String nome, int età, int a, String corsoDiLaurea) {
        super(nome, età, a);

        this.corsoDiLaurea = corsoDiLaurea;
    }

    public String getCorsoDiLaurea() {
        return corsoDiLaurea;
    }

    @Override
    public String toString() {
        return super.toString() + ", Corso di Laurea: " + corsoDiLaurea;
    }
}
