package PetClinic.clinic;

public class Pet {
    protected String petName;
    protected String ownerName;
    protected double weight;

    public Pet(String petName, String ownerName, double weight) {
       this.petName = petName;
       this.ownerName = ownerName;
       this.weight = weight;
    }

    public String toString() {
        return "Pet name: " + petName +" \n " +" Ownername: " + ownerName + " \n " +" Weight: " + weight + " kg";
    }
}
