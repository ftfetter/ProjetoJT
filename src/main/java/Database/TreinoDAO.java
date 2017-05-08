package Database;

import Beans.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreinoDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Treino treino;

    public List<Treino> listarTreino(int alunoId){
        List<Treino> treinos = new ArrayList<>();
        String select = "SELECT * FROM treino,exercicio WHERE treino.aluno_id=? AND treino.exercicio_id = exercicio.id;";

        try {
            connection = DatabaseConnect.getConnection();

            //preparando o SELECT
            preparedStatement = connection.prepareStatement(select);

            preparedStatement.setString(1,"%"+alunoId+"%");

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                treino = new Treino(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getString(6)
                );

                treinos.add(treino);
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

        return treinos;
    }
}
