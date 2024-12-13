package vo;

// 제품정보를 담고있는 클래스
public class Product {
    private String item; // 제품의 이름(콜라, 사이다...)
    private int price; // 제품 단가
    private int stock; // 제품 재고

    // 오버로딩, 빈깡통 생성자가 없는 아이면 여기에 맵핑
    public Product() {};

    // 생성자가 있으면 여기에 맵핑
    public Product(String item, int price, int stock) {
        this.item = item;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String toString() {
        String result = "제품명 : " + item + "/ 가격 : " + price + "/ 재고 : " + stock ;
        return result;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
