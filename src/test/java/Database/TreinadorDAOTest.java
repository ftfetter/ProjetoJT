package Database;

import Users.*;
import org.junit.Assert;
import org.junit.Test;

public class TreinadorDAOTest {

    TreinadorDAO treinadorDAO = new TreinadorDAO();
    Usuario treinador;

    @Test
    public void setandoTreinador(){
        Usuario usuario = new Usuario("admin","admin");
        usuario.setId(1);

        treinador = treinadorDAO.setTreinador(usuario);

        Assert.assertNotNull(treinador);
    }

    @Test
    public void encontrandoTreinador(){
        treinador = treinadorDAO.buscaTreinador(1);

        Assert.assertNotNull(treinador);
    }
}
