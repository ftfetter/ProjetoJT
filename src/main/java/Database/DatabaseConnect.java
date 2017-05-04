package Database;

import java.sql.*;

public class DatabaseConnect {

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingcheckdb","root","admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
