package Database;

import Beans.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class UsuarioDAOTest {

    @Test
    public void loginAutenticado(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario("admin", "admin");

        usuario = usuarioDAO.autenticarLogin(usuario);

        Assert.assertTrue(usuario.getId() != 0);
    }

    @Test
    public void loginNaoAutenticado(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario("bla", "bla");

        usuario = usuarioDAO.autenticarLogin(usuario);

        Assert.assertTrue(usuario.getId() == 0);
    }
}
