package repetition;
// Entitetsklasse. Passagerer findes i verden
public class Passenger {
    private String name;
    private int customerNo;
    private int age;

    public Passenger(String name, int customerNo, int age){
        this.name = name;
        this.customerNo = customerNo;
        this.age = age;
    }

    public Passenger(String name, int age){
        this.name = name;
        this.age = age;
    }

    // setter
    // this betyder "kig på instansvariable. IKKE lokal variable (parameter)"
    public void setName(String name){
        this.name = name;
    }

    // getter
    public String getName(){
        return name;
    }

}
