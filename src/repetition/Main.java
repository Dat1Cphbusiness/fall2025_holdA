package repetition;

import java.io.File;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        // todimensionelt
        // statisk - altid samme størrelse
        int[][] numbers = new int[3][4];

        // endimensionelt
        // dynamisk - ændrer størrelse efter antal elementer
        ArrayList<String> text = new ArrayList();
        String s = text.get(0);

        // todimensionel ArrayList. Bruges sjældent
       // ArrayList<ArrayList> dobbelt = new ArrayList();

        ArrayList mess = new ArrayList();
        mess.add("Hej");
        mess.add(12);
        mess.add(new File("data"));

        String t = (String) mess.get(0);

    }
}
