package com.example;

public class Bicicletta extends Veicolo {
    private int marce;

    public Bicicletta(String marca, String modello, int marce){
        super(marca,modello);
        this.marce=marce;
    }

    public int getMarce() {
        return marce;
    }

    public void setMarce(int marce) {
        this.marce = marce;
    }

    public void pedala(){
        System.out.println("La bicicletta sta pedalando");
    }

    public void testaVeicolo(Bicicletta bicicletta){
        bicicletta.accendi();
        bicicletta.pedala();
    }

    @Override
    public String toString() {
        return "Bicicletta [marce=" + marce + "]";
    }
    
    
}
