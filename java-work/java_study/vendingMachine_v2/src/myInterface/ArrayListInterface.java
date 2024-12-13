package myInterface;

import vo.Product;
import java.util.ArrayList;
import java.util.List;

public interface ArrayListInterface {
    public boolean insert(Product product);

    public boolean update(int index, Product product);

    boolean delete(int index);

    Product findByName(String name);

    int findByIndex(String name);

    List<Product> findAll();
}


// 삽입 : boolean inser(Product product) -- 성공하면 true
// 수정 : boolean update(int index, Product product)
// 삭제 : boolean delete(int index)
// 한개 찾아오기(제품명) :
// Product findByName(String name);
// 전체 다 찾아오기(전체리스트) :
// List<Product> findAll();