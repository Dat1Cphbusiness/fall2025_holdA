package clinic;

public class Cat extends Pet {
    private boolean earTattooed;   //en boolean til øremærke

    public Cat(String petName, String ownerName, double weight) {
        super(petName, ownerName, weight);
    }

    public void applyEarTattoo() {
        if (!earTattooed) {
            earTattooed = true;
            System.out.println(petName + " has recived an ear tattoo.");
        } else {
            System.out.println(petName + " already has an ear tattoo.");
        }
    }
}
