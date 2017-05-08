package Database;

import Beans.Exercicio;

import java.sql.*;

public class ExercicioDAO {

    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet;

    public boolean adicionarExercicio(Exercicio exercicio){

        boolean retorno = false;
        String insert = "INSERT INTO exercicio(nome, descricao) VALUES(?, ?);";

        try {
            connection = DatabaseConnect.getConnection();

            //preparando o INSERT
            preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setString(1,exercicio.getNome());
            preparedStatement.setString(2,exercicio.getDescricao());

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

    public boolean validarExercicio(String nome){
        boolean exercicioValido = false;
        String select = "SELECT * FROM exercicio WHERE nome LIKE ?;";

        try {
            connection = DatabaseConnect.getConnection();
            preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1,nome);

            resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()){
                exercicioValido = true;
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

        return exercicioValido;
    }
}
