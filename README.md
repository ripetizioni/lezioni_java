# Java

Java è un linguaggio di programmazione ad alto livello, orientato agli oggetti, sviluppato da Sun Microsystems (ora di proprietà di Oracle). È progettato per essere portabile, sicuro e robusto, ed è ampiamente utilizzato per lo sviluppo di applicazioni web, desktop e mobile.

https://www.w3schools.com/java/default.asp

## Indice dei Contenuti

- [Concetti Principali](#concetti-principali)
  - [Ereditarietà](#ereditarietà)
  - [Classi Astratte](#classi-astratte)
  - [Interfacce](#interfacce)
  - [Polimorfismo](#polimorfismo)
  - [Incapsulamento](#incapsulamento)
  - [Eccezioni](#eccezioni)
- [Stringhe](#stringhe)
- [Conclusione](#conclusione)

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

### Classi Astratte

Le classi astratte sono classi che non possono essere istanziate direttamente e sono progettate per essere estese da altre classi. Una classe astratta può contenere metodi astratti (metodi senza implementazione) e metodi concreti (metodi con implementazione).

Una classe astratta si definisce usando la parola chiave `abstract`. Se una classe contiene anche solo un metodo astratto, deve essere dichiarata come astratta. Le sottoclassi di una classe astratta devono implementare tutti i metodi astratti della classe genitore, a meno che la sottoclasse non sia a sua volta astratta.

Le classi astratte sono utili quando si vogliono definire comportamenti comuni per un gruppo di classi correlate, ma si vuole lasciare l'implementazione di alcuni metodi alle sottoclassi.

**Esempio:**

```java
abstract class Forma {
    // Metodo astratto
    abstract double calcolaArea();
    
    // Metodo concreto
    void descrivi() {
        System.out.println("Questa è una forma geometrica");
    }
}

class Cerchio extends Forma {
    private double raggio;
    
    public Cerchio(double raggio) {
        this.raggio = raggio;
    }
    
    @Override
    double calcolaArea() {
        return Math.PI * raggio * raggio;
    }
}

class Rettangolo extends Forma {
    private double lunghezza;
    private double larghezza;
    
    public Rettangolo(double lunghezza, double larghezza) {
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
    }
    
    @Override
    double calcolaArea() {
        return lunghezza * larghezza;
    }
}

public class Main {
    public static void main(String[] args) {
        Forma cerchio = new Cerchio(5);
        Forma rettangolo = new Rettangolo(4, 6);
        
        System.out.println("Area del cerchio: " + cerchio.calcolaArea());
        cerchio.descrivi();
        
        System.out.println("Area del rettangolo: " + rettangolo.calcolaArea());
        rettangolo.descrivi();
    }
}
```

Importante notare che non è possibile creare un'istanza di una classe astratta (ad esempio, `new Forma()` non è consentito), ma possiamo usare una classe astratta come tipo di riferimento per le sue sottoclassi concrete.

### Interfacce

Le interfacce in Java sono un tipo di riferimento, simile alle classi, che può contenere solo costanti, dichiarazioni di metodi, metodi default, metodi statici e tipi annidati. Le interfacce non possono essere istanziate, ma possono essere implementate da altre classi o estese da altre interfacce.

Le interfacce definiscono un contratto che le classi devono rispettare: una classe che implementa un'interfaccia deve fornire un'implementazione per tutti i metodi dichiarati nell'interfaccia.

**Caratteristiche principali:**

- I metodi dichiarati in un'interfaccia sono implicitamente pubblici e astratti (prima di Java 8)
- Le costanti in un'interfaccia sono implicitamente `public`, `static` e `final`
- Da Java 8, le interfacce possono avere metodi default e statici con implementazione
- Una classe può implementare più interfacce (a differenza dell'ereditarietà singola delle classi)

**Sintassi:**

```java
interface NomeInterfaccia {
    // Costanti
    tipo COSTANTE = valore;
    
    // Metodi astratti
    tipo nomeMetodo(parametri);
    
    // Metodi default (Java 8+)
    default tipo nomeMetodoDefault(parametri) {
        // implementazione
    }
    
    // Metodi statici (Java 8+)
    static tipo nomeMetodoStatico(parametri) {
        // implementazione
    }
}

class MiaClasse implements NomeInterfaccia {
    // Implementazione dei metodi dell'interfaccia
    @Override
    public tipo nomeMetodo(parametri) {
        // implementazione
    }
}
```

**Esempio di interfaccia:**

```java
interface Volante {
    void vola();
    
    default void plana() {
        System.out.println("Planando in aria...");
    }
}

interface Nuotante {
    void nuota();
}

class Uccello implements Volante {
    @Override
    public void vola() {
        System.out.println("L'uccello vola sbattendo le ali");
    }
}

class Aereo implements Volante {
    @Override
    public void vola() {
        System.out.println("L'aereo vola con i motori");
    }
    
    @Override
    public void plana() {
        System.out.println("L'aereo plana con le ali");
    }
}

class Pesce implements Nuotante {
    @Override
    public void nuota() {
        System.out.println("Il pesce nuota muovendo le pinne");
    }
}

// Una classe può implementare più interfacce
class Anatra implements Volante, Nuotante {
    @Override
    public void vola() {
        System.out.println("L'anatra vola sbattendo le ali");
    }
    
    @Override
    public void nuota() {
        System.out.println("L'anatra nuota galleggiando sull'acqua");
    }
}

public class EsempioInterfacce {
    public static void main(String[] args) {
        Volante v1 = new Uccello();
        Volante v2 = new Aereo();
        Nuotante n1 = new Pesce();
        Anatra a = new Anatra();
        
        v1.vola();       // Output: L'uccello vola sbattendo le ali
        v1.plana();      // Output: Planando in aria...
        
        v2.vola();       // Output: L'aereo vola con i motori
        v2.plana();      // Output: L'aereo plana con le ali
        
        n1.nuota();      // Output: Il pesce nuota muovendo le pinne
        
        a.vola();        // Output: L'anatra vola sbattendo le ali
        a.nuota();       // Output: L'anatra nuota galleggiando sull'acqua
    }
}
```

#### Differenze tra Interfacce e Classi Astratte

| Caratteristica | Interfaccia | Classe Astratta |
|---------------|------------|----------------|
| Metodi | Solo astratti (prima di Java 8), default e statici (da Java 8) | Può avere sia metodi astratti che concreti |
| Variabili | Solo costanti (public static final) | Può avere variabili di istanza non final |
| Costruttore | Non può avere costruttori | Può avere costruttori |
| Implementazione multipla | Una classe può implementare più interfacce | Una classe può estendere solo una classe astratta |
| Accesso ai membri | Tutti i membri sono implicitamente pubblici | I membri possono avere qualsiasi modificatore di accesso |
| Quando usarle | Quando si vuole definire comportamenti comuni per classi non correlate | Quando si vuole condividere codice tra classi correlate |

Le interfacce sono uno strumento potente in Java che promuove un design orientato ai contratti e facilita l'implementazione del polimorfismo.

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

### Eccezioni

Le eccezioni in Java rappresentano un meccanismo per gestire errori ed eventi anomali che possono verificarsi durante l'esecuzione di un programma. Il sistema di gestione delle eccezioni permette di separare la logica di gestione degli errori dal flusso normale del codice.

#### Gerarchia delle Eccezioni

In Java, tutte le eccezioni derivano dalla classe `Throwable`. Ci sono due sottoclassi principali:

1. **Error**: Rappresenta errori gravi, tipicamente non recuperabili (come `OutOfMemoryError`).
2. **Exception**: Rappresenta condizioni eccezionali recuperabili.
   - **Checked Exceptions**: Verificate dal compilatore (estendono `Exception` ma non `RuntimeException`).
   - **Unchecked Exceptions**: Non verificate dal compilatore (estendono `RuntimeException`).

#### Blocco try-catch-finally

La struttura base per la gestione delle eccezioni in Java è il blocco try-catch-finally:

```java
try {
    // Codice che potrebbe generare un'eccezione
} catch (TipoEccezione1 e1) {
    // Gestione dell'eccezione di tipo TipoEccezione1
} catch (TipoEccezione2 e2) {
    // Gestione dell'eccezione di tipo TipoEccezione2
} finally {
    // Codice che viene eseguito sempre, indipendentemente da eccezioni
}
```

**Esempio:**

```java
public class EsempioEccezioni {
    public static void main(String[] args) {
        try {
            int[] numeri = {1, 2, 3};
            System.out.println(numeri[5]); // Genera ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Errore: Hai tentato di accedere a un indice non valido.");
        } finally {
            System.out.println("Questo blocco viene sempre eseguito.");
        }
        
        System.out.println("Il programma continua...");
    }
}
```

#### Checked vs Unchecked Exceptions

1. **Checked Exceptions**: Devono essere dichiarate nella firma del metodo con `throws` o gestite con try-catch.
   Esempi: `IOException`, `SQLException`

2. **Unchecked Exceptions**: Non è obbligatorio gestirle o dichiararle.
   Esempi: `NullPointerException`, `ArrayIndexOutOfBoundsException`

**Esempio di checked exception:**

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LetturaFile {
    public static void main(String[] args) {
        try {
            File file = new File("inesistente.txt");
            Scanner scanner = new Scanner(file); // Può generare FileNotFoundException
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Errore: File non trovato.");
            e.printStackTrace();
        }
    }
}
```

#### Lanciare Eccezioni

È possibile lanciare manualmente un'eccezione usando la parola chiave `throw`:

```java
public class ControlloEtà {
    public static void verificaEtà(int età) {
        if (età < 0) {
            throw new IllegalArgumentException("L'età non può essere negativa");
        }
        if (età < 18) {
            System.out.println("Sei minorenne");
        } else {
            System.out.println("Sei maggiorenne");
        }
    }
    
    public static void main(String[] args) {
        try {
            verificaEtà(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
```

#### Eccezioni Personalizzate

È possibile creare eccezioni personalizzate estendendo le classi `Exception` o `RuntimeException`:

```java
// Eccezione personalizzata checked
class SaldoInsufficienteException extends Exception {
    public SaldoInsufficienteException(String messaggio) {
        super(messaggio);
    }
}

class ContoCorrente {
    private double saldo;
    
    public ContoCorrente(double saldoIniziale) {
        this.saldo = saldoIniziale;
    }
    
    public void preleva(double importo) throws SaldoInsufficienteException {
        if (importo > saldo) {
            throw new SaldoInsufficienteException("Saldo insufficiente. Saldo attuale: " + saldo);
        }
        saldo -= importo;
        System.out.println("Prelievo effettuato. Nuovo saldo: " + saldo);
    }
    
    public static void main(String[] args) {
        ContoCorrente conto = new ContoCorrente(1000);
        try {
            conto.preleva(1500);
        } catch (SaldoInsufficienteException e) {
            System.out.println("Operazione fallita: " + e.getMessage());
        }
    }
}
```

Le eccezioni sono un potente strumento che permette di gestire situazioni anomale in modo strutturato, migliorando la robustezza e la leggibilità del codice.

## Stringhe
https://www.w3schools.com/java/java_strings.asp



## Conclusione

Java è un linguaggio potente e versatile che supporta concetti avanzati di programmazione orientata agli oggetti come l'ereditarietà, il polimorfismo e l'incapsulamento. Questi concetti aiutano a scrivere codice più organizzato, riutilizzabile e manutenibile.
