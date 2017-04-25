package Forms;

import Users.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class frmLoginTest {
    Usuario usuario = new Usuario("admin","admin");
    frmLogin frmlogin = new frmLogin();

    @Test
    public void validandoLogin (){
        Assert.assertTrue(frmlogin.validaLogin(usuario));
    }

    @Test
    public void logandoTreinador (){
        usuario.setTipoLogin(1);

        Assert.assertTrue(frmlogin.login(usuario));
    }

    @Test
    public void logandoAluno (){
        usuario.setTipoLogin(2);

        Assert.assertTrue(frmlogin.login(usuario));
    }
}
