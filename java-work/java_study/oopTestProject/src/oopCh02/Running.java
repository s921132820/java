package oopCh02;

public class Running {
    //생성자 오버로딩
    private String name;
    // 기본 생성자 -- 기본생성자는 반드시 넣어주어야 함
    public  Running() {}

    // 매개변수를 갖는 생성자
    public Running(String name) {
        this.name = name;
    }

    // 오버로딩
    public void running() {
        System.out.println("기본 달리기");
    }
    public void running(int distance) {
        System.out.println(distance + "km 달리기");
    }
    public void running(double distance) {
        System.out.println(distance + "km 달리기");
    }
    public void running(int speed, int distance) {
        System.out.println(distance + "km를 " + speed + "속도로 달리기");
    }
}

