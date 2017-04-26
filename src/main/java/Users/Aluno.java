package Users;

public class Aluno extends Usuario {

    private int idTreinador;

    public Aluno(){

    }

    public Aluno(int id, String nome, String cpf, int tipoLogin, int idTreinador, String login, String senha) {
        super(login, senha);
        super.setId(id);
        super.setNome(nome);
        super.setCPF(cpf);
        super.setTipoLogin(tipoLogin);
        this.setIdTreinador(idTreinador);
    }

    public int getIdTreinador() {
        return idTreinador;
    }

    public void setIdTreinador(int idTreinador) {
        this.idTreinador = idTreinador;
    }
}
