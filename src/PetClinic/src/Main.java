import clinic.Cat;
import clinic.Dog;
import clinic.Pet;
import clinic.PetList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Liste af pets
        PetList clinic = new PetList();
        Dog dog = new Dog("Vitus", "Nicoline", 10);
        clinic.addPet(dog);
        Cat cat = new Cat("Lærke", "Katarina", 3.9);
        clinic.addPet(cat);

        //dog.renewRabiesVaccine();

        clinic.printAllPets();
        clinic.treatPets();
    }
}