package br.inatel.c207;

public class Aluno {

    public int matricula;
    public int fk_idcurso;
    private String nome;
    private int ano_nasc;
    private String sexo;

    public Aluno(String nome, int ano_nasc, String sexo) {
        this.nome = nome;
        this.ano_nasc = ano_nasc;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno_nasc() {
        return ano_nasc;
    }

    public void setAno_nasc(int ano_nasc) {
        this.ano_nasc = ano_nasc;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
