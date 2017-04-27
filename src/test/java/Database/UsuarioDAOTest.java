package Database;

import Users.Usuario;
import org.junit.Assert;
import org.junit.Test;


public class UsuarioDAOTest {

    @Test
    public void loginAutenticado(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario("admin", "admin");

        usuario = usuarioDAO.autenticarLogin(usuario);

        Assert.assertNotNull(usuario.getId());
    }

    @Test
    public void loginNaoAutenticado(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario("bla", "bla");

        usuario = usuarioDAO.autenticarLogin(usuario);

        Assert.assertTrue(usuario.getId() == 0);
    }
}
