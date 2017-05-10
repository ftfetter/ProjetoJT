package Database;

import Beans.*;

import java.sql.*;

public class UsuarioDAO {

    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet;

    public boolean adicionarUsuario(Aluno aluno){

        boolean retorno = false;
        String insert = "INSERT INTO usuario(usuario, senha, tipo, usuario_id) VALUES(?, ?, 2, ?);";

        try {
            connection = DatabaseConnect.getConnection();
            //preparando o INSERT
            preparedStatement = connection.prepareStatement(insert);
            //setando as variáveis
            preparedStatement.setString(1,aluno.getLogin());
            preparedStatement.setString(2,aluno.getSenha());
            preparedStatement.setInt(3,aluno.getId());

            if(preparedStatement.executeUpdate()>0)
                retorno = true;
        } catch (SQLException e) {
            e.printStackTrace();
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

    public boolean adicionarUsuario(Treinador treinador){

        boolean retorno = false;
        String insert = "INSERT INTO usuario(usuario, senha, tipo, usuario_id) VALUES(?, ?, 1, ?);";

        try {
            connection = DatabaseConnect.getConnection();
            //preparando o INSERT
            preparedStatement = connection.prepareStatement(insert);
            //setando as variáveis
            preparedStatement.setString(1,treinador.getLogin());
            preparedStatement.setString(2,treinador.getSenha());
            preparedStatement.setInt(3,treinador.getId());

            if(preparedStatement.executeUpdate()>0)
                retorno = true;
        } catch (SQLException e) {
            e.printStackTrace();
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
                usuario.setId(resultSet.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

    public boolean excluirUsuario(Aluno aluno){
        Boolean retorno = false;
        String delete = "DELETE FROM usuario WHERE usuario_id = ?;";

        try{
            connection = DatabaseConnect.getConnection();
            //preparando o DELETE
            preparedStatement = connection.prepareStatement(delete);
            //setando a variável
            preparedStatement.setInt(1,aluno.getId());

            if(preparedStatement.executeUpdate()>0)
                retorno = true;
        } catch (SQLException e) {
            e.printStackTrace();
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
