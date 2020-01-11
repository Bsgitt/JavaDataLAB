package JavaPreparedStatementWithMySQLPHPMyAdmin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JavaPreparedStatementDeleteMySQL {
    public static void main(String[]agrs){
        Connection connect = null;
        PreparedStatement pre = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = (com.mysql.jdbc.Connection)
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDataBase"
                            + "?user=root&password=");
            String sql = "DELETE FROM customer"+
                    " WHERE ID = ? ";
            pre = connect.prepareStatement(sql);
            pre.setString(1,"111");
            pre.execute();
            System.out.print("Delete ID Successfully");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
