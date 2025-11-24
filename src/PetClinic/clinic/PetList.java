package PetClinic.clinic;

import java.util.ArrayList;

public class PetList {

    ArrayList<Pet> pets = new ArrayList<>();

    public void addPet(Pet p) {
        pets.add(p);
    }

    public void printAllPets() {
        for (Pet p : pets) {
            System.out.println(p.toString());
        }
    }

    public void treatPets() {
        for (Pet p : pets) {
            if (p instanceof Dog)  {
                ((Dog) p).renewRabiesVaccine();
            }
            if (p instanceof Cat) {
                ((Cat) p).applyEarTattoo();
            }
        }
    }
}
