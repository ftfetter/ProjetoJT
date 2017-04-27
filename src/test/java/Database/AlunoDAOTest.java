package Database;

import Users.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAOTest {

    AlunoDAO alunoDAO = new AlunoDAO();
    Usuario aluno;

    @Test
    public void setandoAluno(){
        Usuario usuario = new Usuario();
        usuario.setId(1);

        aluno = alunoDAO.setAluno(usuario);

        Assert.assertNotNull(aluno);
    }

    @Test
    public void encontrandoAluno(){
        List<Usuario> alunos;
        alunos = alunoDAO.buscarAluno("jocemir");

        Assert.assertNotEquals(alunos.size(),0);
    }

    @Test
    public void naoEncontrandoAluno(){
        List<Usuario> alunos;
        alunos = alunoDAO.buscarAluno("k");

        Assert.assertEquals(alunos.size(),0);
    }

}
