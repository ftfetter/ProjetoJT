package Database;

import Users.*;

import java.sql.*;

public class UsuarioDAO {

    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet;

    public Usuario autenticarLogin(Usuario usuario) {

        String select = "SELECT * FROM login WHERE usuario = ? AND senha = ?;";

        try {
            connection = DatabaseConnect.getConnection();

            //preparando o SELECT
            preparedStatement = connection.prepareStatement(select);
            //setando as variáveis do SELECT
            preparedStatement.setString(1, usuario.getLogin());
            preparedStatement.setString(2, usuario.getSenha());

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                usuario.setTipoLogin(resultSet.getInt(4));

                if(usuario.getTipoLogin() == 1) {
                    usuario.setId(resultSet.getInt(5));

                } else {
                    usuario.setId(resultSet.getInt(6));
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return usuario;
    }

}
