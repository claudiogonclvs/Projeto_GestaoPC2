package pc2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Aluno implements Comparable<Aluno>, Serializable {
    private int numero;
    private String nome;
    private Ramo ramo;
    private ArrayList<Double> notas = new ArrayList<>(2);
    private int notaFinal;
    public static final int PE=0;
    public static final int P=1;
    public static final double PESOPE=0.4;
    public static final double PESOP=0.6;


    public Aluno(int numero, String nome, Ramo ramo) {
        this.numero = numero;
        this.nome = nome;
        this.ramo = ramo;
        notas.add(0.0);
        notas.add(0.0);
    }

    public void adiconarNota(int pos, double nota){
        notas.set(pos,nota);
    }
    public void calculaNotaFinal(){
        notaFinal= (int) Math.round(notas[PE]*PESOPE + notas[P]*PESOP);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Ramo getRamo() {
        return ramo;
    }

    public void setRamo(Ramo ramo) {
        this.ramo = ramo;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "numero=" + numero +
                ", nome='" + nome + '\'' +
                ", ramo=" + ramo.getAbreviatura() +
                ", notas=" + notas +
                ", notaFinal=" + notaFinal +
                '}';
    }

    @Override
    public int compareTo(Aluno o) {
        /*
        if(notaFinal<o.notaFinal)
            return 1;
        if(notaFinal<o.notaFinal)
            return -1;
        return 0;
        */

        return nome.compareToIgnoreCase(o.nome);
    }
}
