import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class ConnectDataSource {

    public static void main(String[] args) {

     /*   // Create datasource.
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("scott"); //sa
        ds.setPassword("tiger309"); //yourpassword
        ds.setServerName("140.115.158.222"); //localhost
        ds.setPortNumber(1433);
        ds.setDatabaseName("DemoLab");  //mydb */

        // Create datasource.
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa"); //sa
        ds.setPassword("passw0rd"); //yourpassword
        ds.setServerName("localhost"); //localhost
        ds.setPortNumber(1433);
        ds.setDatabaseName("DemoLab");  //mydb
        
        // method 1
        /* 
        try (Connection con = ds.getConnection(); Statement stmt = con.createStatement();){
        	     	        	
        	String SQL = "SELECT ENAME FROM EMP";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("ENAME"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        */
        
        
        //method 2
        
        try {
	        
        	Connection con = ds.getConnection(); 
        	Statement stmt = con.createStatement();
        	String SQL = "SELECT ENAME FROM EMP";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("ENAME"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
         
        
    }
}