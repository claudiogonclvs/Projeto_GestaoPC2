package pc2;

import java.io.Serializable;
import java.util.ArrayList;

public class Ramo implements Serializable {
    private int id;
    private String nome;
    private String abreviatura;
    private int numAlunos;
    public static String curso="EEC";
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(Aluno a) {
        alunos.add(a);
    }


    public Ramo(String nome, String abreviatura) {
        this.nome = nome;
        this.abreviatura = abreviatura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public int getNumAlunos() {
        return numAlunos;
    }

    public void setNumAlunos(int numAlunos) {
        this.numAlunos = numAlunos;
    }

    @Override
    public String toString() {
        return "Ramo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", abreviatura='" + abreviatura + '\'' +
                ", numAlunos=" + numAlunos +
                '}';
    }
}
