package dto;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProductDto {
    private int productNo;
    private String productName;
    private int price;
    private int stock;
    private int sellYn;

    public String toString() {
        String str = String.format("%d \t %s \t %d \t %d", productNo, productName, price, stock);
        return str;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String product_name) {
        this.productName = product_name;
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

    public int getSellYn() {
        return sellYn;
    }

    public void setSellYn(int sellYn) {
        this.sellYn = sellYn;
    }
}
