package torsdagsopgave_5_bugs;

public class MainCafe {

    public static void main(String[] args) {
        Cafe cafe = new Cafe();
        cafe.loadMenuData();

        System.out.println("Coffee menu:");
        for (int i = 0; i <= cafe.getCoffeeMenu().size(); i++) {
            System.out.println("- " + cafe.getCoffeeMenu().get(i));
        }
    }
}