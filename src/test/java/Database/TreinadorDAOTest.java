package Database;

import Users.*;
import org.junit.Assert;
import org.junit.Test;

public class TreinadorDAOTest {

    @Test
    public void setandoTreinador(){
        Usuario usuario = new Usuario("admin","admin");
        usuario.setId(1);

        Usuario treinador;

        treinador = TreinadorDAO.setTreinador(usuario);

        Assert.assertNotNull(treinador);
    }
}
