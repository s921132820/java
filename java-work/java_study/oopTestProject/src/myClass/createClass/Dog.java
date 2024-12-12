package myClass.createClass;

public class Dog {
    public Dog() { }
        // 클래스를 만들면 생성자가 생성되는데 () 괄호 안에 아무것도 없어도 마치 있는 것처럼 자바의 가상머신이 생성해줌
        // 기본생성자
    // 결코 바뀌지 않는 값은 final로 선언함
    public final String type = "말티즈";
    public String name = "토토";
    public int age = 5;
    public String color = "하얀색";
}
