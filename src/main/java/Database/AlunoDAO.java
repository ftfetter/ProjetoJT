package Database;

import Beans.*;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet;
    private Aluno aluno;

    public boolean adicionarAluno(Aluno aluno){
        boolean retorno = false;
        String insert = "INSERT INTO aluno(nome, cpf, telefone, email, treinador_id) VALUES(?, ?, ?, ?, ?);";

        try {
            connection = DatabaseConnect.getConnection();

            //preparando o INSERT
            preparedStatement = connection.prepareStatement(insert);
            //setando as variáveis
            preparedStatement.setString(1,aluno.getNome());
            preparedStatement.setString(2,aluno.getCPF());
            preparedStatement.setString(3,aluno.getTelefone());
            preparedStatement.setString(4,aluno.getEmail());
            preparedStatement.setInt(5,aluno.getTreinadorId());

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

    public boolean alterarAluno(Aluno aluno){
        boolean retorno = false;
        String update = "UPDATE aluno SET nome = ?,telefone = ?,email = ?,peso = ?,altura = ?,gordura = ? WHERE id = ?;";

        try {
            connection = DatabaseConnect.getConnection();

            //preparando o UPDATE
            preparedStatement = connection.prepareStatement(update);
            //setando as variáveis
            preparedStatement.setString(1,aluno.getNome());
            preparedStatement.setString(2,aluno.getTelefone());
            preparedStatement.setString(3,aluno.getEmail());
            preparedStatement.setFloat(4,aluno.getPeso());
            preparedStatement.setFloat(5,aluno.getAltura());
            preparedStatement.setFloat(6,aluno.getGordura());
            preparedStatement.setFloat(7,aluno.getId());

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

    public int buscarIdAluno(Aluno aluno){
        int id = 0;
        String select = "SELECT id FROM aluno WHERE cpf LIKE ?;";

        try {
            connection = DatabaseConnect.getConnection();

            //preparando o SELECT
            preparedStatement = connection.prepareStatement(select);
            //setando as variáveis
            preparedStatement.setString(1,aluno.getCPF());

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                id = resultSet.getInt(1);
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
        return id;
    }

    public boolean excluirAluno(int alunoId){
        Boolean retorno = false;
        String delete = "DELETE FROM aluno WHERE id = ?;";

        try{
            connection = DatabaseConnect.getConnection();
            //preparando o DELETE
            preparedStatement = connection.prepareStatement(delete);

            preparedStatement.setInt(1,alunoId);
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

    public List<Aluno> listarAluno(String nomeAluno, int treinadorId){
        List<Aluno> alunos = new ArrayList<>();
        String select = "SELECT * FROM aluno WHERE nome LIKE ? AND treinador_id=? ORDER BY nome ASC;";

        try {
            connection = DatabaseConnect.getConnection();
            //preparando o SELECT
            preparedStatement = connection.prepareStatement(select);
            //setando as variáveis
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
        return alunos;
    }

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
        return aluno = new Aluno();
    }

    public boolean validarAluno(String cpf){
        boolean alunoValido = false;
        String select = "SELECT * FROM aluno WHERE cpf LIKE ?;";

        try {
            connection = DatabaseConnect.getConnection();
            //preparando o SELECT
            preparedStatement = connection.prepareStatement(select);
            preparedStatement.setString(1,cpf);

            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){
                alunoValido = true;
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
        return alunoValido;
    }
}
