package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;



public class Mysql {

	private static  Connection mConnect;
    static {
        try {
            System.out.println("init---");
            Class.forName("com.mysql.jdbc.Driver");
            mConnect=DriverManager.getConnection("jdbc:mysql://62.234.46.56:3306/game?useUnicode=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true", "root", "root");
            
            
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return mConnect;
        
    }
    public static void  close() {
        try {
            mConnect.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    public static int  exec(String sql) {
    	int id = -1;
        try {
        	PreparedStatement pstmt = null;
        	pstmt = (PreparedStatement) mConnect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if (rs.next()) {
                id = rs.getInt(1);
            }
      
            pstmt.close();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return id;
        
    }
    
    public static String getRes(String sql,String name) {
    	String res = "";
        try {
        	 Statement stmt = null;
        	 stmt = (Statement) mConnect.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             // 展开结果集数据库
             while(rs.next()){
                 // 通过字段检索
            	 res  = rs.getString(name);
                 
             }
             // 完成后关闭
             rs.close();
             stmt.close();
             
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return res;
        
    }
    
    
    
}
