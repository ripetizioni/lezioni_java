package com.example;

import java.util.ArrayList;

public class Garage{
    ArrayList<Veicolo> veicoli;
    
    public Garage(){
        veicoli=new ArrayList<>();
    }

    public void aggiungiVeicolo(Veicolo veicolo){
        veicoli.add(veicolo);
    }

    public void mostraTuttiDettagli(){
        for (int i=0; i< veicoli.size();i++){
            System.out.println("\n"+veicoli.get(i).toString());
        }
    }
}
