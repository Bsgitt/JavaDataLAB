package HelloJava;

import java.sql.*;
import java.util.Scanner;

public class JavaUpdateDataPHPMyAdmin {
    public  static  void main(String[]args){
        Connection connect = null;
        Statement s = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDataBase" + "?user=root&password=");
            s = connect.createStatement();

            String sql = "UPDATE customer " + "SET Salary ='500000'"+
                    " WHERE ID = '101' ";

            System.out.println("Record Update Successfully");
            s.execute(sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
