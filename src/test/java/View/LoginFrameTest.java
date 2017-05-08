package View;

import Beans.Usuario;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoginFrameTest {
    Usuario usuario = new Usuario("admin","admin");
    LoginFrame loginFrame = mock(LoginFrame.class);

    @Test
    public void validandoLogin (){

        when(loginFrame.validarLogin(usuario)).thenReturn(true);

        Assert.assertTrue(loginFrame.validarLogin(usuario));
    }

    @Test
    public void logandoTreinador (){
        usuario.setTipoLogin(1);

        when(loginFrame.login(usuario)).thenReturn(true);

        Assert.assertTrue(loginFrame.login(usuario));
    }

    @Test
    public void logandoAluno (){
        usuario.setTipoLogin(2);

        when(loginFrame.login(usuario)).thenReturn(true);

        Assert.assertTrue(loginFrame.login(usuario));
    }
}
