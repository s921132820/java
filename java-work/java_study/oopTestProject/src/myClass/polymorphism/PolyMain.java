package myClass.polymorphism;

public class PolyMain {
    public static void main(String[] args) {
        Back backjongwon = new Back();
        System.out.println(backjongwon.name);
        backjongwon.work();

        Cooker cooker = new Cooker();
        System.out.println(cooker.name);
        cooker.work();

        Cooker back = new Back();
        System.out.println(back.name);
        back.work();

    }
}
