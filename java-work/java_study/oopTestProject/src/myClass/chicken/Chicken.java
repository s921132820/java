package myClass.chicken;

public class Chicken {
    public String brand;
    public String menu;
    public int price;
    private String model;

//    // Setter : private한 값에 할당
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    // Getter : private 값을 요청하는 것
//    public String getModel() {
//        return this.model;
//    }

    public void modelPrint() {
        System.out.println(this.brand + "의 모델은 " + this.model + "입니다.");
    }

    // 기본 생성자 만들기
    public Chicken() {};

    // brand, menu, price를 갖는 생성자 만들기
    public Chicken(String brand, String menu, int price) {
        this.brand = brand; // this는 public String brand;를 의미함
        this.menu = menu;
        this.price = price;
    }

}







//// 기본 생성자 만들기
//public Chicken() {};
//
//// brand, menu, price를 갖는 생성자 만들기
//public Chicken(String brand, String menu, int price) {
//    this.brand = brand; // this는 public String brand;를 의미함
//    this.menu = menu;
//    this.price = price;
//}