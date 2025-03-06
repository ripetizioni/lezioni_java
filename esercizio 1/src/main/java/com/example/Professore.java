package com.example;

public class Professore extends Persona {

    private String dipartimento;

    public Professore(String nome, int età, int a,  String dipartimento) {
        super(nome, età, a);
        this.dipartimento = dipartimento;
    }

    public String getDipartimento() {
        return dipartimento;
    }

    @Override
    public String toString() {
        return super.toString() + ", Dipartimento: " + dipartimento;
    }
}
