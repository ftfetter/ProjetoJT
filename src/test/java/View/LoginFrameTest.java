package View;

import Beans.Treinador;
import Beans.Usuario;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoginFrameTest {
    Usuario usuario = new Usuario("login","senha");
    LoginFrame loginFrame = new LoginFrame();

    @Test
    public void validandoLogin (){
        Assert.assertTrue(loginFrame.validarLogin(usuario));
    }
}
