package Users;

import Database.TreinadorDAO;

public class Aluno extends Usuario {

    private Usuario treinador;

    public Aluno(int id, String nome, String cpf, int tipoLogin, int idTreinador, String login, String senha) {
        super(login, senha);
        super.setId(id);
        super.setNome(nome);
        super.setCPF(cpf);
        super.setTipoLogin(tipoLogin);
        this.setTreinador(idTreinador);
    }

    public Usuario getTreinador() {
        return treinador;
    }

    public void setTreinador(int idTreinador){
        this.treinador = TreinadorDAO.buscaTreinador(idTreinador);
    }
}
