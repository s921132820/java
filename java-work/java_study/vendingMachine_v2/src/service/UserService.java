package service;

import repository.ListRepository;
import vo.Product;

import java.util.List;

public class UserService {
    ListRepository repository = new ListRepository();

    public boolean serveItem(int userMoney, String itemName) {
        // 찾는 제품이 있는지 확인
        Product findItem = repository.findByName(itemName);

        // 제품이 있고, 잔돈이 충분한지 확인
        // 충분하면 재고 -1 true 리턴
        if (findItem != null && findItem.getPrice() <= userMoney) {
            // 제품을 구매
            findItem.setStock(findItem.getStock() - 1);
            // 수정처리
            repository.update(repository.findByIndex(itemName), findItem);
            return true;
        } else if (findItem == null) {
            // 제품이 없을 때
            System.out.println("찾는 제품이 없습니다.");
            return false;
        } else if (findItem.getPrice() > userMoney) {
            // 그렇지 않으면 false 리턴
            // 잔돈이 부족할 때
            System.out.println("잔액이 부족합니다.");
        }
    }
}
