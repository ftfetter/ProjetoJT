package Database;

import Beans.Exercicio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExercicioDAO {

    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet;
    private Exercicio exercicio;

    public boolean adicionarExercicio(Exercicio exercicio){

        boolean retorno = false;
        String insert = "INSERT INTO exercicio(nome, descricao) VALUES(?, ?);";

        try {
            connection = DatabaseConnect.getConnection();

            //preparando o INSERT
            preparedStatement = connection.prepareStatement(insert);
            //setando as variáveis
            preparedStatement.setString(1,exercicio.getNome());
            preparedStatement.setString(2,exercicio.getDescricao());

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

    public boolean alterarExercicio(Exercicio exercicio){
        boolean retorno = false;
        String update = "UPDATE exercicio SET nome = ?,descricao = ? WHERE id = ?;";

        try {
            connection = DatabaseConnect.getConnection();

            //preparando o UPDATE
            preparedStatement = connection.prepareStatement(update);
            //setando as variáveis
            preparedStatement.setString(1,exercicio.getNome());
            preparedStatement.setString(2,exercicio.getDescricao());

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

    public int buscarIdExercicio(String exercicio){
        int idExercicio = 0;
        String select = "SELECT id FROM exercicio WHERE nome = ?;";

        try {
            connection = DatabaseConnect.getConnection();
            preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1,exercicio);

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                idExercicio = resultSet.getInt(1);
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

        return idExercicio;
    }

    public boolean excluirExercicio(Exercicio exercicio){
        Boolean retorno = false;
        String delete = "DELETE FROM exercicio WHERE id = ?;";

        try{
            connection = DatabaseConnect.getConnection();
            //preparando o DELETE
            preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setInt(1,exercicio.getId());
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

    public List<Exercicio> listarExercicio(){
        List<Exercicio> exercicios = new ArrayList<>();
        String select = "SELECT * FROM exercicio;";

        try {
            connection = DatabaseConnect.getConnection();
            //preparando o SELECT
            preparedStatement = connection.prepareStatement(select);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                exercicio = new Exercicio(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );
                exercicios.add(exercicio);
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
        return exercicios;
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

        return exercicioValido;
    }
}
