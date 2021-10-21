package br.inatel.c207;

public class Main {

    public static void main(String[] args) {
        AlunoDB alunodb = new AlunoDB();
        CursoDB cursodb = new CursoDB();

        Aluno aluno1 = new Aluno("Arthur",2000,"M");
        Aluno aluno2 = new Aluno("Matheus",2000,"M");
        Curso curso1 = new Curso("Eng. de Computação");
        Curso curso2 = new Curso("Eng. de Computação");

        alunodb.insertAluno(aluno1);
        alunodb.insertAluno(aluno2);
        cursodb.insertCurso(curso1);
        cursodb.insertCurso(curso2);

        System.out.println("-------------------Buscando infos no BD-------------------------");
        alunodb.researchAluno();
        cursodb.researchCurso();

        System.out.println();
        System.out.println("-------------------Atualizando infos no BD-------------------------");
        System.out.println();

        alunodb.updateFkAluno(1,1);
        alunodb.updateFkAluno(2,2);
        alunodb.researchAluno();
        cursodb.updateCurso(2,"Eng. de Software");
        cursodb.researchCurso();

        System.out.println();
        System.out.println("-------------------Excluindo infos no BD-------------------------");
        System.out.println();

        alunodb.deleteAluno(2);
        cursodb.deleteCurso(2);
        alunodb.researchAluno();
        cursodb.researchCurso();


    }

}
