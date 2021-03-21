/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class Aluno extends Pessoa{
    
    private String comportamento,categoria,presenca;
    private int numAluno,numFaltas;
    private double teste1,teste2,ac,ts,media;

    public Aluno() {
        this.setComportamento("Bom");
        this.setNumFaltas(0);
        this.setTeste1(0);
        this.setTeste2(0);
        this.setAc(0);
        this.setMedia(0);
    }
    
    

    public String getComportamento() {
        return comportamento;
    }

    public void setComportamento(String comportamento) {
        this.comportamento = comportamento;
    }

    public int getNumAluno() {
        return numAluno;
    }

    public void setNumAluno(int numAluno) {
        this.numAluno = numAluno;
    }

    public int getNumFaltas() {
        return numFaltas;
    }

    public void setNumFaltas(int numFaltas) {
        this.numFaltas = numFaltas;
    }

    public double getTeste1() {
        return teste1;
    }

    public void setTeste1(double teste1) {
        this.teste1 = teste1;
    }

    public double getTeste2() {
        return teste2;
    }

    public void setTeste2(double teste2) {
        this.teste2 = teste2;
    }

    public double getAc() {
        return ac;
    }

    public void setAc(double ac) {
        this.ac = ac;
    }

    public double getTs() {
        return ts;
    }

    public void setTs(double ts) {
        this.ts = ts;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPresenca() {
        return presenca;
    }

    public void setPresenca(String presenca) {
        this.presenca = presenca;
    }
    
    
    
    
}
