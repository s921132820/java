package basic;
//beans
class ParkSeHee {
    static String address = "인천";
    static String name = "박세희";
    int age = 20;
    boolean smart = false;
}

public class VariableScope {
    int b = 4;
    public static void main(String[] args) { //static은 static으로 올라감
        int a = 3; // stack에 올라감
        System.out.println(a);
        System.out.println(ParkSeHee.name);
    }
}