package oopCh05;

// abstract class는 new 가 안됨, 굳이 public이 아니여도 됨
// (public) abstract  -- public 이 생략되어 있음

public abstract class Animal {
    // 무조건 자식이 의무적으로 구현해야하는 메서드, 바디({})를 사용하지 않음
    // abstract class 밑에 abstract 메서드가 옴
    abstract void speak();

    public void defence() {
        System.out.println("모든 공격을 차단함");
    }
}
