package yunjinhz.print.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.lang.reflect.Method;

public class DbUtil {
    public static final String Url = "jdbc:mysql://192.168.0.160:3306/barcodeprinternet?serverTimezone=Asia/Shanghai&generateSimpleParameterMetadata=true&useUnicode=true&characterEncoding=utf8";
    public static final String User = "root";
    public static final String Password = "yjhz@1234";
    private static Connection conn = null;

    static {
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
//            Class.forName("com.mysql.jdbc.Driver");
            //2. 获得数据库连接
            conn = DriverManager.getConnection(Url, User, Password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }
}
