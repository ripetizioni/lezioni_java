package com.example;

public class Veicolo{
    private String marca;
    private String modello;
    
    public Veicolo(String marca, String modello)
    {
        this.marca=marca;
        this.modello=modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }
    
    public void accendi()
    {
        System.out.println("Il veicolo e' acceso");
    }
    
    public void testaVeicolo(Veicolo veicolo){
        veicolo.accendi();
    }

    @Override
    public String toString() {
        return "Veicolo [marca=" + marca + ", modello=" + modello + "]";
    }
}