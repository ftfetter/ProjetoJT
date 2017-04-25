package Database;

import Users.*;
import java.sql.*;

public class TreinadorDAO {

    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet;


    public static Usuario setTreinador(Usuario usuario) {

        String select = "SELECT * FROM treinador WHERE id = ?;";
        Usuario treinador = null;

        try {
            connection = DatabaseConnect.getConnection();

            //preparando o SELECT
            preparedStatement = connection.prepareStatement(select);
            //setando as variáveis do SELECT
            preparedStatement.setInt(1, usuario.getId());

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                treinador = new Treinador(usuario.getId(),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        usuario.getTipoLogin(),
                        usuario.getLogin(),
                        usuario.getSenha());
                treinador.setTelefone(resultSet.getString(4));
                treinador.setEmail(resultSet.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return treinador;
    }

    public static Usuario buscaTreinador(int idTreinador){
        Usuario treinador = null;


        return treinador;
    }
}
