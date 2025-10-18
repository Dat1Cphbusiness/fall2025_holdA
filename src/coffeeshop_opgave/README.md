# ☕ Opgave: Barista Manager med abstrakte klasser


Efter denne øvelse skal du kunne:
- Forklare forskellen mellem **abstrakte** og **konkrete** klasser.  
- Implementere **arv** og **metode-overriding** i subklasser.  
- Genbruge fælles kode i en abstrakt superklasse.  
- (Bonus) Bruge en `ArrayList` til at håndtere flere objekter af samme abstrakte type.

---

## 🧩 Scenarie

Forestil dig, at du arbejder som programmør for en nyopstartet **café**, der ønsker et system til at håndtere ordrer på drikkevarer.  

Alle drikkevarer har nogle **fælles egenskaber** som navn, størrelse og pris pr. ml, men de enkelte typer (kaffe, smoothie, te) har **forskellig prisberegning**.  

Du skal lave et Java-program, der modellerer dette med en **abstrakt superklasse** og **konkrete subklasser**.

---

## Del 1 – Abstrakt superklasse `Beverage`

Opret en **abstrakt klasse** `Beverage` med:

- Felter:  
  - `name` (`String`)  
  - `sizeMl` (`int`)  
  - `pricePerMl` (`double`)

- En **konkret metode** `printReceipt()` der udskriver navn, størrelse og totalpris.  
- En **abstrakt metode** `calculatePrice()` som returnerer en `double`.


```java
public abstract class Beverage {
    protected String name;
    protected int sizeMl;
    protected double pricePerMl;

    public Beverage(String name, int sizeMl, double pricePerMl) {
        this.name = name;
        this.sizeMl = sizeMl;
        this.pricePerMl = pricePerMl;
    }

    public void printReceipt() {
       // TODO
    }

    // TODO: Tilføj abstrakt metode her
    
}
```

## Del 2 – Subklasser

Lav mindst **to konkrete drikkevarer**, der **arver fra `Beverage`**.

Det kunne f.eks. være *Coffee* og *Smoothie*.

### ☕ `Coffee`
- Har et felt `boolean hasMilk`.  
- Pris = `sizeMl * pricePerMl`  
- +5 DKK hvis der er mælk.  

```java
public class Coffee extends Beverage {
    private boolean hasMilk;

    public Coffee(String name, int sizeMl, double pricePerMl, boolean hasMilk) {
        // TODO
    }

    @Override
    public double calculatePrice() {
        // TODO
    }
}
```

### 🍓 Smoothie

**Beskrivelse:**  
En smoothie kan have tilsat proteinpulver, som koster ekstra.

**Egenskaber:**  
- Felt: `boolean addProtein`  
- Prisberegning: `sizeMl * pricePerMl`  
- Ekstra tillæg: +10 DKK hvis der tilføjes proteinpulver  

```java
public class Smoothie extends Beverage {
    private boolean addProtein;

    public Smoothie(String name, int sizeMl, double pricePerMl, boolean addProtein) {
       // TODO
    }

    @Override
    public double calculatePrice() {
       // TODO
    }
}
```
---

## Del 3 - Testklasser

Lav en testklasse, der afprøver de forskellige drikkevarer:

```java
// Main
public class Main {
    public static void main(String[] args) {
        Coffee c = new Coffee("Latte", 250, 0.05, true);
        Smoothie s = new Smoothie("Berry Blast", 400, 0.04, true);

        c.printReceipt();
        s.printReceipt();
    }
}
```

### 💬 Spørgsmål til refleksion

- Hvorfor kan vi ikke lave `new Beverage(...)`?  
- Hvad sker der, hvis en subklasse glemmer at implementere `calculatePrice()`?
- Hvordan hjælper @Override med at undgå fejl?
- Hvilke metoder er fælles, og hvilke varierer mellem drikkevarerne?  

---

### ⚡ Ekstra udfordringer, hvis du har tid tilovers ...

1. Tilføj en tredje drikkevare, fx `Tea`, der giver rabat for “refill”.
2. Lav en ArrayList<Beverage> og loop gennem alle drikkevarer
3. Udskriv den samlede omsætning for alle ordrer.
