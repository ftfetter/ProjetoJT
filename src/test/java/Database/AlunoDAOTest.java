package Database;

import Beans.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class AlunoDAOTest {

    AlunoDAO alunoDAO = new AlunoDAO();
    Aluno aluno;

    @Test
    public void setandoAluno(){
        Usuario usuario = new Usuario();
        usuario.setId(1);

        aluno = alunoDAO.setAluno(usuario);

        Assert.assertNotNull(aluno);
    }

    /*
    @Test
    public void adicionandoAluno(){
        aluno = new Aluno();

        Assert.assertTrue(alunoDAO.adicionarAluno(aluno));
    }*/

    @Test
    public void encontrandoAluno(){
        List<Aluno> alunos;
        alunos = alunoDAO.listarAluno("j",1);

        Assert.assertNotEquals(alunos.size(),0);
    }

    @Test
    public void naoEncontrandoAluno(){
        List<Aluno> alunos;
        alunos = alunoDAO.listarAluno("k",1);

        Assert.assertEquals(alunos.size(),0);
    }

}
