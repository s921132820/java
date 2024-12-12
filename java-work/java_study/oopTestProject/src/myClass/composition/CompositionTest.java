package myClass.composition;

public class CompositionTest {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Car myCar = new Car(engine);
        int power = myCar.engineInfo();
        System.out.println("나의 엔진은 " + power + "cc");
    }
}
