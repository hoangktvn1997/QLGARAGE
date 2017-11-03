/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuConnect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Administrator
 */
public class Connect {
    public static Connection getConnect() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public Connection getConnection(){
        Connection conn =null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=OTOG2;user=sa;password=123");
            if(conn != null){
                System.out.println("Connect Success!");
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        return conn;
    }
}
