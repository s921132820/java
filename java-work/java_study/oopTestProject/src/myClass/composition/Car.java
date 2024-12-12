package myClass.composition;
// 만들어져 있는 엔진을 가져다 사용만 할 것
public class Car {
    // 생성자 주입 방법
    private final Engine engine;
    public Car(Engine engine) {
        this.engine = engine;
    }

    public int engineInfo() {
        return engine.getPower();
    }
}
