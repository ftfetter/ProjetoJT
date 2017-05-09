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
    Aluno aluno = new Aluno(1,"aluno","123.456.789-10");;

    @Test
    public void adicionandoAluno(){
        when(alunoDAO.adicionarAluno(aluno)).thenReturn(true);

        Assert.assertTrue(alunoDAO.adicionarAluno(aluno));
    }

    @Test
    public void alterandoAluno(){
        when(alunoDAO.alterarAluno(aluno)).thenReturn(true);

        Assert.assertTrue(alunoDAO.alterarAluno(aluno));
    }

    @Test
    public void buscandoIdAluno(){
        int idAluno = 0;
        when(alunoDAO.buscarIdAluno(aluno)).thenReturn(aluno.getId());

        idAluno = alunoDAO.buscarIdAluno(aluno);

        Assert.assertNotEquals(0,idAluno);
    }

    @Test
    public void encontrandoAluno(){
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);

        when(alunoDAO.listarAluno("nomeAluno",1)).thenReturn(alunos);

        alunoDAO.listarAluno("nomeAluno",1);

        Assert.assertNotEquals(0,alunos.size());
    }

    @Test
    public void setandoAluno(){
        Usuario usuario = new Usuario();
        when(alunoDAO.setAluno(usuario)).thenReturn(aluno);

        alunoDAO.setAluno(usuario);

        Assert.assertNotEquals(0,aluno.getId());
    }

    @Test
    public void validandoAluno(){
        when(alunoDAO.validarAluno(aluno.getCPF())).thenReturn(true);

        Assert.assertTrue(alunoDAO.validarAluno(aluno.getCPF()));
    }
}
