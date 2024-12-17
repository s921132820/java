package lambda;

public class LambdaExpression {
    public static void main(String[] args) {
        Calc add = (x, y) -> {
            return x + y;
        };
        System.out.println(add.calculator(3, 4));


        // 값은 두개이기 때문에 괄호로 묶음
        Calc minus = (x, y) -> x-y;
        System.out.println(minus.calculator(7, 3));
    }
}

// ->
// 내가 처리할 데이터를 다음 단계로 넘기는 역할
// 인자가 하나 이상일 때에는 괄호로 묶어야 한다. (int x, int y), 하나면 괄호 생략 가능