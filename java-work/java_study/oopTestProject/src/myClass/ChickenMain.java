package myClass;

import myClass.chicken.Chicken;

public class ChickenMain {
    public static void main(String[] args) {
        Chicken jadam = new Chicken();
//        jadam.setModel("권은비");

        jadam.brand = "자담치킨";
        jadam.menu = "간장순살치킨";
        jadam.price = 19000;
        System.out.println(jadam.brand + " " + jadam.menu + "을 " + jadam.price + "에 주문했습니다.");
//        System.out.println(jadam.brand + " 모델은 " + jadam.getModel());
        jadam.modelPrint();

    Chicken 교촌 = new
            Chicken("교촌", "간장치킨", 21000);
    Chicken bbq = new
            Chicken("BBQ", "황금올리브치킨", 23000);
        System.out.println(bbq.brand + " " + bbq.menu + "을 " + bbq.price + "에 주문했습니다.");



    }


}
