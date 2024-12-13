import dto.TelBookDto;
import view.ViewList;

import java.util.Scanner;

public class TelBookMain {
    public static void main(String[] args) {
        System.out.println(TelBookDto.class);
        ViewList view = new ViewList();
        Scanner sc = new Scanner(System.in);

        view.printLine();
        view.printTitle();
        view.printLine();

        System.out.println("1.입력 2.수정 3.삭제 4.전체출력 5.아이디검색 6.종료");
        int menunumber = sc.nextInt();
        switch (menunumber) {
            case 1:
                System.out.println("입력");
                view.listInsert();
                break;
            case 2:
                System.out.println("수정");
                break;
            case 3:
                System.out.println("삭제");
                break;
            case 4:
                System.out.println("전체출력");
                break;
            case 5:
                System.out.println("아이디검색");
                break;
            case 6:
                System.out.println("종료");
                return;
        }
    }


}
