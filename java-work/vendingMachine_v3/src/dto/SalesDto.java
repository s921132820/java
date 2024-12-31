package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SalesDto {
    private int sales_no;
    private String member_id;
    private int product_no;
    private int sales_price;
    private LocalDateTime sales_dt;
//    private String type;

    private String productName;
    private int totalSalesCount;
    private int totalSalesAmount;

    public String getProductName() {
        return productName;
    }

    public int getTotalSalesCount() {
        return totalSalesCount;
    }

    public int getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public SalesDto(int sales_no, String member_id, int product_no, int sales_price, LocalDateTime sales_dt) {
        this.sales_no = sales_no;
        this.member_id = member_id;
        this.product_no = product_no;
        this.sales_price = sales_price;
        this.sales_dt = (sales_dt != null) ? sales_dt : LocalDateTime.now();
    }

    public SalesDto() {}

    public SalesDto( int totalSalesCount, int totalSalesAmount, String productName) {
        this.productName = productName;
        this.totalSalesCount = totalSalesCount;
        this.totalSalesAmount = totalSalesAmount;
//        this.type = "product";
    }

    public SalesDto(String member_id, int totalSalesCount, int totalSalesAmount) {
        this.member_id = member_id;
        this.totalSalesCount = totalSalesCount;
        this.totalSalesAmount = totalSalesAmount;
//        this.type = "member";
    }

    public String toString() {
        String sales_date = "";
        if (sales_dt != null){
            sales_date = sales_dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
        }
        String str = String.format("%d \t %s \t %d \t %d \t %s", sales_no, member_id, product_no, sales_price, sales_date);
        return str;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setTotalSalesCount(int totalSalesCount) {
        this.totalSalesCount = totalSalesCount;
    }

    public void setTotalSalesAmount(int totalSalesAmount) {
        this.totalSalesAmount = totalSalesAmount;
    }

    public int getSales_no() {
        return sales_no;
    }

    public void setSales_no(int sales_no) {
        this.sales_no = sales_no;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public int getProduct_no() {
        return product_no;
    }

    public void setProduct_no(int product_no) {
        this.product_no = product_no;
    }

    public int getSales_price() {
        return sales_price;
    }

    public void setSales_price(int sales_price) {
        this.sales_price = sales_price;
    }

    public LocalDateTime getSales_dt() {
        return sales_dt;
    }

    public void setSales_dt(LocalDateTime sales_dt) {
        this.sales_dt = sales_dt;
    }
}
