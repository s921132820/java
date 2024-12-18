package mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnectionTest {
    String dbDriver = "com.mysql.cj.jdbc.Driver";
    String dbUrl = "jdbc:mysql://localhost:3306/idolgroup";
    String dbUser = "root";
    String dbPassword = "1111";

    Connection dbConn = null;

    public void dbConnection() {
        Connection connection = null;
        try {
            Class.forName(dbDriver); // jdbc > Driver 파일이 있는지 확인
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("DB연결성공");
        } catch(Exception e) {
            System.out.println("DB연결실패");
            e.printStackTrace();
        }
    }
}
