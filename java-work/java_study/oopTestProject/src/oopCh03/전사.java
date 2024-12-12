package oopCh03;

public class 전사 {
    String name = "전사";
    public void 기본공격() {
        System.out.println("검으로 공격");
    }
    public void 기본공격(광전사 e) {
        System.out.println("검으로 " + e.name + "공격하기");
    }
    public void 기본공격(궁수 e) {
        System.out.println("검으로 " + e.name + "공격하기");
    }
}
