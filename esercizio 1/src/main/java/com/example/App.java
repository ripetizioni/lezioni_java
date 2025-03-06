package com.example;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        Persona p = new Persona("Mario", 20, 1);
        Persona s = new Studente("Luca", 22, 2, "Informatica");
        Persona pr = new Professore("Giuseppe", 40, 3, "Informatica");
        ArrayList<Persona> persone = new ArrayList<>();
        persone.add(p);
        persone.add(s);
        persone.add(pr);

        for (int i = 0; i < persone.size(); i++) {
            System.out.println(persone.get(i));
        }
    }
}
