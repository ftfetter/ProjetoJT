package Database; /**
 * Created by ilegra0320 on 18/04/2017.
 */
import java.sql.*;

public class DatabaseConnect {

    public static Connection getConnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingcheckdb","root","admin");
            System.out.println("Conexão com o Banco de Dados efetuada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Falha na conexão com Banco de Dados.");
        }
        return con;
    }
}
