package com.example;

public class Auto extends Veicolo{
    private int porte;

    public Auto(String marca,String modello, int porte)
    {
        super(marca,modello);
        this.porte=porte;
    }

    public int getPorte() {
        return porte;
    }

    public void setPorte(int porte) {
        this.porte = porte;
    }
    public void suonaClacson()
    {
        System.out.println("Bep bep");
    }
    
    public void testaVeicolo(Auto auto){
        auto.accendi();
        auto.suonaClacson();
    }

    @Override
    public String toString() {
        return "Questa è un auto con [porte: "+porte+"]";
    }    
}
