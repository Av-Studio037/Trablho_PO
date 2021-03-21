/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Aluno;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class ControlAluno {

    String caminho = System.getenv("APPDATA") + File.separator + "Amal Trabalho de PO" +File.separator+"Aluno";
    File directorio = new File(caminho);
    File fileAluno = new File(caminho + File.separator + "Dados de Aluno.bin");

    ArrayList<Aluno> lista = new ArrayList();

    //CRUD
    public void criar() throws IOException {

        if (!directorio.exists()) {
            directorio.mkdir();
            System.out.println("Directorio criado");
        } else {
            System.out.println("Directorio existe");
        }
        if (!fileAluno.exists()) {
            fileAluno.createNewFile();
            System.out.println("file de Aluno criado com sucesso");
            escrever(lista);
        } else {
            System.out.println("ficheiro existe");
        }

    }

    public void registar(Aluno a) {
        lista = (ArrayList<Aluno>) lista1().clone();
        lista.add(a);
        escrever(lista);
        JOptionPane.showMessageDialog(null, "Aluno Registado com sucesso");
    }

    public void editar(int numAluno, Aluno a) {

        lista = (ArrayList<Aluno>) lista1().clone();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getNumAluno() == numAluno) {
                a.setComportamento(lista.get(i).getComportamento());
                a.setNumFaltas(lista.get(i).getNumFaltas());
                a.setTeste1(lista.get(i).getTeste1());
                a.setTeste2(lista.get(i).getTeste2());
                a.setAc(lista.get(i).getAc());
                a.setTs(lista.get(i).getTs());
                a.setMedia(lista.get(i).getMedia());
                lista.remove(i);
                lista.add(a);
            }
        }
        escrever(lista);
        JOptionPane.showMessageDialog(null, "Aluno Editado com sucesso");
    }

    public void eliminar(int numAluno) {

        lista = (ArrayList<Aluno>) lista1().clone();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNumAluno() == numAluno) {
                lista.remove(i);
            }

        }

        escrever(lista);
        JOptionPane.showMessageDialog(null, "Aluno Eliminado com sucesso");
    }

    public ArrayList<Aluno> pesquisar(String nome) {

        lista = (ArrayList<Aluno>) lista1().clone();
        ArrayList<Aluno> lista2 = new ArrayList();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getNome().startsWith(nome)) {

                lista2.add(lista.get(i));
            }
        }
        return lista2;
    }

    public void escrever(ArrayList<Aluno> lista) {
        try {
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(fileAluno));
            obj.writeObject(lista);
            obj.close();
            System.out.println("Aluno Salvo com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getMessage();
        }
    }

    public ArrayList<Aluno> lista1() {
        ArrayList<Aluno> lista2 = new ArrayList();
        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(fileAluno));
            lista2 = (ArrayList<Aluno>) obj.readObject();
            obj.close();

        } catch (Exception e) {
            e.getMessage();
        }
        return lista2;

    }

    public void atribuirFalta(int numAluno, Aluno a) {

        lista = (ArrayList<Aluno>) lista1().clone();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getNumAluno() == numAluno) {
                a.setNumAluno(lista.get(i).getNumAluno());
                a.setCategoria(lista.get(i).getCategoria());
                a.setNome(lista.get(i).getNome());
                a.setComportamento(lista.get(i).getComportamento()); 
                a.setNumFaltas(lista.get(i).getNumFaltas() + 1); //Aumentando mais uma falta ao aluno
                a.setTeste1(lista.get(i).getTeste1());
                a.setTeste2(lista.get(i).getTeste2());
                a.setAc(lista.get(i).getAc());
                a.setTs(lista.get(i).getTs());
                a.setMedia(lista.get(i).getMedia());
                lista.remove(i);
                lista.add(a);
            }
        }
        escrever(lista);
    }

    public boolean numExiste(Aluno a) {
        lista = (ArrayList<Aluno>) lista1().clone();

        for (int i = 0; i < lista.size(); i++) {
            if (a.getNumAluno() == lista.get(i).getNumAluno()) {
                return true;
            }
        }

        return false;
    } //Validacao para que nao haja 2 alunos ou mais com mesmo numero de estudante

}
