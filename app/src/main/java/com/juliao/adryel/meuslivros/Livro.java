package com.juliao.adryel.meuslivros;
/**
 * Created by André Gomes e Adryel on 06/09/2017.
 */

public class Livro {
    private long id;
    private String titulo;
    private String autor;
    private int ano;
    private float nota;

    public Livro() {
        this.id=0;
    }

    public Livro(String titulo, String autor, int ano, float nota) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.nota = nota;
        this.id=0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String toString(){
        return titulo + "   " + autor;
    }
}