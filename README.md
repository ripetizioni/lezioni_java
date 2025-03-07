# Java

Java è un linguaggio di programmazione ad alto livello, orientato agli oggetti, sviluppato da Sun Microsystems (ora di proprietà di Oracle). È progettato per essere portabile, sicuro e robusto, ed è ampiamente utilizzato per lo sviluppo di applicazioni web, desktop e mobile.

## Concetti Principali

### Ereditarietà

L'ereditarietà è un concetto fondamentale della programmazione orientata agli oggetti che permette di creare una nuova classe basata su una classe esistente. La nuova classe eredita i campi e i metodi della classe esistente, permettendo il riutilizzo del codice. Questo consente di estendere le funzionalità di una classe senza modificarla direttamente, promuovendo il riutilizzo del codice e la manutenibilità.

In Java, l'ereditarietà si ottiene utilizzando la parola chiave `extends`. La classe che eredita è chiamata "classe derivata" o "sottoclasse", mentre la classe da cui eredita è chiamata "classe base" o "superclasse".

**Esempio:**

```java
class Animale {
    void mangia() {
        System.out.println("L'animale sta mangiando");
    }
}

class Cane extends Animale {
    void abbaia() {
        System.out.println("Il cane sta abbaiando");
    }
}

public class Main {
    public static void main(String[] args) {
        Cane cane = new Cane();
        cane.mangia(); // Output: L'animale sta mangiando
        cane.abbaia(); // Output: Il cane sta abbaiando
    }
}
```

In questo esempio, `Cane` è una sottoclasse di `Animale`. La classe `Cane` eredita il metodo `mangia` dalla classe `Animale` e aggiunge un nuovo metodo `abbaia`. Quando creiamo un oggetto `Cane`, possiamo chiamare sia il metodo `mangia` che il metodo `abbaia`.

### Polimorfismo

Il polimorfismo permette agli oggetti di essere trattati come istanze della loro classe base piuttosto che della loro classe derivata. Questo consente di scrivere codice più flessibile e riutilizzabile.

Esistono due tipi principali di polimorfismo:

1. **Polimorfismo di sottotipo (o polimorfismo di inclusione)**: Questo tipo di polimorfismo permette di utilizzare un oggetto di una classe derivata come se fosse un oggetto della classe base. Ad esempio, se hai una classe base `Animale` e una classe derivata `Cane`, puoi trattare un oggetto `Cane` come se fosse un oggetto `Animale`.

2. **Polimorfismo ad hoc (o polimorfismo di sovraccarico)**: Questo tipo di polimorfismo permette di avere più metodi con lo stesso nome ma con comportamenti diversi. Questo può essere ottenuto attraverso il sovraccarico dei metodi (overloading) e la sovrascrittura dei metodi (overriding).

    - **Sovraccarico dei metodi (overloading)**: Consente di definire più metodi con lo stesso nome ma con parametri diversi. Ad esempio, puoi avere un metodo `stampa` che accetta una stringa e un altro metodo `stampa` che accetta un numero intero.
    - **Sovrascrittura dei metodi (overriding)**: Consente a una classe derivata di fornire una specifica implementazione di un metodo che è già definito nella sua classe base. Ad esempio, la classe `Cane` può sovrascrivere il metodo `suono` della classe `Animale` per fornire una specifica implementazione che restituisce "bau bau".

**Esempio di polimorfismo di sottotipo:**

```java
class Animale {
    void suono() {
        System.out.println("L'animale fa un suono");
    }
}

class Cane extends Animale {
    void suono() {
        System.out.println("Il cane abbaia");
    }
}

class Gatto extends Animale {
    void suono() {
        System.out.println("Il gatto miagola");
    }
}

public class Main {
    public static void main(String[] args) {
        Animale mioAnimale = new Cane();
        mioAnimale.suono(); // Output: Il cane abbaia

        mioAnimale = new Gatto();
        mioAnimale.suono(); // Output: Il gatto miagola
    }
}
```

**Esempio di polimorfismo ad hoc (sovraccarico dei metodi):**
```java
public class Main {
    public static void main(String[] args) {
        stampa("Ciao");
        stampa(123);
    }

    static void stampa(String s) {
        System.out.println("Stringa: " + s);
    }

    static void stampa(int i) {
        System.out.println("Intero: " + i);
    }
}
```

### Incapsulamento

L'incapsulamento è il processo di nascondere i dettagli interni di un oggetto e di esporre solo ciò che è necessario attraverso metodi pubblici. Questo migliora la modularità e la sicurezza del codice. In Java, l'incapsulamento si ottiene utilizzando modificatori di accesso come `private`, `protected` e `public`.

- **private**: Il membro della classe è accessibile solo all'interno della stessa classe.
- **protected**: Il membro della classe è accessibile all'interno dello stesso pacchetto e dalle sottoclassi.
- **public**: Il membro della classe è accessibile da qualsiasi altra classe.

L'incapsulamento consente di controllare come i dati di un oggetto vengono modificati e acceduti, proteggendo così l'integrità dei dati.

**Esempio:**

```java
class Persona {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setNome("Mario");
        System.out.println(persona.getNome()); // Output: Mario
    }
}
```

In questo esempio, il campo `nome` della classe `Persona` è privato, quindi non può essere accessibile direttamente dall'esterno della classe. Tuttavia, possiamo accedere e modificare il campo `nome` utilizzando i metodi pubblici `getNome` e `setNome`.

## Conclusione

Java è un linguaggio potente e versatile che supporta concetti avanzati di programmazione orientata agli oggetti come l'ereditarietà, il polimorfismo e l'incapsulamento. Questi concetti aiutano a scrivere codice più organizzato, riutilizzabile e manutenibile.