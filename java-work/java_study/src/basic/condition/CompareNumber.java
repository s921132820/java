package basic.condition;

public class CompareNumber {
    public static void main(String[] args) {
        int intA = 7;
        int intB = 8;
        String testString = "";
        String nullString = null;
        int temp;
        String result = "intA = " + intA + ", intB = " + intB;
        System.out.println(result);


        if (intA < intB) {
            temp = intA; // intA의 값을 임시로 저장
            intA = intB;     // intB의 값을 intA로
            intB = temp;     // temp의 값을 intB로
        }
        result = "intA = " + intA + ", intB = " + intB;
        System.out.println(result);
    }
}
