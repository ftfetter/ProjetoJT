package Users;

/**
 * Created by ilegra0320 on 19/04/2017.
 */
public class Treinador extends Usuario {

    public Treinador(int id, String nome, String cpf, int tipoLogin, String login, String senha) {
        super(login, senha);
        super.setId(id);
        super.setNome(nome);
        super.setCPF(cpf);
        super.setTipoLogin(tipoLogin);
    }

}
