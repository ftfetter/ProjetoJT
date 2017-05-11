package Database;

import Beans.*;
import java.sql.*;

public class TreinadorDAO {

    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet;
    private Aluno atualAluno;

    public Aluno getAtualAluno(){
        return this.atualAluno;
    }

    public void setAtualAluno(Aluno atualAluno){
        this.atualAluno = atualAluno;
    }

    public Treinador setTreinador(Usuario usuario) {

        String select = "SELECT * FROM treinador WHERE id = ?;";
        Treinador treinador = null;

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
            treinador = new Treinador();
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

        return treinador;
    }

    public Treinador buscaTreinador(int idTreinador){
        String select = "SELECT * FROM treinador WHERE id = ?;";
        Treinador treinador = null;

        try {
            connection = DatabaseConnect.getConnection();

            //preparando o SELECT
            preparedStatement = connection.prepareStatement(select);
            //setando as variáveis do SELECT
            preparedStatement.setInt(1, idTreinador);

            resultSet = preparedStatement.executeQuery();

            if(resultSet.first())
                treinador = new Treinador(idTreinador,
                        resultSet.getString(2));
        } catch (SQLException e) {
            treinador = new Treinador();
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

        return treinador;
    }

}
