package Users;

public class Aluno extends Usuario {

    private int idTreinador;
    private float peso;
    private float altura;
    private float gordura;

    public int getIdTreinador() {
        return idTreinador;
    }

    public void setIdTreinador(int idTreinador) {
        this.idTreinador = idTreinador;
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

    public Aluno(int id, String nome, String cpf, float peso, float altura, float gordura){
        super.setId(id);
        super.setNome(nome);
        super.setCPF(cpf);
        this.setPeso(peso);
        this.setAltura(altura);
        this.setGordura(gordura);
    }

    public Aluno(int id, String nome, String cpf, int tipoLogin, int idTreinador, String login, String senha) {
        super(login, senha);
        super.setId(id);
        super.setNome(nome);
        super.setCPF(cpf);
        super.setTipoLogin(tipoLogin);
        this.setIdTreinador(idTreinador);
    }


}
