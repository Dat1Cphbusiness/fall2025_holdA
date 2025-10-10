package torsdagsopgave_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.spec.RSAOtherPrimeInfo;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class RessourceHaandtering {

    public void laesOgSkrivFil(String inputFil, String outputFil){
        Scanner scanner = null;
        PrintWriter writer = null;

        try{
            writer = new PrintWriter(new File(outputFil));
            scanner = new Scanner(new File(inputFil));

            ArrayList<String> input = new ArrayList<>();
            while(scanner.hasNext()){
                input.add(scanner.nextLine());
            }

            for(String s: input){
                writer.println(s);
            }

        }catch (FileNotFoundException e){
            System.out.println("Filen blev ikke fundet");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        finally{
            scanner.close();
            writer.close();
        }
    }

    public void scanAndThrow(String input) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(input));
               
    }
}
