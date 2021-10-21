package br.inatel.c207;

import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoDB extends Database{

    // ----------------------------INSERINDO NOVO REGISTRO----------------------------
    public boolean insertAluno(Aluno aluno){
        connect();
        String sql = "INSERT INTO aluno(nome, ano_nasc, sexo) VALUES(?, ?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, aluno.getNome());
            pst.setInt(2,aluno.getAno_nasc());
            pst.setString(3,aluno.getSexo());
            pst.execute();                           // executa o comando
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    // ----------------------------BUSCANDO TODOS REGISTROS----------------------------
    public ArrayList<Aluno> researchAluno(){
        connect();
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM aluno";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                Aluno alunoTemp = new Aluno(result.getString("nome"), result.getInt("ano_nasc"),result.getString("sexo"));
                alunoTemp.matricula = result.getInt("matricula");
                alunoTemp.fk_idcurso = result.getInt("fk_idcurso");
                System.out.println("Matricula = " + alunoTemp.matricula);
                System.out.println("Nome = " + alunoTemp.getNome());
                System.out.println("Ano Nascimento = " + alunoTemp.getAno_nasc());
                System.out.println("Sexo = " + alunoTemp.getSexo());
                if(alunoTemp.fk_idcurso > 0)
                    System.out.println("Curso: " + alunoTemp.fk_idcurso);
                System.out.println("------------------------------");
                alunos.add(alunoTemp);
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return alunos;
    }

    // ----------------------------ATUALIZANDO REGISTRO----------------------------
    public boolean updateFkAluno(int matricula, int fk_idcurso){
        connect();
        String sql = "UPDATE aluno SET fk_idcurso=? WHERE matricula=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, fk_idcurso);
            pst.setInt(2, matricula);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    // ----------------------------EXCLUINDO REGISTRO----------------------------
    public boolean deleteAluno(int matricula) {
        connect();
        String sql = "DELETE FROM aluno WHERE matricula=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, matricula);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
}


