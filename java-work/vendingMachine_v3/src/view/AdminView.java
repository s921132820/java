package view;

import dto.*;
import exception.MyException;
import repository.MachineRepository;
import service.AdminService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import static view.MemberView.validation;

public class AdminView {
    Scanner sc = new Scanner(System.in);
    AdminService adminService = new AdminService();

    public void salesManager() {
        while(true){
            System.out.println("판매관리입니다.");
            System.out.println("1.제품별판매현황 2.회원별판매현황 3.처음으로 돌아가기");
            int selectMenu = sc.nextInt();
            MachineRepository repository = new MachineRepository();
            switch (selectMenu) {
                case 1:
                    List<SalesDto> productSales = repository.getProductSales();

                    if (productSales.isEmpty()) {
                        System.out.println("판매된 제품이 없습니다.");
                    } else {
                        System.out.println("제품별 판매현황");
                        System.out.println("==============================");
                        System.out.println("제품명 | 판매 개수 | 판매 총액");
                        System.out.println("==============================");
                        for (SalesDto dto : productSales) {
                            if (dto != null) {
                                System.out.printf("%s \t %d \t %d\n", dto.getProductName(), dto.getTotalSalesCount(), dto.getTotalSalesAmount());
                            }
                        }
                        System.out.println("==============================");
                    }
                    break;
                case 2:
                    System.out.println("회원별 판매현황");
                    List<SalesDto> memberSales = repository.getMemberSales();

                    if (memberSales.isEmpty()) {
                        System.out.println("판매된 회원이 없습니다.");
                    } else {
                        System.out.println("회원별 판매현황");
                        System.out.println("==============================");
                        System.out.println("회원명 | 구매 횟수 | 판매 총액");
                        System.out.println("==============================");
                        for (SalesDto dto : memberSales) {
                            if (dto != null) {
                                System.out.printf("%s \t %d \t %d\n", dto.getMember_id(), dto.getTotalSalesCount(), dto.getTotalSalesAmount());
                            }
                        }
                        System.out.println("==============================");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    public void memberManager() {
        System.out.println("회원 관리입니다.");
        while (true) {
            System.out.println("1.회원등록 2.회원수정 3.회원삭제 4.회원조회 5.처음으로 돌아가기");
            int selectMenu = sc.nextInt();
            switch (selectMenu) {
                case 1:
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
                    int result = adminService.insertMemberService(memberDto); // 인스턴스 메서드 호출
                    if (result > 0) {
                        System.out.println("회원정보가 저장되었습니다.");
                    } else {
                        System.out.println("실패했습니다. 관리자에게 문의하세요");
                    }
                    break;
                case 2:
                    System.out.println("=== 회원 정보 수정 ===");
                    System.out.println("수정할 회원의 아이디를 입력하세요.");
                    String updateId = sc.next();
                    MemberDto originalMemberDto = adminService.findByMemberIdService(updateId);
                    MemberDto updateMemberDto = new MemberDto();

                    //원본이름출력
                    System.out.println("수정 전 이름 : " + originalMemberDto.getName());
                    check = true;
                    // 수정 대상 ID를 updateDTO.id에 저장
                    updateMemberDto.setMemberId(originalMemberDto.getMemberId());
                    // 수정할 이름 입력 받고 Validation 체크
                    while (check) {
                        try {
                            System.out.println("수정 할 이름 : ");
                            String name = sc.next();
                            check = validation.nameCheck(name);
                            updateMemberDto.setName(name);
                        } catch (MyException e) {
                            System.out.println(e.getMessage());
                        }
                    }


                    // 비밀번호 수정
                    System.out.println("수정 할 비밀번호 : ");
                    String password = sc.next();
                    updateMemberDto.setPassword(password);

                    //핸드폰수정
                    System.out.println("수정 전 번호 : " + originalMemberDto.getPhone());
                    System.out.println("수정 할 번호 : ");
                    String phone = sc.next();
                    updateMemberDto.setPhone(phone);

                    //잔액수정
                    System.out.println("수정 전 잔액 : " + originalMemberDto.getBalance());
                    System.out.println("수정 할 잔액 : ");
                    int balance = sc.nextInt();
                    updateMemberDto.setBalance(balance);

                    int updateResult = adminService.updateMemberService(updateMemberDto);
                    // 성공유무 처리
                    if (updateResult > 0) {
                        System.out.println("정상적으로 수정되었습니다.");
                    } else {
                        System.out.println("수정 실패. 관리자에게 문의하세요.");
                    }
                    break;
                case 3:
                    System.out.println("=== 회원 삭제 ===");
                    System.out.println("삭제할 회원의 아이디를 입력하세요.");
                    String deleteId = sc.next();
                    if (adminService.deleteMemberService(deleteId) > 0) {
                        System.out.println("ID : " + deleteId + "의 데이터가 삭제되었습니다.");
                    } else {
                        System.out.println("삭제에 실패했습니다.");
                    }
                    break;
                case 4:
                    System.out.println("=== 회원 조회 ===");
                    System.out.println("회원 아이디로 검색하세요.");
                    String keyword =  sc.next();
                    List<SearchResultMemberDto> findResult = adminService.findByMemberCheckService(keyword);
//                    String memberId, String name, String phone, int balance, LocalDateTime createdDt
                    // 내용 출력
                    if (findResult.isEmpty()) {
                        System.out.println("해당 아이디의 회원이 존재하지 않습니다.");
                    } else {
                        System.out.println("========================================");
                        System.out.println("Id            이름     핸드폰번호          잔액          가입일");
                        System.out.println("========================================");
                        findResult.stream().forEach(x -> System.out.println(x));
                        System.out.println("========================================");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
                    break;
            }
        }
    }

    public void machinManager() {
        System.out.println("자판기 관리입니다.");
        while (true) {
            System.out.println("1.제품등록 2.제품수정 3.제품삭제 4.제품조회 5.처음으로 돌아가기");
            int selectMenu = sc.nextInt();
            switch (selectMenu) {
                case 1:
                    System.out.println("=== 제품 등록 ===");

                    ProductDto productDto = new ProductDto();
                    // 제품 이름 등록
                    System.out.println("등록할 제품의 이름을 입력하세요.");
                    String productName = sc.next();
                    productDto.setProductName(productName);

                    // 가격 등록
                    System.out.println("등록할 제품의 가격을 입력하세요.");
                    int productPrice = sc.nextInt();
                    productDto.setPrice(productPrice);

                    //재고 등록
                    System.out.println("등록할 제품의 재고를 입력하세요.");
                    int productStock = sc.nextInt();
                    productDto.setStock(productStock);

                    int result = adminService.insertProductService(productDto); // 인스턴스 메서드 호출
                    if (result > 0) {
                        System.out.println("제품정보가 저장되었습니다.");
                    } else {
                        System.out.println("실패했습니다.");
                    }
                    break;
                case 2:
                    System.out.println("=== 제품 수정 ===");
                    System.out.println("수정할 제품의 아이디를 입력하세요.");
                    int updateId = sc.nextInt();
                    ProductDto originalProductDto = adminService.findByProductIdService(updateId);
                    ProductDto updateProductDto = new ProductDto();

                    //원본이름출력
                    System.out.println("수정 전 이름 : " + originalProductDto.getProductName());
                    boolean check = true;
                    // 수정 대상 ID를 updateDTO.id에 저장
                    updateProductDto.setProductNo(originalProductDto.getProductNo());
                    // 수정할 이름 입력 받고 Validation 체크
                    while (check) {
                        try {
                            System.out.println("수정 할 이름 : ");
                            String name = sc.next();
                            check = validation.nameCheck(name);
                            updateProductDto.setProductName(name);
                        } catch (MyException e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    // 원래가격 출력
                    System.out.println("수정 전 가격 : " + originalProductDto.getPrice());
                    System.out.println("수정 할 금액 : ");
                    int price = sc.nextInt();
                    updateProductDto.setPrice(price);

                    // 원래재고 출력
                    System.out.println("수정 전 재고 : " + originalProductDto.getStock());
                    System.out.println("수정 할 재고 : ");
                    int stock = sc.nextInt();
                    updateProductDto.setStock(stock);

                    int updateResult = adminService.updateProductService(updateProductDto);
                    // 성공유무 처리
                    if (updateResult > 0) {
                        System.out.println("정상적으로 수정되었습니다.");
                    } else {
                        System.out.println("수정 실패. 관리자에게 문의하세요.");
                    }
                    break;

                case 3:
                    System.out.println("=== 제품 삭제 ===");
                    System.out.println("삭제할 제품의 아이디를 입력하세요.");
                    int deleteId = sc.nextInt();
                    if (adminService.deleteProductService(deleteId) > 0) {
                        System.out.println("ID : " + deleteId + "의 데이터가 삭제되었습니다.");
                    } else {
                        System.out.println("삭제에 실패했습니다. 관리자에게 문의하세요");
                    }
                    break;
                case 4:
                    System.out.println("=== 제품 조회 ===");
                    System.out.println("제품 이름으로 검색하세요.");
                    String keyword =  sc.next();
                    List<SearchResultProductDto> findResult = adminService.findByProductNameService(keyword);

                // 내용 출력
                if (findResult.isEmpty()) {
                    System.out.println("검색 결과가 없습니다.");
                } else {
                    System.out.println("================================");
                    System.out.println("no  제품명      금액     수량  판매여부");
                    System.out.println("================================");
                    findResult.stream().forEach(x -> System.out.println(x));
                    System.out.println("================================");
                }
                    break;
                case 5 :
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
                    break;
            }
        }
    }
}
