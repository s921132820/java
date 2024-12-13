package service;

import repository.ListRepository;
import vo.Product;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    ListRepository repository = new ListRepository();

    public void insertItem(Product product) {
        repository.insert(product);
    }

    public List<Product> getAllList() {
        List<Product> productList = new ArrayList<>();
        productList = repository.findAll();
        return productList;
    }

    public boolean deleteItem(String itemName) {
        // 1. itemName이 존재하는지 확인
        int index = repository.findByIndex(itemName);

        // 2. 존재하면 삭제 요청 후 true 리턴 그렇지 않으면 false
        if (index != -1) {
            // 삭제요청
            repository.delete(index);
            return true;
        } else {
            // 삭제실패
            return false;
        }
    }

    public boolean updateStock(String itemName, int updateStock) {
        // 1. 수정할 제품명이 존재하는지 확인
        int index = repository.findByIndex(itemName);
        // 2. 존재하면 수정 요청
        if (index != 1) {
            // 수정할 제품 찾기
            Product findProduct = repository.findByName(itemName);
            // 재고 수정하기
            int updateValue = findProduct.getStock() + updateStock;
            findProduct.setStock(updateStock);
            // 수정요청
            repository.update(index, findProduct);
            return true;
        } else {
            // 수정실패
            return false;
        }
    }

    public int existItem(String item) {
        return repository.findByIndex(item);
    }

    public void updateItem(int index, Product newProduct) {
        repository.update(index, newProduct);
    }
}
