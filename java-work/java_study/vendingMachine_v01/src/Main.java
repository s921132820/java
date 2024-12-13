import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String[] product = new String[4]; // 제품명
    static int[] price = new int[4]; // 가격
    static int[] stock = new int[4]; // 재고수량
    static int money = 0;
    static int menuNumber = 0;
    // 전체 수익금액을 관리하는 변수
    static int totalMoney = 0;

    public static void main(String[] args) {
        initialize();
        user();
    }

    private static void user() {
        while (true){
            showTitle();
            addMoney();
            menuChoice();
        }
    }

    private static void menuChoice() {
        int selectChoice = 0;

        System.out.println("메뉴입력 : ");
        selectChoice = sc.nextInt();

        if (money >= price[selectChoice -1]) {
            switch (selectChoice) {
                case 1:
                    if (stock[0] > 0){
                        stock[0] --;
                        System.out.println(product[0] + "가 나왔다");
                        money -= price[0]; // money = money - price[0]
                        System.out.println("잔액 :" + (money));
                        nextAction();
                    } else {
                        System.out.println("재고부족");
                    }
                    break;
                case 2:
                    if (stock[1] > 0) {
                        stock[1]--;
                        System.out.println(product[1] + "가 나왔다");
                        money -= price[1];
                        System.out.println("잔액 :" + (money));
                        nextAction();
                    } else {
                        System.out.println("재고부족");
                    }
                    break;
                case 3:
                    if (stock[2] > 0) {
                        stock[2]--;
                        System.out.println(product[2] + "가 나왔다");
                        money -= price[2];
                        System.out.println("잔액 :" + (money));
                        nextAction();
                    } else {
                        System.out.println("재고부족");
                    }
                    break;
                case 4:
                    if (stock[3] > 0) {
                        stock[3]--;
                        System.out.println(product[3] + "가 나왔다");
                        money -= price[3];
                        System.out.println("잔액 :" + (money));
                        nextAction();
                    } else {
                        System.out.println("재고부족");
                    }
                    break;
                case 5:
                    if (stock[4] > 0) {
                        stock[4]--;
                        System.out.println(product[4] + "가 나왔다");
                        money -= price[4];
                        System.out.println("잔액 :" + (money));
                        nextAction();
                    } else {
                        System.out.println("재고부족");
                    }
                    break;
            }
        } else {
            System.out.println("돈이 부족합니다");
            addMoney();
        }
    }

    private static void addMoney() {
        System.out.printf("돈을 넣어주세요: ");
        int additionalMoney = sc.nextInt(); // 추가로 입력받은 금액
        money += additionalMoney; // 누적
        System.out.println("현재 잔액: " + money + "W");
        if (money == 1004) {
            adminMenu();
            return;
        }
        if (money > 0) {
            showTitle();
            menuChoice();
        }

    }

    private static void adminMenu() {
        int adminMenuChoice = 0;
        money = 0;
        System.out.println("============================");
        System.out.println("관리자 페이지입니다.");
        System.out.println("1.메뉴 변경 2.가격변경 3.재고추가 4.메뉴추가 5.수익확인(종료는 -1) 6.처음으로 돌아가기");
        System.out.println("번호를 입력하세요.");
        adminMenuChoice = sc.nextInt();
        int emptyIndex = -1;
        switch (adminMenuChoice) {
            case 1:
                adminMenuChange();
                break;
            case 2 :
                adminPriceChange();
                break;
            case 3 :
                adminStockAdd();
                break;
            case 4 :
                for (int i = 0; i < product.length; i++) {
                    if (product[i] == null) {
                        emptyIndex = i; // 빈 자리를 찾음
                        System.out.println("더 이상 메뉴가 들어갈 자리가 없습니다");
                        adminMenu();
                    } else {
                        adminMenuAdd();}
                }
            case 5 :
                profitCheck();
                break;
            case 6 :
                user();
                break;
        }
    }
    private static void profitCheck() {
        int profitTotal = 0;
        money = profitTotal;
        System.out.println("현재까지의 수입은 " + profitTotal + "원 입니다.");

        adminMenuAdd();
    }

    private static void adminMenuAdd() {
        sc.nextLine();
        String newMenu = "";

        System.out.println("추가하실 메뉴의 이름을 입력하세요");
        newMenu = sc.nextLine();
        product[3] = newMenu;

        System.out.println(product[3] + "의 가격을 입력하세요");
        price[3] = sc.nextInt();

        System.out.println(price[3] + "의 재고는 몇개입니까?");
        stock[3] = sc.nextInt();

        System.out.println("메뉴 등록이 완료되었습니다!");
        adminMenu();
    }

    private static void adminStockAdd() {
        System.out.println("재고를 추가하실 메뉴의 번호를 입력하세요");
        for (int i = 0; i < product.length; i++) {
            if (product[i] != null) {
                System.out.printf("%d. %s(%dW) - %d개%n", i + 1, product[i], price[i], stock[i]);
            }
        }
        menuNumber = sc.nextInt();
        sc.nextLine();

        System.out.println(product[menuNumber - 1] + "을(를) 몇 개 추가 하시겠습니까?");
        int newStock = sc.nextInt();
        stock[menuNumber - 1] += newStock;

        System.out.println("재고 추가가 완료되었습니다!");
        adminMenu();
    }

    private static void adminPriceChange() {
        System.out.println("가격을 변경하실 메뉴의 번호를 입력하세요");
        for (int i = 0; i < product.length; i++) {
            if (product[i] != null) {
                System.out.printf("%d. %s(%dW) - %d개%n", i + 1, product[i], price[i], stock[i]);
            }
        }
        menuNumber = sc.nextInt();
        sc.nextLine();

        System.out.println(product[menuNumber - 1] + "의 가격을 얼마로 바꾸시겠습니까?");
        int newPrice = sc.nextInt();
        price[menuNumber - 1] = newPrice;

        System.out.println("가격 변동이 완료되었습니다!");
        adminMenu();
    }

    private static void adminMenuChange() {

        System.out.println("변경하실 번호의 메뉴의 번호를 입력하세요");
        for (int i = 0; i < product.length; i++) {
            if (product[i] != null) {
                System.out.printf("%d. %s(%dW) - %d개%n", i + 1, product[i], price[i], stock[i]);
            }
        }
        menuNumber = sc.nextInt();
        sc.nextLine();

        System.out.println(product[menuNumber - 1] + "을(를) 무엇으로 바꾸시겠습니까?");
        String newProduct = sc.nextLine(); //밀크티
        product[menuNumber - 1] = newProduct;

        System.out.println(newProduct + "의 가격은 얼마입니까?");
        int newPrice = sc.nextInt();
        price[menuNumber - 1] = newPrice;

        System.out.println(newProduct + "의 재고는 몇 개 등록하시겠습니까?");
        int newStock = sc.nextInt();
        stock[menuNumber - 1] = newStock;

        System.out.println("메뉴 등록이 완료되었습니다!");
        adminMenu();
    }


    private static void nextAction() {
        int option = 0;
        System.out.println("다음 옵션을 선택하세요");
        System.out.println("1.계속 구매하기 2.금액추가하기 3.잔돈반환하기");
        System.out.printf("번호를 입력하세요 :" );
        option = sc.nextInt();

        switch (option) {
            case 1:
                showTitle();
                menuChoice();
                break;
            case 2:
                showTitle();
                addMoney();
                break;
            case 3:
                System.out.println("잔액"+ money +"가 반환됩니다");
                money = 0;
                System.out.println("감사합니다! 다음에 또 이용해주세요!");
                showTitle();
                addMoney();
                break;
        }
    }

    private static void showTitle() {
        System.out.println("============================");
        System.out.println("자판기입니다. 번호:상품(가격)-재고");

        for (int i = 0; i < product.length; i++) {
            if (product[i] != null) {
                System.out.printf("%d. %s(%dW) - %d개%n", i + 1, product[i], price[i], stock[i]);
            }
        }
        System.out.println("============================");
    }


    public static void initialize() {

//        String[] product = {"콜라", "사이다", "커피"};
//        int[] price = {500, 700, 1500};
//        int[] stock = {3, 3, 3};

        Object[][] menu = {
                {"콜라", 500, 3},
                {"사이다", 700, 3},
                {"커피", 1500, 3}
        };
        for (int i = 0; i < menu.length; i++) {
            product[i] = (String) menu[i][0];
            price[i] = (int) menu[i][1];
            stock[i] = (int) menu[i][2];
        }
    }
}
