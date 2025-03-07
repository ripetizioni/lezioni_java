package com.example;

public class App {

    public static void main(String[] args){
        
        Garage garage1=new Garage();
        Auto auto1=new Auto("Volkswagen", "Golf", 5);
        Auto auto2=new Auto("Mercedes", "Claase A", 5);
        Moto moto1=new Moto("Ducati","Monster", false);
        Moto moto2=new Moto("Harley Davidson", "Eritage 1340", true);
        Bicicletta bicicletta1=new Bicicletta("Bicicletta1","Bicicletta1", 6);
        Bicicletta bicicletta2=new Bicicletta("Bicicletta2","Bicicletta2", 7);

        garage1.aggiungiVeicolo(auto1);
        garage1.aggiungiVeicolo(auto2);
        garage1.aggiungiVeicolo(moto1);
        garage1.aggiungiVeicolo(moto2);
        garage1.aggiungiVeicolo(bicicletta1);
        garage1.aggiungiVeicolo(bicicletta2);
        garage1.mostraTuttiDettagli();
        
    }
}
