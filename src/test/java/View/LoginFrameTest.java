package View;

import Beans.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class LoginFrameTest {
    Usuario usuario = new Usuario("admin","admin");
    LoginFrame loginFrame = new LoginFrame();

    @Test
    public void validandoLogin (){
        Assert.assertTrue(loginFrame.validarLogin(usuario));
    }

    @Test
    public void logandoTreinador (){
        usuario.setTipoLogin(1);

        Assert.assertTrue(loginFrame.login(usuario));
    }

    @Test
    public void logandoAluno (){
        usuario.setTipoLogin(2);

        Assert.assertTrue(loginFrame.login(usuario));
    }
}
