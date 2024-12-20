package view;

import dto.TelBookDTO;
import exception.InputValidation;
import exception.MyException;
import service.PhoneBookService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class TelBookView implements ViewInterface{
    Scanner sc = new Scanner(System.in);
    PhoneBookService bookService = new PhoneBookService();
    // 입력확인용 인스턴스 생성
    InputValidation validation = new InputValidation();
    
    @Override
    public void insertView() {
        System.out.println("[ViewInterface]-insertView");
        System.out.println("=== 전화번호 등록 ===");

        boolean check = true;

        // 빈 연락처 클래스 -> 채워서 서비스로 전달 -> 서비스는 레파지토리로 보내서 저장
        TelBookDTO  dto = new TelBookDTO();

        // 이름 입력 처리
        while (check) {
            try {
                System.out.println("이름 : ");
                String name = sc.next();
                check = validation.nameCheck(name);
                dto.setName(name);
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        // 나이 확인
        check = true;
        while (check) {
            try {
                System.out.println("나이 : ");
                int age = sc.nextInt();
                check = validation.ageCheck(age);
                dto.setAge(age);
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        // 주소 입력 받기
        System.out.println("주소 : ");
        String address = sc.next();
        dto.setAddress(address);

        // 전화번호 입력 처리
        check = true;
        while (check) {
            try {
                System.out.println("전화번호 : ");
                String phone = sc.next();
                check = validation.phoneCheck(phone);
                dto.setPhone(phone);
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        //  신규 입력이니까 생성일 저장
        dto.setCreatedAt(LocalDateTime.now());
        System.out.println(dto);

        // 서비스로 DTO 전달
        int result = bookService.inserService(dto);
        if (result >0) {
            System.out.println("자료가 저장되었습니다.");
        } else {
            System.out.println("실패했습니다. 관리자에게 문의하세요");
        }
    }

    @Override
    public void updateView() {
        System.out.println("[ViewInterface]-updateView");
        System.out.println("업데이트할 전화번호부의 아이디를 입력하세요");
        Long updateID = sc.nextLong();
        if (bookService.updateService(updateID)>0) {

        }

    }

    @Override
    public void deleteView() {
        System.out.println("[ViewInterface]-deleteView");
        System.out.println("삭제할 전화번호부의 아이디를 입력하세요");
        Long deleteId = sc.nextLong();
        if (bookService.deleteService(deleteId)>0) {
            System.out.println("ID : " + deleteId + "의 데이터가 삭제되었습니다.");
        } else {
            System.out.println("삭제에 실패했습니다. 관리자에게 문의하세요");
        }
    }

    @Override
    public void searchAllView() {
        System.out.println("[ViewInterface]-searchAllView");
        List<TelBookDTO> dtoList = bookService.getAllListService();
        // 출력
        linePrint();
        printTitle();
        linePrint();
        for (TelBookDTO dto : dtoList) {
            System.out.println(dto);
        }
        linePrint();
    }

    public void printTitle() {
        System.out.println("ID \t 이름 \t 나이 \t 주소 \t \t 전화번호 \t \t \t \t \t 입력 \t \t 수정");
    }
    public void linePrint() {
        System.out.println("=============================================");
    }

    @Override
    public void searchNameView() {
        System.out.println("[ViewInterface]-searchNameView");

    }

    @Override
    public void searchPhoneView() {
        System.out.println("[ViewInterface]-searchPhoneView");

    }
}
