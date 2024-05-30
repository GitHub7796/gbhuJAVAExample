package main.gbhu.dateLearn;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JavaSqlXXX {
    @Test
    public void test() {
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        System.out.println(date);
        //2024-05-24
        java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        //2024-05-24 18:01:50.62
        timestamp.setNanos(123456);
        System.out.println(timestamp);
        //2024-05-24 18:01:50.000123456
        System.out.println(timestamp.getNanos());
        //123456
    }

    @Test
    public void testDB() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接
        String url = "jdbc:mysql://127.0.0.1:3306/xdclass?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "123456";
        //获取连接对象，并连接数据库
        Connection connection = DriverManager.getConnection(url,username,password);
        //获取语句句对象
        Statement statement = connection.createStatement();





        ResultSet resultSet = statement.executeQuery("select * from video");

        while (resultSet.next()){
            System.out.println("视频标题:"+resultSet.getString("title"));
        }






        //关闭连接
        statement.close();
    }

}
