package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.mysql.cj.telemetry.TelemetryAttribute.DB_USER;

public class DBConn {
    private static Connection dbConn;
    public static Connection getConnection() {
        if (dbConn == null) {
            String dbDriver = "com.mysql.cj.jdbc.Driver";
            String dbUrl = "jdbc:mysql://localhost:3306/vending_machine";
            String dbUser = "root";
            String dbPassword = "1111";

            try {
                Class.forName(dbDriver);
                dbConn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
//                System.out.println("DB연결성공");
            } catch (ClassNotFoundException e) {
                System.out.println("DB연결실패");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("DB연결실패");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("DB연결실패");
                e.printStackTrace();
            }
        }
        return dbConn;
    }
    public static void close(){
        if (dbConn != null) {
            try {
                if(!dbConn.isClosed()) {
                    dbConn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}