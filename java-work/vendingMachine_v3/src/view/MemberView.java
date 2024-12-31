package view;

import dto.MemberDto;
import dto.ProductDto;
import dto.SalesDto;
import exception.InputValidation;
import exception.MyException;
import repository.MachineRepository;
import service.MemberService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class MemberView {
    MemberService memberService = new MemberService();
    SalesDto salesDto = new SalesDto();
    ProductDto productDto = new ProductDto();
    List<ProductDto> dtoList = memberService.getProductListService();

    Scanner sc = new Scanner(System.in);

    // 입력확인용 인스턴스 생성
    static InputValidation validation = new InputValidation();

    // 회원가입
    public void insertView() {
        MemberService memberService = new MemberService(); // MemberService 객체 생성
        System.out.println("=== 회원가입 ===");

        boolean check = true;
        MemberDto memberDto = new MemberDto();

        // 아이디 입력 처리
        while (check) {
            try {
                System.out.println("아이디 : ");
                String memberId = sc.next();
                check = validation.idCheck(memberId);
                memberDto.setMemberId(memberId);
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        // 패스워드 입력 처리
        check = true;
        while (check) {
            try {
                System.out.println("패스워드 : ");
                String password = sc.next();
                check = validation.passwordCheck(password);
                memberDto.setPassword(password);
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        // 이름 입력 처리
        check = true;
        while (check) {
            try {
                System.out.println("이름 : ");
                String name = sc.next();
                check = validation.nameCheck(name);
                memberDto.setName(name);
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        // 전화번호 입력 처리
        check = true;
        while (check) {
            try {
                System.out.println("전화번호 : ");
                String phone = sc.next();
                check = validation.phoneCheck(phone);
                memberDto.setPhone(phone);
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        // 잔고 입력 처리
        check = true;
        while (check) {
            try {
                System.out.println("충전금액 : ");
                String balanceInput = sc.next(); // String으로 입력 받기

                // 입력값이 숫자인지 확인
                int balance = Integer.parseInt(balanceInput);

                // 잔고 유효성 검사
                validation.balanceCheck(balance);

                // 유효성 검사 통과 시 DTO에 값 설정
                memberDto.setBalance(balance);

                // 루프 종료
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("※숫자만 입력 가능합니다.");
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        // 신규 입력이니까 생성일 저장
        memberDto.setCreatedDt(LocalDateTime.now());
        System.out.println(memberDto);

        // 서비스로 DTO 전달
        int result = memberService.insertMemberService(memberDto); // 인스턴스 메서드 호출
        if (result > 0) {
            System.out.println("회원정보가 저장되었습니다.");
        } else {
            System.out.println("실패했습니다. 관리자에게 문의하세요");
        }
    }

    // 로그인
    public void loginView() {
        Scanner sc = new Scanner(System.in);

        String memberId;
        while (true) {
            System.out.println("아이디를 입력하세요:");
            memberId = sc.nextLine();

            System.out.println("비밀번호를 입력하세요:");
            String password = sc.nextLine();

            boolean isSuccess = memberService.loginService(memberId, password);

            if (isSuccess) {
                System.out.println(MachineRepository.salesDto.getMember_id()+ "님 로그인 성공!");
                System.out.println("현재 잔액은" + MachineRepository.memberDto.getBalance() + "입니다.");
                break;
            } else {
                System.out.println("아이디 또는 비밀번호가 잘못되었습니다. 다시 입력하세요");
            }
        }
    }

    // 로그인 후 멤버전용 화면
    public void selectProduct() {
        int selectMenu = 0;
        while (true) {
            System.out.println("================================");
            System.out.println("no 제품명     금액     수량");
            System.out.println("================================");
            for (ProductDto dto : dtoList) {
                if (productDto.getSellYn() == 0) {
                    System.out.println(dto);
                }
            }
            System.out.println("================================");
            System.out.println("1.제품선택 2.잔액충전 3.나가기(로그아웃)");
            selectMenu = sc.nextInt();
            switch (selectMenu) {
                case 1:
                    System.out.println("자판기 제품 번호를 입력하세요.");
                    int updateProNum = sc.nextInt();

                    // 제품 존재 확인
                    ProductDto originalDto = memberService.findByProductIdService(updateProNum);
                    ProductDto updateDto = new ProductDto();

                    if (originalDto == null) {
                        System.out.println("해당 번호의 제품이 존재하지 않습니다.");
                        break;
                    }

                    if (originalDto.getStock() <= 0) {
                        System.out.println("선택하신 제품은 재고가 없습니다.");
                        break;
                    }

                    System.out.println(originalDto.getProductName() + "를 선택하셨습니다.");
                    updateDto.setProductNo(originalDto.getProductNo());
                    updateDto.setProductName(originalDto.getProductName());
                    updateDto.setPrice(originalDto.getPrice());
                    updateDto.setSellYn(originalDto.getSellYn());
                    updateDto.setStock(originalDto.getStock() - 1);
                    int stockResult = memberService.updateProductService(updateDto);

                    if (stockResult > 0) {
                        // 잔액 차감
                        int remainingBalance = MachineRepository.memberDto.getBalance() - originalDto.getPrice();
                        MachineRepository.memberDto.setBalance(remainingBalance);

                        // SalesDto에서 사용자 정보 가져오기
                        String memberId = MachineRepository.memberDto.getMemberId();

                        // 사용자 잔액(MemberDto) 업데이트
                        MemberDto memberDto = memberService.findByMemberIdService(memberId);
                        if (memberDto != null) {
                            memberDto.setBalance(remainingBalance);
                            int balanceResult = memberService.updateMemberService(memberDto);

                            if (balanceResult > 0) {
                                System.out.println("구매가 완료되었습니다.");
                                System.out.println("남은 재고: " + updateDto.getStock());
                                System.out.println("남은 잔액: " + remainingBalance);

                                // SalesDto 객체에 필요한 정보 설정
                                SalesDto salesDto = new SalesDto(
                                        0,  // sales_no는 자동 증가되므로 0으로 설정
                                        memberId,  // 로그인된 사용자 ID
                                        updateProNum,  // 선택된 제품 번호
                                        originalDto.getPrice(),  // 제품 가격
                                        null  // sales_dt는 null로 전달하면 생성자에서 LocalDateTime.now()로 초기화됨
                                );

                                // SalesDto 저장 (DB에 저장하는 메서드를 호출)
                                int salesResult = memberService.insertSalesService(salesDto);
                                if (salesResult > 0) {
                                    System.out.println("구매 내역이 저장되었습니다.");
                                } else {
                                    System.out.println("구매 내역 저장에 실패했습니다.");
                                }

                            } else {
                                System.out.println("잔액 업데이트 중 오류가 발생했습니다.");
                            }
                        } else {
                            System.out.println("사용자 정보를 찾을 수 없습니다.");
                        }
                    } else {
                        System.out.println("구매 처리 중 오류가 발생했습니다.");
                    }
                    break;

                case 2:
                    System.out.println("현재 잔액: " + MachineRepository.memberDto.getBalance());
                    System.out.println("충전할 금액을 선택하세요.");
                    System.out.println("1. 1000원 2. 3000원 3. 5000원 4. 10000원");

                    int selectMoney = sc.nextInt();
                    int addMoney = 0;

                    // 선택한 금액에 따라 충전액 설정
                    switch (selectMoney) {
                        case 1:
                            addMoney = 1000;
                            break;
                        case 2:
                            addMoney = 3000;
                            break;
                        case 3:
                            addMoney = 5000;
                            break;
                        case 4:
                            addMoney = 10000;
                            break;
                        default:
                            System.out.println("올바른 선택이 아닙니다. 다시 시도하세요.");
                            break;
                    }

                    if (addMoney > 0) {
                        // SalesDto 업데이트
                        int originalBalance = MachineRepository.memberDto.getBalance();
                        int updatedBalance = originalBalance + addMoney;
                        MachineRepository.memberDto.setBalance(updatedBalance);

                        // MemberDto 업데이트
                        MemberDto memberDto = memberService.findByMemberIdService(MachineRepository.memberDto.getMemberId());

                        if (memberDto != null) {
                            // MemberDto의 balance 업데이트
                            memberDto.setBalance(MachineRepository.memberDto.getBalance());

                            int memberResult = memberService.updateMemberService(memberDto);

                            if (memberResult > 0) {
                                System.out.println("충전이 완료되었습니다.");
                                System.out.println("새 잔액: " + MachineRepository.memberDto.getBalance());
                            } else {
                                System.out.println("잔액 업데이트 중 오류가 발생했습니다.");
                            }
                        } else {
                            System.out.println("사용자 정보를 찾을 수 없습니다.");
                        }
                    }
                    break;
                case 3:
                    return;
            }
        }
    }
}