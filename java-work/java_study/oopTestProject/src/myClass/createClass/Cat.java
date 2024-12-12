package myClass.createClass;

public class Cat {
    public String catName;
    public String catColor;

    public Cat(String name, String color) {
        catName = name;
        catColor = color;
    }
    // 강제로 디폴트 생성자 만들어줘야함, 안그러면 오류남
    public Cat() {

    }
}
