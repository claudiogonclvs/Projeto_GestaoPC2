package pc2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe gestão, que contém os arrays com toda a informação
 */
public class Gestao{

                                            ///////////////Ramos//////////////////////////////////

    /** arrayList que guarda todos os ramos */
    private ArrayList<Ramo> ramos = new ArrayList<>();
    private int soma2;


    /**
     * Permite adicionar um ramo ao array dos ramos
     * @param r recebe o ramo
     */
    public void adicionarRamo(Ramo r) {

        ramos.add(r);

        r.setId(ramos.size());

        //se houver eliminações:
        //r.setId(ramos[numRamos-1].getId()+1);
    }

    /**
     * Mostra todos os ramos
     * @return devolve uma string com os ramos
     */
    public String mostrarRamos() {
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < ramos.size(); i++) {
            s.append(ramos.get(i)).append("\n");
        }
        return s.toString();
    }

    public int pesquisarRamo(int id) {
        for (int i = 0; i < ramos.size(); i++) {
            if (ramos.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Ramo obterRamo(int pos) {
        return ramos.get(pos);
    }

    public int getNumRamos() {
        return ramos.size();
    }


                                ///////////////Alunos//////////////////////////////////


    private ArrayList<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(Aluno a) {
        alunos.add(a);
    }

    public String mostrarAlunos() {
        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < alunos.size(); i++) {
            s.append(alunos.get(i)).append("\n");
        }
        return s.toString();
    }

    public String mostrarAlunosNotaDecrescente() {
        Collections.sort(alunos);
        return mostrarAlunos();
    }

    public String mostrarAlunosNomeCrescente() {
        Collections.sort(alunos);
        return mostrarAlunos();
    }

    public int pesquisarAluno(int numero) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getNumero() == numero) {
                return i;
            }
        }
        return -1;
    }

    public String pesquisarAluno(String nome) {
        StringBuilder s= new StringBuilder("");
        for (int i = 0; i < alunos.size(); i++) {
            //if (alunos[i].getNome().equalsIgnoreCase(nome)) {
            if (alunos.get(i).getNome().toUpperCase().contains(nome.toUpperCase())) {
                s.append(alunos.get(i)).append("\n");
            }
        }
        return s.toString();
    }


    public Aluno obterAluno(int pos) {
        return alunos.get(pos);
    }

    public void removerAluno(int pos) {
        alunos.remove(pos);
    }


    public int getNumAlunos() {
        return alunos.size();
    }

    public void gravarFicheiro()
    {
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pc2.dat"));
            out.writeObject(alunos);
            out.writeObject(ramos);
            out.close();
        } catch (IOException ex){
            System.out.println(ex.getLocalizedMessage());
        }
    }

    public void lerFicheiro(){
        try {
            ObjectOutputStream in = new ObjectInputStream(new FileInputStream("pc2.dat"));
            alunos= (ArrayList<Aluno>) in.readObject();
            ramos = (ArrayList<Aluno>) in.readObject();

        }
    }

    public double calculaMedia()
    {
        int soma= 0;
        for(int i=0; i <alunos.size() ; i++)
        {
            soma+= alunos.get(i).getNotaFinal();
        }
        return (double)soma/alunos.size();
    }

    public double calculaMedia2()
    {
        return (double)soma2/alunos.size();
    }

    public double calculaMedia3()
    {
        int soma= 0;
        for(Aluno = a:alunos)
        {
            soma+= a.getNotaFinal();
        }
        return (double)soma/alunos.size();
    }

    public int getSoma2() {
        return soma2;
    }

    public void setSoma2(int soma2) {
        this.soma2 = soma2;
    }

    public String mostrarAlunoNotaMaior()
    {
        int notaMaior= 0;//INTEGER.MIN_VALUE;
        for(int i = 0; i< alunos.size(); i++)
        {
            if(alunos.get(i).getNotaFinal()>notaMaior)
            {
                notaMaior= alunos.get(i).getNotaFinal();
            }
        }
        StringBuilder str= new StringBuilder("");
        for(int i = 0; i< alunos.size(); i++)
        {
            if(alunos.get(i).getNotaFinal()==notaMaior)
            {
                str.append(a).append("\n");
            }
        }
        return str.toString();
    }

    public String mostrarAlunoNotaMaior2()
    {
        int notaMaior= 0;//INTEGER.MIN_VALUE;
        for(Aluno = a:alunos)
        {
            if(a.getNotaFinal()>notaMaior)
            {
                notaMaior= a.getNotaFinal();
            }
        }
        StringBuilder str= new StringBuilder("");
        for(Aluno = a:alunos)
        {
            if(a.getNotaFinal()==notaMaior)
            {
                str.append(alunos.get(i).getNome().;
            }
        }
        return str.toString();
    }


}

