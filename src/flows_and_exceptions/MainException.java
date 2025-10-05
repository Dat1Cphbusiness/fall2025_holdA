package flows_and_exceptions;

public class MainException {

    public static void main(String[] args) {
        ExceptionDemo exceptions = new ExceptionDemo();
        try{
            System.out.println("exceptions.methodA(\"Hello, world\");");
            exceptions.methodA("Hello, world");
        }
        catch (Exception e){
            System.out.println("Goodbye, world");
        }

        try{
            System.out.println("exceptions.methodA(\"Hi\");");
            exceptions.methodA("Hi");
        }
        catch (Exception e){
            System.out.println("Bye");
        }

        System.out.println("exceptions.methodB(\"Hello, world\");");
        exceptions.methodB("Hello, world");
        System.out.println("exceptions.methodB(\"Hi\");");
        exceptions.methodB("Hi");

        System.out.println("exceptions.methodC(\"Hello, world\");");
        exceptions.methodC("Hello, world");
        System.out.println("exceptions.methodC(\"Hi\");");
        exceptions.methodC("Hi");

    }
}
