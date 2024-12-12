package carPackage;

public class CarMain {
    public static void main(String[] args) {
        Car myCar = new Car("현대", 2000, "그랜저");
        myCar.setColor("핑크색");
        myCar.setNavigation(true);
        String carInfo = myCar.carInfo();
        System.out.println(carInfo);
        System.out.printf("색상은 " + myCar.getColor() + "이고 ");
        if (myCar.getNavigation()) {
            System.out.println("네이게이션은 있습니다.");
        } else {
            System.out.println("네비게이션은 없습니다.");
        }
        System.out.println();

        // speedUp test
        System.out.println("출발합니다.");
        for (int i=1; i <=10; i++) {
            if (myCar.getSpeed() > 30) {
                System.out.println("학교 앞 과속입니다.");
                System.out.println("현재속도는 " + myCar.getSpeed() + "km 입니다.");
                break;
            } else {
                myCar.speedUp();
                System.out.println("현재속도는 " + myCar.getSpeed() + "km 입니다.");
            }
        }
        // speedDown test
        for (int i=1; i <=10; i++) {
            if (myCar.getSpeed() == 0) {
                System.out.println("멈췄습니다.");
                break;
            } else {
                myCar.speedDown();
                System.out.println("현재속도는 " + myCar.getSpeed() + "km 입니다.");
            }
        }
    }
}
