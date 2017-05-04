package Database;

import Beans.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet;
    private Aluno aluno;

    public Aluno setAluno(Usuario usuario) {

        String select = "SELECT * FROM aluno WHERE id = ?;";

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

    public boolean adicionarAluno(Aluno aluno){

        boolean retorno = false;

        if(!buscarAluno(aluno.getNome(),aluno.getTreinadorId()).isEmpty()){
            retorno = false;
        }

        String insert = "INSERT INTO aluno(nome, cpf, telefone, email, treinador_id) VALUES(?, ?, ?, ?, ?);";

        try {
            connection = DatabaseConnect.getConnection();

            //preparando o INSERT
            preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setString(1,aluno.getNome());
            preparedStatement.setString(2,aluno.getCPF());
            preparedStatement.setString(3,aluno.getTelefone());
            preparedStatement.setString(4,aluno.getEmail());
            preparedStatement.setInt(5,aluno.getTreinadorId());

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

    public List<Aluno> buscarAluno(String nomeAluno, int treinadorId){

        List<Aluno> alunos = new ArrayList<>();
        String select = "SELECT * FROM aluno WHERE nome LIKE ? AND treinador_id=? ORDER BY nome ASC;";

        try {
            connection = DatabaseConnect.getConnection();

            //preparando o SELECT
            preparedStatement = connection.prepareStatement(select);

            preparedStatement.setString(1,"%"+nomeAluno+"%");
            preparedStatement.setInt(2,treinadorId);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                aluno = new Aluno(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                        );
                aluno.setTelefone(resultSet.getString(4));
                aluno.setEmail(resultSet.getString(5));
                aluno.setPeso(resultSet.getFloat(6));
                aluno.setAltura(resultSet.getFloat(7));
                aluno.setGordura(resultSet.getFloat(8));

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
