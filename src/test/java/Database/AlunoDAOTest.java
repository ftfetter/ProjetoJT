package Database;

import Beans.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlunoDAOTest {

    AlunoDAO alunoDAO = mock(AlunoDAO.class);
    Aluno aluno;

    @Test
    public void setandoAluno(){
        Usuario usuario = new Usuario();
        aluno = new Aluno(1,"aluno","123.123.123-12");

        when(alunoDAO.setAluno(usuario)).thenReturn(aluno);

        alunoDAO.setAluno(usuario);

        Assert.assertNotEquals(0,aluno.getId());
    }

    @Test
    public void adicionandoAluno(){
        aluno = new Aluno();
        when(alunoDAO.adicionarAluno(aluno)).thenReturn(true);

        Assert.assertTrue(alunoDAO.adicionarAluno(aluno));
    }

    @Test
    public void encontrandoAluno(){
        List<Aluno> alunos = new ArrayList<>();
        aluno = new Aluno();
        alunos.add(aluno);

        when(alunoDAO.listarAluno("nomeAluno",1)).thenReturn(alunos);

        alunoDAO.listarAluno("nomeAluno",1);

        Assert.assertNotEquals(0,alunos.size());
    }

}
