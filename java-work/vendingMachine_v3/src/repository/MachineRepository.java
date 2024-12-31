package repository;

import db.DBConn;
import dto.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import static db.DBConn.getConnection;

public class MachineRepository {

    public static SalesDto salesDto = new SalesDto();
    public static MemberDto memberDto = new MemberDto();

    int result = 0; // 쿼리실행결과를 담을 변수(성공:양수, 실패:0)
    Connection dbConn = DBConn.getConnection();
    PreparedStatement psmt = null;
    String sql;

    public int insertMember(MemberDto memberDto) {
//        PreparedStatement psmt = null;
//        int result = 0;
        try {
//            dbConn = getConnection(); // 새로운 연결을 얻기
            sql = "INSERT INTO member (member_id, password, member_name, phone, balance, created_dt) " +
                    "VALUES(?, ?, ?, ?, ?, ?)";
            psmt = dbConn.prepareStatement(sql);

            // 전달할 인자값을 psmt에 추가
            psmt.setString(1, memberDto.getMemberId());
            psmt.setString(2, memberDto.getPassword());
            psmt.setString(3, memberDto.getName());
            psmt.setString(4, memberDto.getPhone());
            psmt.setInt(5, memberDto.getBalance());
            psmt.setTimestamp(6, Timestamp.valueOf(memberDto.getCreatedDt()));

            // DB에 저장 요청
            result = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // 예외를 로깅하거나 적절한 메시지 처리
        } finally {
            // 자원 해제
            try {
                if (psmt != null) psmt.close();
//                if (dbConn != null) dbConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public int insertProduct(ProductDto productDto) {
//        PreparedStatement psmt = null;
        int result = 0;
        try {
            String sql = "INSERT INTO product (product_name, price, stock, sell_yn) " +
                    "VALUES(?, ?, ?, ?)";

            psmt = dbConn.prepareStatement(sql);

            // 전달할 인자값을 psmt에 추가
            psmt.setString(1, productDto.getProductName());
            psmt.setInt(2, productDto.getPrice());
            psmt.setInt(3, productDto.getStock());
            psmt.setInt(4, productDto.getSellYn());

            // DB에 저장 요청
            result = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // 예외를 로깅하거나 적절한 메시지 처리
        } finally {
            // 자원 해제
            try {
                if (psmt != null) psmt.close();
//                if (dbConn != null) dbConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public int insertSales(SalesDto salesDto) {
//        int result = 0;
        try {
            sql = "INSERT INTO sales (member_id, product_no, sales_price, sales_dt) ";
            sql = sql + "VALUES(?, ?, ?, ?)";
            psmt = dbConn.prepareStatement(sql);

            // 전달할 인자값을 psmt에 추가
            psmt.setString(1, salesDto.getMember_id());
            psmt.setInt(2, salesDto.getProduct_no());
            psmt.setInt(3, salesDto.getSales_price());
            psmt.setTimestamp(4, Timestamp.valueOf(salesDto.getSales_dt() != null ? salesDto.getSales_dt() : LocalDateTime.now()));

            // DB에 저장 요청
            result = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // 예외를 로깅하거나 적절한 메시지 처리
        } finally {
            // 자원 해제
            try {
                if (psmt != null) psmt.close();
//                if (dbConn != null) dbConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public int updateMember(MemberDto memberDto) {
        sql = "UPDATE member SET ";
        sql = sql + "member_name = ?, ";
        sql = sql + "password = ?, ";
        sql = sql + "phone = ?, ";
        sql = sql + "balance = ? ";
        sql = sql + "WHERE member_id LIKE CONCAT('%', ? , '%')";

        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, memberDto.getName());
            psmt.setString(2, memberDto.getPassword());
            psmt.setString(3, memberDto.getPhone());
            psmt.setInt(4, memberDto.getBalance());
            psmt.setString(5, memberDto.getMemberId());
            int result = psmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateProduct(ProductDto productDto) {
        sql = "UPDATE product SET ";
        sql = sql + "product_name = ?, ";
        sql = sql + "price = ?, ";
        sql = sql + "stock = ?, ";
        sql = sql + "sell_yn = ? ";
        sql = sql + "WHERE product_no = ?";

        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, productDto.getProductName());
            psmt.setInt(2,productDto.getPrice());
            psmt.setInt(3, productDto.getStock());
            psmt.setInt(4, productDto.getSellYn());
            psmt.setInt(5, productDto.getProductNo());
            int result = psmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteMember(String member_id) {
        sql = "DELETE FROM member WHERE ";
        sql = sql + "member_id LIKE CONCAT('%', ? , '%')";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, member_id);
            int result = psmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteProduct(int productId) {
        sql = "DELETE FROM product WHERE product_no =?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setInt(1, productId);
            int deleteResult = psmt.executeUpdate();
            return deleteResult;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<MemberDto> getAllList() {
        return List.of();
    }

    public List<ProductDto> getProductList() {
        List<ProductDto> dtoList = new ArrayList<>();
        ResultSet rs = null;
        try {
            sql = "SELECT * FROM product ORDER BY product_no ASC";
            psmt = dbConn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) {
                ProductDto dto = new ProductDto();
                dto.setProductNo(rs.getInt("product_no"));
                dto.setProductName(rs.getString("product_name"));
                dto.setPrice(rs.getInt("price"));
                dto.setStock(rs.getInt("stock"));
                dto.setSellYn(rs.getInt("sell_yn"));

                dtoList.add(dto);
            }
            rs.close();
            psmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoList;
    }

    public MemberDto findById(String id) {
        return null;
    }

    public MemberDto findByMemberId(String id) {
        sql = "SELECT * FROM member WHERE ";
        sql = sql + "member_id LIKE CONCAT('%', ? , '%') ";

        try (PreparedStatement psmt = dbConn.prepareStatement(sql)) {
            psmt.setString(1, id);  // ?에 값을 넣기
            ResultSet rs = psmt.executeQuery();  // 쿼리 실행

            if (rs.next()) {
                // 결과가 있으면 MemberDto 객체 생성하여 반환
                MemberDto memberDto = new MemberDto();
                memberDto.setMemberNo(rs.getInt("member_no"));
                memberDto.setMemberId(rs.getString("member_id"));
                memberDto.setPassword(rs.getString("password"));
                memberDto.setName(rs.getString("member_name"));
                memberDto.setPhone(rs.getString("phone"));
                memberDto.setBalance(rs.getInt("balance"));
                return memberDto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ProductDto findByProductId(int productId) {
        sql = "SELECT * FROM product WHERE product_no = ?";

        try (PreparedStatement psmt = dbConn.prepareStatement(sql)) {
            psmt.setInt(1, productId);  // ?에 값을 넣기
            ResultSet rs = psmt.executeQuery();  // 쿼리 실행

            if (rs.next()) {
                // 결과가 있으면 ProductDto 객체 생성하여 반환
                ProductDto productDto = new ProductDto();
                productDto.setProductNo(rs.getInt("product_no"));
                productDto.setProductName(rs.getString("product_name"));
                productDto.setPrice(rs.getInt("price"));
                productDto.setStock(rs.getInt("stock"));
                productDto.setSellYn(rs.getInt("sell_yn"));
                return productDto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SearchResultProductDto> findByNameProduct(String name) {
        List<SearchResultProductDto> dtoList =  new ArrayList<>();
        sql = "SELECT product_no, product_name, price, stock, sell_yn FROM product WHERE ";
        sql = sql + "product_name LIKE CONCAT('%', ? , '%') ";
        sql = sql + "ORDER BY product_name ASC";
        ResultSet rs = null;
        int searchNo = 0;
        String searchName = "";
        int searchPrice = 0;
        int searchStock = 0;
        int searchSellYn = 0;
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, name);
            rs = psmt.executeQuery();
            // 읽어온 ResultSet을 하나씩 읽어서 리스트에 담기
            while (rs.next()) {
                searchNo = rs.getInt("product_no");
                searchName = rs.getString("product_name");
                searchPrice = rs.getInt("price");
                searchStock = rs.getInt("stock");
                searchSellYn = rs.getInt("sell_yn");
                // 생성자를 이용해서 DTO 생성 후
                // 리스트에 추가
                dtoList.add(new SearchResultProductDto(
                        searchNo,
                        searchName,
                        searchPrice,
                        searchStock,
                        searchSellYn
                ));
            }
            rs.close();
            psmt.close();
            return dtoList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<SearchResultMemberDto> findByMemberCheck(String memberId) {
        List<SearchResultMemberDto> dtoList =  new ArrayList<>();
        sql = "SELECT member_id, member_name, phone, balance, created_dt FROM member WHERE ";
        sql = sql + "member_id LIKE CONCAT('%', ? , '%') ";
        ResultSet rs = null;
        String searchId = "";
        String searchName = "";
        String searchPhone = "";
        int searchBalance = 0;
        LocalDateTime searchCreatedDt = null;
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, memberId);
            rs = psmt.executeQuery();
            // 읽어온 ResultSet을 하나씩 읽어서 리스트에 담기
            while (rs.next()) {
                searchId = rs.getString("member_id");
                searchName = rs.getString("member_name");
                searchPhone = rs.getString("phone");
                searchBalance = rs.getInt("balance");
                searchCreatedDt = rs.getTimestamp("created_dt").toLocalDateTime();
                // 생성자를 이용해서 DTO 생성 후
                // 리스트에 추가
                dtoList.add(new SearchResultMemberDto(
                        searchId,
                        searchName,
                        searchPhone,
                        searchBalance,
                        searchCreatedDt
                ));
            }
            rs.close();
            psmt.close();
            return dtoList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public boolean login(String memberId, String password) {
        sql = "SELECT * FROM member WHERE member_id = ? AND password = ?";
        boolean isAuthenticated = false;

        try (PreparedStatement psmt = dbConn.prepareStatement(sql)) {

            psmt.setString(1, memberId);
            psmt.setString(2, password);

            ResultSet rs = psmt.executeQuery();

            // 결과가 있으면 로그인 성공
            if (rs.next()) {
                salesDto.setMember_id(rs.getString("member_id"));
                memberDto.setMemberId(rs.getString("member_id"));
                memberDto.setBalance(rs.getInt("balance"));
//                salesDto.setSales_price(rs.getInt("balance"));
                isAuthenticated = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAuthenticated;
    }

    //판매현황
    public List<SalesDto> getProductSales() {
        List<SalesDto> salesList = new ArrayList<>();
        String sql = "SELECT p.product_name, COUNT(s.product_no) AS total_sales_count, " +
                "SUM(s.sales_price) AS total_sales_amount " +
                "FROM sales s " +
                "JOIN product p ON s.product_no = p.product_no " +
                "GROUP BY p.product_name " +
                "ORDER BY total_sales_amount DESC";

        try (
//                Connection dbConn = getConnection();
             PreparedStatement psmt = dbConn.prepareStatement(sql);
             ResultSet rs = psmt.executeQuery()) {

            while (rs.next()) {
                String productName = rs.getString("product_name");
                int totalSalesCount = rs.getInt("total_sales_count");
                int totalSalesAmount = rs.getInt("total_sales_amount");

                // 제품별 판매 현황을 나타내는 SalesDto 객체 생성
                SalesDto dto = new SalesDto(totalSalesCount, totalSalesAmount, productName);
                salesList.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesList;
    }

    // 회원별 판매 현황을 반환하는 메서드
    public List<SalesDto> getMemberSales() {
        List<SalesDto> salesList = new ArrayList<>();
        String sql = "SELECT m.member_id, m.member_name, COUNT(s.product_no) AS total_sales_count, " +
                "SUM(s.sales_price) AS total_sales_amount " +
                "FROM sales s " +
                "JOIN member m ON s.member_id = m.member_id " +
                "GROUP BY m.member_id " +
                "ORDER BY total_sales_amount DESC";

        try (
//                Connection dbConn = getConnection();
             PreparedStatement psmt = dbConn.prepareStatement(sql);
             ResultSet rs = psmt.executeQuery()) {

            while (rs.next()) {
                String memberId = rs.getString("member_id");
                int totalSalesCount = rs.getInt("total_sales_count");
                int totalSalesAmount = rs.getInt("total_sales_amount");

                // 회원별 판매 현황을 나타내는 SalesDto 객체 생성
                SalesDto dto = new SalesDto(memberId, totalSalesCount, totalSalesAmount);
                salesList.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salesList;
    }
}