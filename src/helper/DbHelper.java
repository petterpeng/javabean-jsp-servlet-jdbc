package helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbHelper {
    private static String url = "jdbc:mysql://localhost:3306/my-db";  //数据库地址
    private static String userName = "root";  //数据库用户名
    private static String passWord = "123456";  //数据库密码
    private static Connection conn = null;
    
    private DbHelper(){
        
    }
    
    public static Connection getConnection(){
        if(null == conn){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, userName, passWord);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    
    public static void main(String[] args) {  //测试数据库是否连通
        System.out.println(getConnection());
    }
}