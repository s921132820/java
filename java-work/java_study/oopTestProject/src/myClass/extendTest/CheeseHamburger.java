package myClass.extendTest;

//  기존의 Hamburger 상속
// Hamburger가 Public이여야 가져올 수 있음
public class CheeseHamburger extends Hamburger{
    private String name = "치즈햄버거";
    private String 재료3 = "치즈듬뿍";

    @Override
    public void order() {
//        super.order();
        System.out.println("치즈버거 주문완료");
    }





    public String get재료3() {
        return this.재료3;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
