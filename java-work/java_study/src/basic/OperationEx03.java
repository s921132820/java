package basic;

public class OperationEx03 {
    public static void main(String[] args) {
        // 대입 (뒤에 값을 앞의 변수에 넣어주세요)
        int a = 3;
        System.out.println(1 == 1); // == 비교, 같으면 true, 다르면 false
        System.out.println(1 != 1); // != 같지않다
        System.out.println(2 >= 1); // 크거나 같다

        //논리연산자
        // and : && , or : || ,  not : !
        // 3 < 4 < 5
        System.out.println(3<4 && 4<5);

        String pass = "합격하셨습니다.";
        String fail = "불합격하셨습니다.";
        System.out.println(pass + " / " + fail);
        // 성적을 국어점수(kor) 변수에 담아요 -- 51
        int kor = 51;
        // 영어점수(eng) -- 80
        int eng = 70;
        // 삼항연산자
        int aaa = 3 == 4 ? 0 : 1;
        // 국어 점수가 60점 이상이면 합격, 그렇지 않으면 불합격 출력하기
        // 1. 바로 출력해 보기
        System.out.println(kor >= 60 ? pass : fail);
        // 2. 결과를 다른 곳에 저장하고 결과 출력하기
        String xxx = kor >= 60 ? pass : fail;
        System.out.println(xxx);

        // 조건1 . 두 점수 중 한가지만 60이상이면 합격
        // or : ||
        // 조건1 결과 : 합격
        String scoreResult = (kor >= 60 || eng >= 60) ? pass : fail;
        scoreResult = "조건 1 결과 : " + scoreResult;
        int i = 1;
        i = i + 1;
        i += 1; // i = i + 1; 이거랑 같은 뜻
        i ++; // 1 더하라는 뜻
        ++ i; // 사용안함, 나쁜 습관
        System.out.println("i = " + i);
        System.out.println(scoreResult);

        // 조건2 .  두 점수 모두 60점 넘으면 합격
        // AND &&
        scoreResult = (kor >= 60 && eng >= 60) ? pass : fail;
        scoreResult = "조건 2 결과 : " + scoreResult;
        // 조건2 결과 : 불합격
        System.out.println(scoreResult);


    }
}

