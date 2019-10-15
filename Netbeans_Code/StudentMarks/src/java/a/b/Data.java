/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Lenovo
 */
public class Data {
     Connection con;
    Statement stmt;
    ResultSet rs;
    
    public Data()throws Exception{
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       String connectionUrl = "jdbc:sqlserver://DESKTOP-8LR5S05:1433;databaseName=Student_marks;user=sa;password=@shu#2499";
       con = DriverManager.getConnection(connectionUrl);
    }
    
    //insert,delete and update
    public void executeSql(String sql)throws Exception{
        stmt=con.createStatement();
        stmt.executeUpdate(sql);
    }
    //select
    public ResultSet getData(String sql)throws Exception{
        stmt=con.createStatement();
        rs=stmt.executeQuery(sql);
        return rs;
    }
    
    public void disconnect()throws Exception{
        con.close();
    }
}
