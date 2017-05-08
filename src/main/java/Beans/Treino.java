package Beans;

public class Treino {

    private int idAluno;
    private int idExercicio;
    private String exercicio;
    private int repeticao;
    private int carga;

    public Treino(){

    }

    public Treino(int idExercicio, int idAluno, int repeticao, int carga, String exercicio){
        this.idExercicio = idExercicio;
        this.idAluno = idAluno;
        this.repeticao = repeticao;
        this.carga = carga;
        this.exercicio = exercicio;
    }

    public int getIdAluno() { return idAluno; }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(int idExercicio) {
        this.idExercicio = idExercicio;
    }

    public String getExercicio() { return exercicio; }

    public void setExercicio(String exercicio) { this.exercicio = exercicio; }

    public int getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(int repeticao) {
        this.repeticao = repeticao;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }
}
