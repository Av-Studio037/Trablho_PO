/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Aula implements Serializable{
    private String tema,data,categoria;
    private int numero,duracao;
    private ArrayList<Aluno> participante;


    public Aula() {
        
    }

    public ArrayList<Aluno> getParticipante() {
        return participante;
    }

    public void setParticipante(ArrayList<Aluno> participante) {
        this.participante = participante;
    }

    
    

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    
    
}
