package oopCh03;

public class Ch03Main {
    public static void main(String[] args) {
        광전사 u1 = new 광전사();
        궁수 u2 = new 궁수();
        전사 u3 = new 전사();

        u1.기본공격();
        u1.기본공격(u2);
        u1.기본공격(u3);

        u2.기본공격(u1);
        u2.기본공격(u3);

        u3.기본공격(u1);
        u3.기본공격(u2);

    }
}
