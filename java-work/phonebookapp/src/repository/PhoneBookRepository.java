package repository;

import db.DBConn;
import dto.TelBookDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookRepository  implements RepositoryInterface{

    int result = 0; // 쿼리실행결과를 담을 변수(성공:양수, 실패:0)
    Connection dbConn = DBConn.getConnection();
    PreparedStatement psmt = null;
    String sql;

    @Override
    public int inserData(TelBookDTO dto) {
        System.out.println("[PhoneBookRepository]-insertData");
        // DB에 저장
        try {
            sql = "INSERT INTO phone_book (name, age, address, phone, created_at) ";
            sql = sql + "VALUES(?, ?, ?, ?,?)";
            psmt = dbConn.prepareStatement(sql);
            // 전달할 인자값을 psmt에 추가
            psmt.setString(1, dto.getName()); // 물음표에 하나씩 전달하는 방법
            psmt.setInt(2, dto.getAge());
            psmt.setString(3, dto.getAddress());
            psmt.setString(4, dto.getPhone());
            psmt.setTimestamp(5, Timestamp.valueOf(dto.getCreatedAt()));

            // DB에 저장 요청
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateData(TelBookDTO dto) {
        System.out.println("[PhoneBookRepository]-updateData");
        return 0;
    }

    @Override
    public int deleteDate(long id) {
        System.out.println("[PhoneBookRepository]-deleteDate");
        sql = "DELETE FROM phone_book WHERE id=?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setLong(1, id);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<TelBookDTO> getAllList() {
        System.out.println("[PhoneBookRepository]-getAllList");
        List<TelBookDTO> dtoList = new ArrayList<>();
        ResultSet rs = null;

        try {
            sql = "SELECT * FROM PHONE_BOOK ORDER BY id ASC";
            psmt = dbConn.prepareStatement(sql);
            // 쿼리 실행할 결과 -> ResultSet에 리턴
            rs = psmt.executeQuery();
            // ResultSet의 내용을 하나씩 읽어서 dtoList에 담는다
            while (rs.next()) {
                // Result Set에 있는 레코드를 하나씩 읽어서 담을 DTO
                TelBookDTO dto = new TelBookDTO();
                // 레코드를 하나씩 읽어서 DTO에 담는 작업
                dto.setId(rs.getLong("id"));
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getInt("age"));
                dto.setPhone(rs.getString("phone"));
                dto.setAddress(rs.getString("address"));
                dto.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                if (rs.getTimestamp("updated_at") != null) {
                    dto.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
                }


                // 당은 DTO를 리스트에 담기
                dtoList.add(dto);
            }
            // ResultSet 닫기
            rs.close();
            // PreparedStatement 닫기
            psmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoList;
    }

    @Override
    public TelBookDTO findById(Long id) {
        System.out.println("[PhoneBookRepository]-findById");
        return null;
    }

    @Override
    public List<TelBookDTO> findByName(String name) {
        System.out.println("[PhoneBookRepository]-findByName");
        return List.of();
    }

    @Override
    public List<TelBookDTO> findByPhone(String phone) {
        System.out.println("[PhoneBookRepository]-findByPhone");
        return List.of();
    }
}
