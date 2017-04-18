/**
 * Created by ilegra0320 on 18/04/2017.
 */
import java.sql.*;

public class dbConnect {

    public static Connection getConnection() throws ClassNotFoundException{

        Connection con = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingcheckdb","root","admin");
            System.out.println("Conecção com o Banco de Dados efetuada com sucesso!");
            return con;
        }
        catch(SQLException error){
            error.printStackTrace();
            System.out.println("Falha na conecção com Banco de Dados.");

            return null;
        }
    }
}
