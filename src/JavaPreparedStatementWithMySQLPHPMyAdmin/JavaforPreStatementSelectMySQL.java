package JavaPreparedStatementWithMySQLPHPMyAdmin;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JavaforPreStatementSelectMySQL {
    public static void main(String[]agrs){
        Connection connect = null;
        PreparedStatement pre = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = (Connection)
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDataBase"
                    + "?user=root&password=");
            String sql = "SELECT * FROM  customer " + "WHERE Email = ? ORDER BY ID ASC";
            pre = connect.prepareStatement(sql);
            pre.setString(1, "Boston@fastwork.co");
            ResultSet rec = pre.executeQuery();
            while((rec!=null) && (rec.next())){
                System.out.print(rec.getString("ID"));
                System.out.print(" - ");
                System.out.print(rec.getString("Name"));
                System.out.print(" - ");
                System.out.print(rec.getString("Email"));
                System.out.print(" - ");
                System.out.print(rec.getString("Salary"));
                System.out.print("  ");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
