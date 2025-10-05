package flows_and_exceptions;

public class MainFlow {

    public static void main(String[] args) {
        Flows flows = new Flows();
        //   System.out.println("flows.methodA(\"Hello, world\");");
        //   flows.methodA("Hello, world");
        System.out.println("flows.methodA(\"start\");");
        flows.methodA("start");
        System.out.println("flows.methodB(\"Hello, world\");");
        flows.methodB("Hello, world");
        System.out.println("flows.methodC(\"Hello, world\");");
        flows.methodC("Hello, world");
        System.out.println("flows.methodD(25);");
        flows.methodD(25);
    }


}
