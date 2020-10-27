package pc2;

import util.Consola;

public class Main {

    private static Gestao g = new Gestao();

    public static void main(String[] args) {
        int opcao, opcao2;
        do {
            opcao = menu();
            switch (opcao) {
                case 1:
                    lerRamo();
                    break;
                case 2:
                    if(g.getNumRamos()>0)
                        lerAluno();
                    else
                        System.out.println("Ainda não foram inseridos ramos!");
                    break;
                case 3:
                    if(g.getNumAlunos()>0)
                        associarNotasAluno();
                    else
                        System.out.println("Ainda não foram inseridos alunos!");
                    break;
                case 4:
                    if(g.getNumAlunos()>0)
                        removerAluno();
                    else
                        System.out.println("Ainda não foram inseridos alunos!");
                    break;
                case 5:
                    if(g.getNumAlunos()>0)
                        consultarAlunoNumero();
                    else
                        System.out.println("Ainda não foram inseridos alunos!");
                    break;
                case 6:
                    if(g.getNumAlunos()>0)
                        consultarAlunoNome();
                    else
                        System.out.println("Ainda não foram inseridos alunos!");
                    break;
                case 7:
                    System.out.println(g.mostrarRamos());
                    break;
                case 8:
                    System.out.println(g.mostrarAlunos());
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    do
                    {
                        opcao2 = menuEstatisticas();
                        switch (opcao2)
                        {
                            case 1:
                                System.out.println("Média:" + g.calculaMedia());
                                System.out.println("Média:" + g.calculaMedia2());
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                        }
                    }while(opcao2!=0);
                    break;
                case 0:
                    System.out.println("Programa terminou...");
            }
            Consola.sc.nextLine();
        } while (opcao != 0);
        g.gravarFicheiro();
    }

    private static void consultarAlunoNome() {
        String nome = Consola.lerString("Indique o nome do aluno a pesquisar: ");
        String s= g.pesquisarAluno(nome);
        if (s.isEmpty())
            System.out.println("Não há alunos com esse nome!");
        else
            System.out.println(s);
    }

    private static void associarNotasAluno() {
        int numero, pos;
        do {
            numero = Consola.lerInt("Indique o número do aluno: ", 1, 9999999);
            pos = g.pesquisarAluno(numero);
            if (pos == -1)
                System.out.println("Esse aluno não existe!");
        } while (pos == -1);
        Aluno a = g.obterAluno(pos);

        double nota = Consola.lerDouble("Indique a nota da prova escrita: ", 0, 20);
        a.adiconarNota(Aluno.PE, nota);

        nota = Consola.lerDouble("Indique a nota do projeto: ", 0, 20);
        a.adiconarNota(Aluno.P, nota);

        a.calculaNotaFinal();

        g.setSoma2(g.getSoma2()+a.getNotaFinal());
    }

    private static void removerAluno() {
        int numero, pos;
        do {
            numero = Consola.lerInt("Indique o número do aluno: ", 1, 9999999);
            pos = g.pesquisarAluno(numero);
            if (pos == -1)
                System.out.println("Esse aluno não existe!");
        } while (pos == -1);

        Aluno a = g.obterAluno(pos);
        a.getRamo().setNumAlunos(a.getRamo().getNumAlunos()-1);
        g.setSoma2(g.getSoma2()-a.getNotaFinal());

        g.removerAluno(pos);

        System.out.println("Aluno removido com sucesso!");
    }

    private static void consultarAlunoNumero() {
        int numero, pos;
        do {
            numero = Consola.lerInt("Indique o número do aluno: ", 1, 9999999);
            pos = g.pesquisarAluno(numero);
            if (pos == -1)
                System.out.println("Esse aluno não existe!");
        } while (pos == -1);
        Aluno a = g.obterAluno(pos);

        //String nome=Consola.lerString("Indique o novo nome");
        //a.setNome(nome);


        System.out.println(a);
    }

    private static void lerAluno() {
        int pos, id, numero;

        do {
            numero = Consola.lerInt("Indique o número do aluno: ", 1, 9999999);
            pos = g.pesquisarAluno(numero);
            if (pos != -1)
                System.out.println("Esse aluno já existe!");
        } while (pos != -1);

        String nome = Consola.lerString("Indique o nome do aluno:");

        System.out.println(g.mostrarRamos());
        do {
            id = Consola.lerInt("Indique o ramo do aluno: ", 1, g.getNumRamos());
            pos = g.pesquisarRamo(id);
            if (pos == -1)
                System.out.println("Este ramo não existe");
        } while (pos == -1);
        Ramo ramo = g.obterRamo(pos);

        Aluno a = new Aluno(numero, nome, ramo);

        ramo.adicionarAluno(a);


        ramo.setNumAlunos(ramo.getNumAlunos()+1);
        g.adicionarAluno(a);
        System.out.println("Aluno inserido com sucesso!");
    }

    private static void lerRamo() {
        String nome = Consola.lerString("indique o nome do ramo: ");
        String abreviatura = Consola.lerString("indique a abreviatura do ramo: ");

        Ramo r = new Ramo(nome, abreviatura);
        g.adicionarRamo(r);

        System.out.println("Ramo inserido com sucesso!");
    }

    private static int menu() {
        int opcao;

        System.out.println();
        System.out.println("1 - Adicionar ramo");
        System.out.println("2 - Adicionar aluno");
        System.out.println("3 - Inserir/Modificar notas de um aluno");
        System.out.println("4 - Eliminar aluno");
        System.out.println("5 - Consultar aluno por número");
        System.out.println("6 - Consultar aluno por nome");
        System.out.println("7 - Listar ramos");
        System.out.println("8 - Listar alunos");
        System.out.println("9 - Listar alunos por ordem alfabetica");
        System.out.println("10 - Listar alunos por ordem dec. da nota final");
        System.out.println("11 - Estatisticas");
        System.out.println("0 - Sair\n");
        opcao = Consola.lerInt("Opcao: ", 0, 11);

        return opcao;
    }

    private static int menuEstatisticas() {
        int opcao2;

        System.out.println();
        System.out.println("1 - Media das notas");
        System.out.println("2 - Aluno com a nota mais alta");
        System.out.println("3 - Ramo com a média mais elevada");
        System.out.println("0 - Menu anterior\n");
        opcao2 = Consola.lerInt("Opcao: ", 0, 3);

        return opcao2;
    }


}

