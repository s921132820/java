package exception;

import java.util.regex.Pattern;

public class InputValidation {
    // 이름확인 - 한글만 가능하도록
    public boolean nameCheck(String name) throws MyException {
        boolean check = Pattern.matches("^[ㄱ-ㅎ가-힣]*$",name);
        if(! check) {
            throw new MyException("※이름은 한글로 입력해주세요!");
        }
        return (!check);
    }

    // 아이디확인
    public boolean idCheck(String id) throws MyException {
        if (id == null) {
            throw new MyException("※아이디를 입력해주세요");
        }
        return false;
    }


    // 패스워드 체크
    public boolean passwordCheck(String password) throws MyException {
        boolean check = Pattern.matches("^.{4,}$", password);
        if(! check) {
            throw new MyException("※4자 이상 입력해주세요");
        }
        return (!check);
    }

    public int balanceCheck(int balance) throws MyException {
        // 충전 금액이 1000원 미만일 경우 예외 발생
        if (balance < 1000) {
            throw new MyException("※1000원 이상부터 충전이 가능합니다.");
        }
        return balance;
    }

// 전화번호 타입 확인(휴대전화)
    public boolean phoneCheck(String phone) throws MyException {
        boolean check = Pattern.matches("^010-\\d{4}-\\d{4}$", phone);
        if(! check) {
            throw new MyException("※휴대폰 입력 형식은 [010-xxxx-xxxx] 입니다.");
        }
        return (!check);
    }
}
