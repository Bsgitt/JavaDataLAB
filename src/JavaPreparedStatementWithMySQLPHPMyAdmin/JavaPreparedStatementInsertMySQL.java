package JavaPreparedStatementWithMySQLPHPMyAdmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JavaPreparedStatementInsertMySQL {
    public static void main(String[]agrs){
        Connection connect = null;
        PreparedStatement pre = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = (com.mysql.jdbc.Connection)
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDataBase"
                            + "?user=root&password=");
            String sql = "INSERT INTO customer " +
                    "(ID,Name,Email,Salary)"+
                    "VALUES(?,?,?,?)";
            pre = connect.prepareStatement(sql);
            pre.setString(1,"111");
            pre.setString(2,"GreekC");
            pre.setString(3,"Greek@mail.com");
            pre.setString(4,"50000");
            pre.executeUpdate();
            System.out.println("Record Inserted Successfully");



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
