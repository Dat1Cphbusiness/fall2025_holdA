package clinic;

public class Dog extends Pet {
    private boolean vaccinated;

    public Dog(String petName, String ownerName, double weight) {
        super(petName, ownerName, weight);
        vaccinated = false;
    }

    public void renewRabiesVaccine() {
        if (!vaccinated) {
            vaccinated = true;
            System.out.println(petName + " has been vaccinated against rabies.");
        } else {
            System.out.println(petName + " is already vaccinated.");
        }
    }


}
