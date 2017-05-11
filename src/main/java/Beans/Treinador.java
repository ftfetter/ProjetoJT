package Beans;

public class Treinador extends Usuario {

    public Treinador(){

    }

    public Treinador(int id, String nome){
        super.setId(id);
        super.setNome(nome);
    }

    public Treinador(int id, String nome, String cpf, int tipoLogin, String login, String senha) {
        super(login, senha);
        super.setId(id);
        super.setNome(nome);
        super.setCPF(cpf);
        super.setTipoLogin(tipoLogin);
    }

}
