package flows_and_exceptions;

public class ExceptionDemo {

    public void methodA(String input) throws Exception {
        System.out.println("a");
        System.out.println(input.charAt(4));
        System.out.println("b");
        methodB(input);
        System.out.println("c");
    }

    public void methodB(String input) {
        System.out.println("d");
        try{
            System.out.println(input.charAt(4));
            System.out.println("e");
        }
        catch (Exception e){
            System.out.println("f");
        }
        System.out.println("g");
    }

    public void methodC(String input){
        System.out.println("h");
        System.out.println(input.charAt(4));
    }

}
