package Beans;

public class Aluno extends Usuario {

    private int treinadorId;
    private float peso;
    private float altura;
    private float gordura;

    public int getTreinadorId() {
        return treinadorId;
    }

    public void setTreinadorId(int treinadorId) {
        this.treinadorId = treinadorId;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getGordura() {
        return gordura;
    }

    public void setGordura(float gordura) {
        this.gordura = gordura;
    }

    public Aluno(){

    }

    public Aluno(int id, String nome, String cpf){
        super.setId(id);
        super.setNome(nome);
        super.setCPF(cpf);
    }

    public Aluno(int id, String nome, String cpf, int tipoLogin, int idTreinador, String login, String senha) {
        super(login, senha);
        super.setId(id);
        super.setNome(nome);
        super.setCPF(cpf);
        super.setTipoLogin(tipoLogin);
        this.setTreinadorId(treinadorId);
    }


}
