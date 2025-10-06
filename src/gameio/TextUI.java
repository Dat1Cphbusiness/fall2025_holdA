package gameio;

import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {

    private Scanner scanner = new Scanner(System.in);

    public int promptNumeric (String question){
        System.out.println(question);
        int result = scanner.nextInt();
        return result;
    }

    public String promptText(String question){
        System.out.println(question);
        String result = scanner.nextLine();
        return result;
    }
    // liste fx {"1: Peter", "2: Ole", "3: Bente", "4: Hanne"} og bruger skriver fx 2
    public int promptNumericChoice(ArrayList<String> options){
        for(String s: options){
            displayMessage(s);
        }
        int result = promptNumeric("Please type your choice as a number");
        return result;
    }

    // liste fx {"Peter", "Ole", "Bente", "Hanne"} og bruger skriver fx "Ole"
    public String promptTextChoice(ArrayList<String> choices){
        for(String s: choices){
            displayMessage(s);
        }
        String result = promptText("Please type your choice");
        return result;
    }

    public void displayMessage(String msg){
        System.out.println(msg);
    }

}
