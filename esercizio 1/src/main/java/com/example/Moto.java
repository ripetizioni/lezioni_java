package com.example;

public class Moto extends Veicolo{
    private boolean haSidecar;

    public Moto(String marca, String modello, boolean haSidecar)
    {
        super (marca,modello);
        this.haSidecar=haSidecar;
    }

    public boolean isHaSidecar() {
        return haSidecar;
    }

    public void setHaSidecar(boolean haSidecar) {
        this.haSidecar = haSidecar;
    }

     public void impennata(){
        System.out.println("La moto sta impennando");
    }

    public void testaVeicolo(Moto moto){
        moto.accendi();
        moto.impennata();
    }

    @Override
    public String toString() {
        return "Moto [haSidecar=" + haSidecar + "]";
    }

   
}
