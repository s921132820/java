import db.DBConn;
import view.AdminView;
import view.MemberView;

import java.util.Scanner;

public class VendingMachine_main {
    public static void main(String[] args) {
        MemberView memberView = new MemberView();
        AdminView adminView = new AdminView();
        Scanner sc = new Scanner(System.in);

    //- 처음 접속 시 회원가입 또는 로그인 두 가지 중 선택합니다.
        int firstSelect = 0;

        while (true){
            System.out.println("우리자판기는 회원제로 운영되는 자판기 입니다.");
            System.out.println("1. 회원가입 2. 로그인 3.종료 4.관리자모드");
            firstSelect = sc.nextInt();
            switch (firstSelect) {
                case 1 :
                    memberView.insertView();
                    break;
                case 2:
                    memberView.loginView();
                    memberView.selectProduct();
                    break;
                case 3:
                    DBConn.close();
                    return;
                case 4:
                    System.out.println("관리자모드입니다.");
                    System.out.println("1. 자판기관리  2.회원관리 3.판매관리");
                    int adminSelectMenu = sc.nextInt();
                    switch (adminSelectMenu) {
                        case 1:
                            adminView.machinManager();
                            break;
                        case 2:
                            adminView.memberManager();
                            break;
                        case 3:
                            adminView.salesManager();
                            break;
                        default:
                            System.out.println("잘못 입력하셨습니다.");
                            break;
                    }
                    break;

                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}
