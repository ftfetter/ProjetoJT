package Database;

import Beans.*;

import java.sql.*;

public class UsuarioDAO {

    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet;

    public Usuario autenticarLogin(Usuario usuario) {

        String select = "SELECT * FROM usuario WHERE usuario = ? AND senha = ?;";

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
            if(preparedStatement != null)
                try {
                    preparedStatement.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
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

    public boolean adicionarUsuario(Aluno aluno){

        boolean retorno = false;
        String insert = "INSERT INTO usuario(usuario, senha, tipo, aluno_id) VALUES(?, ?, 2, ?);";

        try {
            connection = DatabaseConnect.getConnection();

            //preparando o INSERT
            preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setString(1,aluno.getLogin());
            preparedStatement.setString(2,aluno.getSenha());
            preparedStatement.setInt(3,aluno.getId());

            retorno = preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            retorno = false;

        } finally {
            if(preparedStatement != null)
                try {
                    preparedStatement.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return retorno;
    }

}
