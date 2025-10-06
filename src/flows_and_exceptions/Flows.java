package flows_and_exceptions;

public class Flows {
    public void methodA(String input) {
        System.out.println("a");
        if (!input.equals("start")) {
            System.out.println("b");
            methodB("start");
        } else {
            System.out.println("d");
            System.out.println(methodC(input));
        }
        System.out.println("i");
    }
    public void methodB(String start) {
        System.out.println("c");
    }
    public int methodC(String input) {
        System.out.println("e");
        methodD(input.length());
        return input.length() * 2;
    }
    public void methodD(int number) {
        System.out.println("f");
        if (number > 5) {
            System.out.println("g");
        }
        System.out.println("h");
    }
}
