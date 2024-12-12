package oopCh06;

// 강제로 구현해야하기 때문에 extends가 아니라 implements를 사용

public class Tiger implements AnimalInterface{
    private String name = "호랑이";

    public String getName() {
        return name;
    }

    @Override
    public void speak() {
        System.out.println("어흥");
    }

    @Override
    public boolean 육식인가() {
        return true;
    }

    @Override
    public String move() {
        return "엄청 빠름";
    }
}
