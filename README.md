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
- [JavaFX](#javafx)
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

## JavaFX

JavaFX è una piattaforma software moderna per lo sviluppo di interfacce grafiche (GUI) in Java, destinata a sostituire Swing. Offre strumenti potenti per creare applicazioni desktop ricche e interattive con grafica avanzata, animazioni, effetti visivi e supporto multimediale.

### Installazione e configurazione di JavaFX

#### Requisiti di sistema
- Java JDK 8 o superiore
- IDE compatibile (Eclipse, IntelliJ IDEA, NetBeans, VS Code)
- JavaFX SDK

#### Installazione con Java 8
In Java 8, JavaFX è incluso nel JDK standard, quindi non è necessario scaricare SDK aggiuntivi.

#### Installazione con Java 11+ (moduli)
A partire da Java 11, JavaFX è stato separato dal JDK standard:

1. **Scarica JavaFX SDK**: Visita [https://openjfx.io/](https://openjfx.io/) e scarica l'ultima versione del SDK
2. **Estrai l'archivio**: Posiziona i file in una directory permanente
3. **Configura il tuo IDE**: Aggiungi i moduli JavaFX al tuo progetto

#### Configurazione con Maven
Aggiungi queste dipendenze al tuo `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>21.0.1</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-fxml</artifactId>
        <version>21.0.1</version>
    </dependency>
    <!-- Opzionale: altri moduli -->
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-media</artifactId>
        <version>21.0.1</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-web</artifactId>
        <version>21.0.1</version>
    </dependency>
</dependencies>
```

Aggiungi il plugin JavaFX Maven:

```xml
<plugins>
    <plugin>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-maven-plugin</artifactId>
        <version>0.0.8</version>
        <configuration>
            <mainClass>com.example.MainApp</mainClass>
        </configuration>
    </plugin>
</plugins>
```

#### Configurazione con Gradle
Aggiungi JavaFX al tuo file `build.gradle`:

```gradle
plugins {
    id 'application'
    id 'org.openjfx.javafxplugin' version '0.0.13'
}

javafx {
    version = '21.0.1'
    modules = ['javafx.controls', 'javafx.fxml', 'javafx.media', 'javafx.web']
}

application {
    mainClassName = 'com.example.MainApp'
}
```

### Struttura di un'applicazione JavaFX

Un'applicazione JavaFX si basa su tre componenti principali:

1. **Stage**: La finestra principale dell'applicazione
2. **Scene**: Il contenitore per tutti gli elementi dell'interfaccia utente
3. **Node**: Gli elementi dell'interfaccia utente (controlli, contenitori, forme)

#### Architettura MVC (Model-View-Controller)
JavaFX supporta naturalmente il pattern MVC:
- **Model**: Dati e logica di business
- **View**: File FXML e componenti UI
- **Controller**: Classi Java che collegano Model e View

### Prima applicazione JavaFX

#### Esempio base:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PrimaApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Creazione di un'etichetta
        Label label = new Label("Benvenuto in JavaFX!");
        
        // Creazione di un contenitore
        StackPane root = new StackPane();
        root.getChildren().add(label);
        
        // Creazione della scena
        Scene scene = new Scene(root, 300, 200);
        
        // Configurazione dello stage
        primaryStage.setTitle("Prima Applicazione JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
```

#### Esecuzione con Java 11+ da linea di comando:

```bash
java --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -jar MyApp.jar
```

### Layout Manager in dettaglio

JavaFX fornisce diversi layout container per organizzare i componenti dell'interfaccia:

#### 1. BorderPane
Divide lo spazio in cinque regioni: top, bottom, left, right, center.
```java
BorderPane borderPane = new BorderPane();
borderPane.setTop(new Label("Intestazione"));
borderPane.setBottom(new Label("Piè di pagina"));
borderPane.setLeft(new Button("Sinistra"));
borderPane.setRight(new Button("Destra"));
borderPane.setCenter(new TextArea("Area centrale"));
```

#### 2. GridPane
Organizza i componenti in una griglia di righe e colonne, simile a una tabella:
```java
GridPane gridPane = new GridPane();
gridPane.setHgap(10); // Spazio orizzontale tra celle
gridPane.setVgap(10); // Spazio verticale tra celle
gridPane.setPadding(new Insets(10));

// Aggiunta di elementi: gridPane.add(nodo, colonna, riga)
gridPane.add(new Label("Nome:"), 0, 0);
gridPane.add(new TextField(), 1, 0);
gridPane.add(new Label("Cognome:"), 0, 1);
gridPane.add(new TextField(), 1, 1);
gridPane.add(new Button("Salva"), 1, 2);
```

#### 3. HBox e VBox
Dispongono i componenti orizzontalmente (HBox) o verticalmente (VBox):
```java
// HBox con 10 pixel di spazio tra i componenti
HBox hbox = new HBox(10);
hbox.getChildren().addAll(new Button("Uno"), new Button("Due"), new Button("Tre"));

// VBox con 10 pixel di spazio tra i componenti
VBox vbox = new VBox(10);
vbox.getChildren().addAll(new CheckBox("Opzione 1"), new CheckBox("Opzione 2"));
```

#### 4. FlowPane
Dispone i componenti in righe orizzontali o colonne verticali:
```java
FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL, 10, 10);
flowPane.setPadding(new Insets(10));
for (int i = 1; i <= 10; i++) {
    flowPane.getChildren().add(new Button("Bottone " + i));
}
```

#### 5. AnchorPane
Permette di ancorare i componenti ai bordi del contenitore:
```java
AnchorPane anchorPane = new AnchorPane();
Button button = new Button("Ancorato");
// Imposta distanza dai bordi
AnchorPane.setTopAnchor(button, 10.0);
AnchorPane.setRightAnchor(button, 10.0);
anchorPane.getChildren().add(button);
```

### Componenti UI e controlli

#### Controlli di base
```java
// Etichetta
Label label = new Label("Testo dell'etichetta");
label.setFont(new Font("Arial", 16));

// Pulsante
Button button = new Button("Clicca qui");
button.setOnAction(e -> System.out.println("Pulsante cliccato"));

// Campo di testo
TextField textField = new TextField("Testo iniziale");
textField.setPromptText("Inserisci testo");

// Area di testo
TextArea textArea = new TextArea("Testo su\npiù righe");
textArea.setWrapText(true); // Abilita il ritorno a capo automatico
```

#### Controlli di selezione
```java
// Casella di controllo
CheckBox checkBox = new CheckBox("Accetto i termini");
checkBox.setSelected(true);

// Pulsante radio
ToggleGroup group = new ToggleGroup();
RadioButton rb1 = new RadioButton("Opzione 1");
RadioButton rb2 = new RadioButton("Opzione 2");
rb1.setToggleGroup(group);
rb2.setToggleGroup(group);
rb1.setSelected(true);

// Menu a discesa
ComboBox<String> comboBox = new ComboBox<>();
comboBox.getItems().addAll("Opzione 1", "Opzione 2", "Opzione 3");
comboBox.setEditable(true); // Permette l'inserimento diretto
```

#### Liste e tabelle
```java
// ListView
ListView<String> listView = new ListView<>();
ObservableList<String> items = FXCollections.observableArrayList(
    "Elemento 1", "Elemento 2", "Elemento 3"
);
listView.setItems(items);

// TableView
TableView<Persona> tableView = new TableView<>();
TableColumn<Persona, String> nomeCol = new TableColumn<>("Nome");
nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
TableColumn<Persona, Integer> etaCol = new TableColumn<>("Età");
etaCol.setCellValueFactory(new PropertyValueFactory<>("eta"));
tableView.getColumns().addAll(nomeCol, etaCol);

// Aggiunta di dati alla tabella
ObservableList<Persona> persone = FXCollections.observableArrayList(
    new Persona("Mario", 30),
    new Persona("Luigi", 28)
);
tableView.setItems(persone);
```

#### Contenitori avanzati
```java
// TabPane (pannello a schede)
TabPane tabPane = new TabPane();
Tab tab1 = new Tab("Scheda 1");
tab1.setContent(new Label("Contenuto scheda 1"));
Tab tab2 = new Tab("Scheda 2");
tab2.setContent(new TextArea("Contenuto scheda 2"));
tabPane.getTabs().addAll(tab1, tab2);

// SplitPane (pannello divisibile)
SplitPane splitPane = new SplitPane();
splitPane.getItems().addAll(
    new Button("Area sinistra"),
    new TextArea("Area destra")
);
splitPane.setDividerPositions(0.3); // 30% a sinistra, 70% a destra

// Accordion
Accordion accordion = new Accordion();
TitledPane tp1 = new TitledPane("Sezione 1", new Label("Contenuto 1"));
TitledPane tp2 = new TitledPane("Sezione 2", new Button("Contenuto 2"));
accordion.getPanes().addAll(tp1, tp2);
```

### Gestione degli eventi in dettaglio

JavaFX utilizza un sistema di eventi basato sui listener. Ecco i principali tipi di eventi:

#### Eventi di mouse
```java
Button button = new Button("Clicca");

// Evento click
button.setOnAction(event -> {
    System.out.println("Cliccato!");
});

// Eventi mouse
button.setOnMouseEntered(event -> {
    button.setStyle("-fx-background-color: lightblue;");
});

button.setOnMouseExited(event -> {
    button.setStyle("");
});

button.setOnMousePressed(event -> {
    System.out.println("Mouse premuto alle coordinate: " + event.getX() + ", " + event.getY());
});
```

#### Eventi tastiera
```java
TextField textField = new TextField();
textField.setOnKeyPressed(event -> {
    System.out.println("Tasto premuto: " + event.getCode());
    
    if (event.getCode() == KeyCode.ENTER) {
        System.out.println("Invio premuto, elaboro il testo: " + textField.getText());
    }
});
```

#### Observer Pattern con ChangeListener
```java
Slider slider = new Slider(0, 100, 50);
Label valueLabel = new Label("50");

// Ascolta le modifiche al valore
slider.valueProperty().addListener((observable, oldValue, newValue) -> {
    valueLabel.setText(String.format("%.0f", newValue));
});
```

### FXML e Scene Builder

FXML è un linguaggio di markup XML che permette di separare l'interfaccia utente dalla logica di business.
Scene Builder è uno strumento visuale per progettare interfacce FXML senza scrivere codice.

#### Esempio di file FXML (layout.fxml)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>
<?import javafx.geometry.Insets?>

<VBox xmlns="http://javafx.com/javafx" 
      xmlns:fx="http://javafx.com/fxml"
      fx:controller="com.example.Controller"
      spacing="10" padding="10">
    <Label text="Inserisci il tuo nome:"/>
    <TextField fx:id="nameField"/>
    <Button text="Saluta" onAction="#handleButtonAction"/>
    <Label fx:id="greetingLabel"/>
</VBox>
```

#### Classe controller
```java
package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TextField nameField;
    @FXML private Label greetingLabel;
    
    @FXML
    private void handleButtonAction() {
        String name = nameField.getText();
        if (name.trim().isEmpty()) {
            greetingLabel.setText("Inserisci un nome valido!");
        } else {
            greetingLabel.setText("Ciao, " + name + "!");
        }
    }
}
```

#### Caricamento del file FXML
```java
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FXMLExampleApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carica il file FXML
        Parent root = FXMLLoader.load(getClass().getResource("/layout.fxml"));
        
        // Configura e mostra la scena
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Esempio FXML");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
```

### Styling con CSS

JavaFX supporta CSS per personalizzare l'aspetto dell'interfaccia utente.

#### File CSS di esempio (styles.css)
```css
/* Stile generale per l'applicazione */
.root {
    -fx-font-family: "Segoe UI", Arial, sans-serif;
    -fx-background-color: #f5f5f5;
}

/* Stile per i pulsanti */
.button {
    -fx-background-color: #2196F3;
    -fx-text-fill: white;
    -fx-font-weight: bold;
    -fx-padding: 8px 16px;
    -fx-cursor: hand;
}

.button:hover {
    -fx-background-color: #0d8aee;
}

.button:pressed {
    -fx-background-color: #0b7cd1;
}

/* Stile per i campi di testo */
.text-field {
    -fx-background-radius: 5;
    -fx-border-radius: 5;
    -fx-border-color: #cccccc;
    -fx-padding: 8px;
}

.text-field:focused {
    -fx-border-color: #2196F3;
}

/* Stile personalizzato con ID */
#titleLabel {
    -fx-font-size: 24px;
    -fx-font-weight: bold;
    -fx-text-fill: #2196F3;
}

/* Stile personalizzato con classe */
.warning {
    -fx-text-fill: #ff6600;
}

.error {
    -fx-text-fill: #ff0000;
}
```

#### Applicazione del CSS
```java
// Applicazione a livello di scena
scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

// Applicazione a un nodo specifico
button.getStyleClass().add("warning");

// Impostazione di uno stile inline
label.setStyle("-fx-font-size: 18px; -fx-text-fill: green;");

// Impostazione di un ID CSS
titleLabel.setId("titleLabel");
```

### Binding proprietà e JavaFX Properties

JavaFX fornisce un sistema di binding delle proprietà che consente di sincronizzare automaticamente i valori tra diversi componenti.

```java
// Creazione di proprietà
StringProperty textProperty = new SimpleStringProperty("Valore iniziale");
IntegerProperty countProperty = new SimpleIntegerProperty(0);

// Binding unidirezionale
Label label = new Label();
label.textProperty().bind(textProperty);

// Quando cambia textProperty, cambia automaticamente anche il testo della label
textProperty.set("Nuovo valore");

// Binding bidirezionale
TextField textField = new TextField();
textField.textProperty().bindBidirectional(textProperty);

// Binding con calcoli
Label countLabel = new Label();
countLabel.textProperty().bind(
    Bindings.concat("Conteggio: ", countProperty.asString())
);

// Incremento del conteggio
Button incButton = new Button("Incrementa");
incButton.setOnAction(e -> countProperty.set(countProperty.get() + 1));
```

### Grafica e forme vettoriali

JavaFX ha capacità grafiche avanzate per disegnare forme, applicare effetti e creare animazioni.

```java
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

// Canvas per disegno diretto
Canvas canvas = new Canvas(300, 300);
GraphicsContext gc = canvas.getGraphicsContext2D();
gc.setFill(Color.GREEN);
gc.fillRect(50, 50, 200, 100);
gc.setStroke(Color.BLUE);
gc.strokeOval(100, 100, 100, 100);

// Forme vettoriali
Circle circle = new Circle(100, 100, 50);
circle.setFill(Color.CORAL);
circle.setStroke(Color.BLACK);

Rectangle rectangle = new Rectangle(50, 50, 200, 100);
rectangle.setFill(Color.LIGHTSKYBLUE);
rectangle.setStrokeWidth(2);
rectangle.setArcWidth(20);
rectangle.setArcHeight(20);

// Linee e poligoni
Line line = new Line(0, 0, 100, 100);
line.setStroke(Color.RED);
line.setStrokeWidth(3);

Polygon triangle = new Polygon(
    0.0, 0.0,
    100.0, 0.0,
    50.0, 100.0
);
triangle.setFill(Color.YELLOW);
```

### Animazioni

JavaFX offre diverse classi per creare animazioni fluide:

```java
import javafx.animation.*;
import javafx.util.Duration;

// Animazione semplice di una proprietà
Button button = new Button("Animazione");
TranslateTransition translate = new TranslateTransition(Duration.seconds(2), button);
translate.setByX(200);  // Sposta orizzontalmente di 200 pixel
translate.setByY(50);   // Sposta verticalmente di 50 pixel
translate.setCycleCount(4);  // Ripeti 4 volte
translate.setAutoReverse(true);  // Torna indietro
translate.play();

// Animazione di ridimensionamento
ScaleTransition scale = new ScaleTransition(Duration.seconds(2), button);
scale.setToX(2.0);  // Scala a 2 volte la dimensione orizzontale
scale.setToY(2.0);  // Scala a 2 volte la dimensione verticale
scale.play();

// Animazione di rotazione
RotateTransition rotate = new RotateTransition(Duration.seconds(3), button);
rotate.setByAngle(360);  // Rotazione completa di 360 gradi
rotate.setCycleCount(Timeline.INDEFINITE);  // Ripeti all'infinito
rotate.setInterpolator(Interpolator.EASE_BOTH);  // Movimento fluido
rotate.play();

// Animazione di dissolvenza
FadeTransition fade = new FadeTransition(Duration.seconds(1.5), button);
fade.setFromValue(1.0);  // Completamente visibile
fade.setToValue(0.2);    // Quasi invisibile
fade.setCycleCount(Timeline.INDEFINITE);
fade.setAutoReverse(true);
fade.play();

// Sequenza di animazioni
SequentialTransition sequence = new SequentialTransition(
    translate,
    new PauseTransition(Duration.seconds(0.5)),  // Pausa
    rotate
);
sequence.play();

// Animazioni parallele
ParallelTransition parallel = new ParallelTransition(
    fade,
    scale
);
parallel.play();
```

### Threading e concorrenza

JavaFX ha un thread dedicato all'interfaccia utente (JavaFX Application Thread). Per le operazioni lunghe, usa `Task` e `Platform.runLater()`:

```java
import javafx.concurrent.Task;
import javafx.application.Platform;

// Esempio con Task
Button startButton = new Button("Avvia operazione lunga");
ProgressBar progressBar = new ProgressBar(0);
Label statusLabel = new Label("In attesa");

startButton.setOnAction(e -> {
    Task<String> task = new Task<>() {
        @Override
        protected String call() throws Exception {
            // Operazione lunga in background
            for (int i = 0; i <= 100; i++) {
                updateProgress(i, 100);  // Aggiorna la barra di progresso
                updateMessage("Elaborazione: " + i + "%");
                Thread.sleep(50);  // Simula lavoro
            }
            return "Operazione completata con successo!";
        }
        
        @Override
        protected void succeeded() {
            super.succeeded();
            statusLabel.setText(getValue());
        }
        
        @Override
        protected void failed() {
            super.failed();
            statusLabel.setText("Errore: " + getException().getMessage());
        }
    };
    
    // Collega la barra di progresso e l'etichetta al task
    progressBar.progressProperty().bind(task.progressProperty());
    statusLabel.textProperty().bind(task.messageProperty());
    
    // Avvia il task in un thread separato
    new Thread(task).start();
});

// Esempio con Platform.runLater
new Thread(() -> {
    // Codice in background
    // ...
    
    // Aggiorna l'UI nel thread JavaFX
    Platform.runLater(() -> {
        statusLabel.setText("Aggiornamento dall'altro thread");
    });
}).start();
```

### Dialoghi e alert

JavaFX fornisce vari tipi di finestre di dialogo predefinite:

```java
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ChoiceDialog;
import java.util.Optional;

// Alert semplice
Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
infoAlert.setTitle("Informazione");
infoAlert.setHeaderText("Operazione completata");
infoAlert.setContentText("Il file è stato salvato con successo.");
infoAlert.showAndWait();

// Alert di conferma con risposta
Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
confirmAlert.setTitle("Conferma");
confirmAlert.setHeaderText("Elimina file");
confirmAlert.setContentText("Sei sicuro di voler eliminare questo file?");
Optional<ButtonType> result = confirmAlert.showAndWait();

if (result.isPresent() && result.get() == ButtonType.OK) {
    System.out.println("File eliminato");
} else {
    System.out.println("Operazione annullata");
}

// Dialogo di input
TextInputDialog inputDialog = new TextInputDialog("nome predefinito");
inputDialog.setTitle("Input");
inputDialog.setHeaderText("Inserimento dati");
inputDialog.setContentText("Inserisci il tuo nome:");
Optional<String> inputResult = inputDialog.showAndWait();

inputResult.ifPresent(name -> {
    System.out.println("Nome inserito: " + name);
});

// Dialogo di scelta
ChoiceDialog<String> choiceDialog = new ChoiceDialog<>("Opzione 2", 
    "Opzione 1", "Opzione 2", "Opzione 3", "Opzione 4");
choiceDialog.setTitle("Scelta");
choiceDialog.setHeaderText("Seleziona un'opzione");
choiceDialog.setContentText("Scegli:");
Optional<String> choiceResult = choiceDialog.showAndWait();

choiceResult.ifPresent(choice -> {
    System.out.println("Scelta: " + choice);
});
```

### Distribuzione di applicazioni JavaFX

Per distribuire un'applicazione JavaFX, puoi utilizzare diversi approcci:

#### 1. JAR eseguibile
Utilizza Maven o Gradle per creare un JAR con tutte le dipendenze incluse.

Con Maven, aggiungi il plugin `maven-shade-plugin` al tuo `pom.xml`:

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-shade-plugin</artifactId>
    <version>3.2.4</version>
    <executions>
        <execution>
            <phase>package</phase>
            <goals>
                <goal>shade</goal>
            </goals>
            <configuration>
                <transformers>
                    <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                        <mainClass>com.example.MainApp</mainClass>
                    </transformer>
                </transformers>
            </configuration>
        </execution>
    </executions>
</plugin>
```

#### 2. jpackage (Java 14+)
`jpackage` è uno strumento incluso in Java 14+ che crea installer specifici per piattaforma:

```bash
jpackage --input target/ \
  --name MiaAppJavaFX \
  --main-jar app.jar \
  --main-class com.example.MainApp \
  --type dmg \
  --module-path /path/to/javafx-jmods \
  --add-modules javafx.controls,javafx.fxml
```

#### 3. jlink (Java 9+)
`jlink` crea un runtime personalizzato contenente solo i moduli Java necessari:

```bash
jlink --module-path /path/to/javafx-jmods:target/classes \
  --add-modules com.example.app,javafx.controls,javafx.fxml \
  --output custom-runtime \
  --launcher launcher=com.example.app/com.example.MainApp \
  --compress=2 --strip-debug --no-header-files --no-man-pages
```

### Applicazione di esempio completa: Gestore di contatti

Ecco un esempio di applicazione JavaFX completa che integra vari concetti discussi:

```java
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContattiApp extends Application {

    // Modello dati
    private static class Contatto {
        private final String nome;
        private final String cognome;
        private final String email;
        private final String telefono;

        public Contatto(String nome, String cognome, String email, String telefono) {
            this.nome = nome;
            this.cognome = cognome;
            this.email = email;
            this.telefono = telefono;
        }

        public String getNome() { return nome; }
        public String getCognome() { return cognome; }
        public String getEmail() { return email; }
        public String getTelefono() { return telefono; }
    }

    // Componenti UI
    private TableView<Contatto> tableView;
    private TextField nomeField, cognomeField, emailField, telefonoField;
    private ObservableList<Contatto> contatti;

    @Override
    public void start(Stage primaryStage) {
        // Inizializzazione dei dati
        contatti = FXCollections.observableArrayList(
            new Contatto("Mario", "Rossi", "mario@example.com", "333-1234567"),
            new Contatto("Luigi", "Verdi", "luigi@example.com", "333-7654321"),
            new Contatto("Anna", "Bianchi", "anna@example.com", "333-9876543")
        );

        // Layout principale
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // Pannello di form
        GridPane formPane = createFormPane();
        root.setTop(formPane);

        // Tabella contatti
        tableView = createTableView();
        root.setCenter(tableView);

        // Barra dei pulsanti
        HBox buttonBar = createButtonBar();
        root.setBottom(buttonBar);

        // Configurazione scena e stage
        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("/contatti.css").toExternalForm());
        
        primaryStage.setTitle("Gestore Contatti");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createFormPane() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 0, 20, 0));

        // Etichette e campi
        Label nomeLabel = new Label("Nome:");
        nomeField = new TextField();
        
        Label cognomeLabel = new Label("Cognome:");
        cognomeField = new TextField();
        
        Label emailLabel = new Label("Email:");
        emailField = new TextField();
        
        Label telefonoLabel = new Label("Telefono:");
        telefonoField = new TextField();

        // Disposizione nella griglia
        grid.add(nomeLabel, 0, 0);
        grid.add(nomeField, 1, 0);
        grid.add(cognomeLabel, 2, 0);
        grid.add(cognomeField, 3, 0);
        grid.add(emailLabel, 0, 1);
        grid.add(emailField, 1, 1);
        grid.add(telefonoLabel, 2, 1);
        grid.add(telefonoField, 3, 1);

        return grid;
    }

    private TableView<Contatto> createTableView() {
        TableView<Contatto> table = new TableView<>();
        
        // Colonne
        TableColumn<Contatto, String> nomeCol = new TableColumn<>("Nome");
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        TableColumn<Contatto, String> cognomeCol = new TableColumn<>("Cognome");
        cognomeCol.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        
        TableColumn<Contatto, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailCol.setPrefWidth(200);
        
        TableColumn<Contatto, String> telefonoCol = new TableColumn<>("Telefono");
        telefonoCol.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        table.getColumns().addAll(nomeCol, cognomeCol, emailCol, telefonoCol);
        table.setItems(contatti);
        
        // Gestione selezione
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                nomeField.setText(newVal.getNome());
                cognomeField.setText(newVal.getCognome());
                emailField.setText(newVal.getEmail());
                telefonoField.setText(newVal.getTelefono());
            }
        });

        return table;
    }

    private HBox createButtonBar() {
        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(20, 0, 10, 0));

        Button addButton = new Button("Aggiungi");
        addButton.getStyleClass().add("primary-button");
        addButton.setOnAction(e -> aggiungiContatto());

        Button deleteButton = new Button("Elimina");
        deleteButton.getStyleClass().add("danger-button");
        deleteButton.setOnAction(e -> eliminaContatto());

        Button clearButton = new Button("Pulisci Form");
        clearButton.setOnAction(e -> pulisciForm());

        hbox.getChildren().addAll(addButton, deleteButton, clearButton);
        return hbox;
    }

    private void aggiungiContatto() {
        String nome = nomeField.getText().trim();
        String cognome = cognomeField.getText().trim();
        String email = emailField.getText().trim();
        String telefono = telefonoField.getText().trim();

        if (nome.isEmpty() || cognome.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Dati incompleti");
            alert.setContentText("Nome e cognome sono obbligatori!");
            alert.showAndWait();
            return;
        }

        contatti.add(new Contatto(nome, cognome, email, telefono));
        pulisciForm();
    }

    private void eliminaContatto() {
        Contatto selectedContact = tableView.getSelectionModel().getSelectedItem();
        if (selectedContact != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Conferma eliminazione");
            alert.setHeaderText("Eliminare contatto");
            alert.setContentText("Sei sicuro di voler eliminare " + 
                    selectedContact.getNome() + " " + selectedContact.getCognome() + "?");

            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    contatti.remove(selectedContact);
                    pulisciForm();
                }
            });
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Nessuna selezione");
            alert.setHeaderText(null);
            alert.setContentText("Seleziona un contatto da eliminare!");
            alert.showAndWait();
        }
    }

    private void pulisciForm() {
        nomeField.clear();
        cognomeField.clear();
        emailField.clear();
        telefonoField.clear();
        tableView.getSelectionModel().clearSelection();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

File CSS di accompagnamento (`contatti.css`):

```css
.root {
    -fx-font-family: "Segoe UI", Arial, sans-serif;
    -fx-background-color: #f4f4f4;
}

.table-view {
    -fx-background-color: white;
    -fx-border-color: #ddd;
    -fx-border-width: 1px;
}

.table-view .column-header {
    -fx-background-color: #2196F3;
    -fx-text-fill: white;
    -fx-font-weight: bold;
}

.table-row-cell:odd {
    -fx-background-color: #f9f9f9;
}

.table-row-cell:selected {
    -fx-background-color: #bbdefb;
}

.text-field {
    -fx-padding: 8px;
    -fx-border-color: #ddd;
    -fx-border-radius: 4px;
    -fx-background-radius: 4px;
}

.button {
    -fx-padding: 8px 16px;
    -fx-background-radius: 4px;
    -fx-font-weight: bold;
    -fx-cursor: hand;
}

.primary-button {
    -fx-background-color: #2196F3;
    -fx-text-fill: white;
}

.primary-button:hover {
    -fx-background-color: #0d8aee;
}

.danger-button {
    -fx-background-color: #f44336;
    -fx-text-fill: white;
}

.danger-button:hover {
    -fx-background-color: #d32f2f;
}
```

### Risorse utili

- **Documentazione ufficiale**: [JavaFX Documentation](https://openjfx.io/javadoc/17/)
- **JavaFX Tutorial**: [JavaFX Tutorial](https://openjfx.io/openjfx-docs/)
- **Scene Builder Download**: [Scene Builder](https://gluonhq.com/products/scene-builder/)
- **Libro consigliato**: "JavaFX Essentials" di Mohamed Taman

## Conclusione

Java è un linguaggio potente e versatile che supporta concetti avanzati di programmazione orientata agli oggetti come l'ereditarietà, il polimorfismo e l'incapsulamento. Questi concetti aiutano a scrivere codice più organizzato, riutilizzabile e manutenibile.
