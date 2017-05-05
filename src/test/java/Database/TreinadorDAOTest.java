package Database;

import Beans.*;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TreinadorDAOTest {

    TreinadorDAO treinadorDAO = mock(TreinadorDAO.class);
    Treinador treinador;

    @Test
    public void setandoTreinador(){
        Usuario usuario = new Usuario();
        treinador = new Treinador(1,"nome","123.123.123-12",1,"login","senha");

        when(treinadorDAO.setTreinador(usuario)).thenReturn(treinador);

        treinadorDAO.setTreinador(usuario);

        Assert.assertNotEquals(0,treinador.getId());
    }

    @Test
    public void encontrandoTreinador(){
        treinador = new Treinador(1,"nome","123.123.123-12",1,"login","senha");

        when(treinadorDAO.buscaTreinador(1)).thenReturn(treinador);

        treinadorDAO.buscaTreinador(1);

        Assert.assertNotEquals(0,treinador.getId());
    }
}
