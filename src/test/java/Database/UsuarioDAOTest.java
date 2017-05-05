package Database;

import Beans.Aluno;
import Beans.Usuario;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class UsuarioDAOTest {

    UsuarioDAO usuarioDAO = mock(UsuarioDAO.class);

    @Test
    public void loginAutenticado(){
        Usuario usuario = new Usuario();
        usuario.setId(1);

        when(usuarioDAO.autenticarLogin(usuario)).thenReturn(usuario);

        usuarioDAO.autenticarLogin(usuario);

        Assert.assertNotEquals(0,usuario.getId());
    }

    @Test
    public void adicionandoUsuario(){
        Aluno aluno = new Aluno();

        when(usuarioDAO.adicionarUsuario(aluno)).thenReturn(true);

        Assert.assertTrue(usuarioDAO.adicionarUsuario(aluno));
    }
}
