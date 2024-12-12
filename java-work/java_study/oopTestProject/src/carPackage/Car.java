package carPackage;

// (안바뀌는거) brand : 현대, 기아, 삼성
// (안바뀌는거) power : 2000cc
// (안바뀌는거) name : 그랜저, k5, SM6
// color : 흰색, 검정색, 회색
// navigation : true, false (있을 수도 있고 없을 수도 있음)
// speed = 0 -- 게터만 있음

// brand, power, name은 출고 시 결정, 생성자로 만들어야함
// navigation, color는 출고 후에 결정

// speedUp()
// speedDown()
// speedUp과 speedDown은 매 실행시 마다 5km 증감
// speed === 0 되면 멈춤
// speed가 0보다 커지면 출발한다.
// 현재 속도는 몇 km 입니다.
// speed가 30km 를 넘으면 과속입니다. -- 학교앞
// 현재 30km를 유지합니다.

// 출력 : 나의 애마 000은 00 브랜드 0000cc 입니다.
//색상은 00이고 네비에션은 있습니다(없습니다).
public class Car {
    private String brand;
    private int power;
    private String name;
    private String color;
    private boolean navigation;
    private int speed;

    public String carInfo() {
        // 출력
        String info = "나의 애마" + this.name + "은 " + this.brand + "브랜드 " + this.power + "입니다.";
        return info;
    }

    public Car(String brand, int power, String name) {
        this.brand = brand;
        this.power = power;
        this.name = name;
    }

    public void speedUp() {
        this.speed += 5;
    }

    public void speedDown() {
        this.speed -= 5;
    }

    //getter
    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return this.power;
    }

    // getter - color
    public String getColor() {
        return this.color;
    }

    // setter -color
    public void setColor(String color) {
        this.color = color;
    }

    // speed - getter
    public int getSpeed() {
        return this.speed;
    }

    // Navigation - getter
    public boolean getNavigation() {
        return this.navigation;
    }

    // Navigation - setter
    public void setNavigation(boolean navigation) {
        this.navigation = navigation;
    }
}


