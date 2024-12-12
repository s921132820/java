package oopCh03;

public class 궁수 {
    String name = "궁수";
    public void 기본공격() {
        System.out.println("활로 공격");
    }
    public void 기본공격(전사 e) {
        System.out.println("활로 " + e.name + "공격하기");
    }
    public void 기본공격(광전사 e) {
        System.out.println("활로 " + e.name + "공격하기");
    }
}
