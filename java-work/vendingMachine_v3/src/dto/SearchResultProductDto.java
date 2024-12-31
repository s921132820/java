package dto;

public class SearchResultProductDto {
    private int productNo;
    private String productName;
    private int price;
    private int stock;
    private int sellYn;

    public SearchResultProductDto(int productNo, String productName, int price, int stock, int sellYn) {
        this.productNo = productNo;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.sellYn = sellYn;
    }

    public String toString() {
        String str = String.format("%s \t %s \t %s \t %s\t %s", productNo, productName, price, stock, sellYn);
        return str;
    }
}
