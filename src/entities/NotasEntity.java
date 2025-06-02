package entities;

public class NotasEntity {
    private int id;
    private String aluno;
    private String disciplina;
    private float nota;
    public NotasEntity() {
    }
    public NotasEntity(int id, String aluno, String disciplina, float nota) {
        this.id = id;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.nota = nota;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAluno() {
        return aluno;
    }
    public void setAluno(String aluno) {
        this.aluno = aluno;
    }
    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    public float getNota() {
        return nota;
    }
    public void setNota(float nota) {
        this.nota = nota;
    }
    public String toString(){
        return "Id:" + id + " - "+aluno + "\n        "+disciplina + " ["+ nota +"]";
    }
    
}
