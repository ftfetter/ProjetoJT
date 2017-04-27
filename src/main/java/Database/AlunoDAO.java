package Database;

import Users.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet;


    public static Usuario setAluno(Usuario usuario) {

        String select = "SELECT * FROM aluno WHERE id = ?;";
        Usuario aluno;

        try {
            connection = DatabaseConnect.getConnection();

            //preparando o SELECT
            preparedStatement = connection.prepareStatement(select);
            //setando as variáveis do SELECT
            preparedStatement.setInt(1, usuario.getId());

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                aluno = new Aluno(usuario.getId(),
                        resultSet.getString(2),     // Nome do Aluno
                        resultSet.getString(3),     // CPF do Aluno
                        resultSet.getInt(6),        // ID do Treinador do Aluno
                        usuario.getTipoLogin(),
                        usuario.getLogin(),
                        usuario.getSenha());
                aluno.setTelefone(resultSet.getString(4));
                aluno.setEmail(resultSet.getString(5));
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

        return aluno = new Aluno();
    }

    public static List<Usuario> buscarAluno(String nomeAluno){

        List<Usuario> alunos = new ArrayList<>();
        String select = "SELECT * FROM aluno WHERE nome LIKE '%"+nomeAluno+"%';";
        Usuario aluno;

        try {
            connection = DatabaseConnect.getConnection();

            //preparando o SELECT
            preparedStatement = connection.prepareStatement(select);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                aluno = new Aluno(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getFloat(6),
                        resultSet.getFloat(7),
                        resultSet.getFloat(8)
                        );
                aluno.setTelefone(resultSet.getString(4));
                aluno.setEmail(resultSet.getString(5));

                alunos.add(aluno);
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

        return alunos;
    }
}
