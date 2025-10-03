package torsdagsopgave_5;

public class MainCafe {

    public class Main {

        public static void main(String[] args) {
            Cafe cafe = new Cafe();
            cafe.loadMenuData();

            System.out.println("Coffee menu:");
            for (String coffee : cafe.getCoffeeMenu()) {
                System.out.println("- " + coffee);
            }
        }
    }
}
