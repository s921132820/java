package oopCh06;

// 앞에 abstrack가 생략되어 있는것
// abstrack void speak();
// abstrack boolean 육식인가();

public interface AnimalInterface {
    String getName();

    void speak(); // 동물의 울음소리 출력 기능

    boolean 육식인가(); // 육식동물인지, 초식동물인지 확인, 육식이면 true 초식이면 false

    String move();
}
