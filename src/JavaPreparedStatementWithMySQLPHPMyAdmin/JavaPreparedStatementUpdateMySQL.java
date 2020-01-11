package JavaPreparedStatementWithMySQLPHPMyAdmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JavaPreparedStatementUpdateMySQL {
    public static void main(String[]agrs){
        Connection connect = null;
        PreparedStatement pre = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = (com.mysql.jdbc.Connection)
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDataBase"
                            + "?user=root&password=");
            String sql ="UPDATE customer " + "SET Salary = ? "+ "WHERE ID =   ? ";
            pre = connect.prepareStatement(sql);
            pre.setString(1,"10000");
            pre.setString(2,"105");
            pre.executeUpdate();
            System.out.println("Record Update Successfully");



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
