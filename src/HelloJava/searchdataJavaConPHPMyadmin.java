package HelloJava;

import java.sql.*;
import java.util.Scanner;

public class searchdataJavaConPHPMyadmin {
    public static void main(String[]agrs){
        Connection connect = null;
        Statement s = null;
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDataBase" + "?user=root&password=");
            s = connect.createStatement();
           System.out.println("Search Name:");
            s = connect.createStatement();
            String CusName = sc.next();
            String sql = "SELECT * FROM  customer WHERE Name LIKE '%" + CusName + "%' ";


            ResultSet rec = s.executeQuery(sql);
            while((rec!=null) && (rec.next()))
            {
                System.out.print(rec.getString("ID"));
                System.out.print(" - ");
                System.out.print(rec.getString("Name"));
                System.out.print(" - ");
                System.out.print(rec.getString("Email"));
                System.out.print(" - ");
                System.out.print(rec.getString("Salary"));
                System.out.print("");
            }

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {
            System.out.print("NotFoundName");
            e.printStackTrace();
        }
        //Close Database
        try {
            if (connect != null){
                connect.close();
            }
        }catch ( SQLException e){
            e.printStackTrace();
        }
    }
}
