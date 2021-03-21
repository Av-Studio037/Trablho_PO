/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Aluno;
import Modelo.Aula;
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
public class ControlAula {

    String caminho = System.getenv("APPDATA") + File.separator + "Amal Trabalho de PO" +File.separator+"Aula";
    File directorio = new File(caminho);
    File fileAula = new File(caminho + File.separator + "Dados das Aulas.bin");

    ArrayList<Aula> lista = new ArrayList();
    ControlAluno controlAluno = new ControlAluno();

    public void criar() throws IOException {

        if (!directorio.exists()) {
            directorio.mkdir();
            System.out.println("Directorio criado");
        } else {
            System.out.println("Directorio existe");
        }
        if (!fileAula.exists()) {
            fileAula.createNewFile();
            System.out.println("file da Aula criado com sucesso");
            escrever(lista);
        } else {
            System.out.println("ficheiro existe");
        }

    }
 

    public void registar(Aula a) {
        lista = (ArrayList<Aula>) lista1().clone();
        lista.add(a);
        escrever(lista);
        JOptionPane.showMessageDialog(null, "Aula Registada com sucesso");
    }
    
     public void escrever(ArrayList<Aula> lista) {
        try {
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(fileAula));
            obj.writeObject(lista);
            obj.close();
            System.out.println("Aula Salva com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getMessage();
        }
    }

    public ArrayList<Aula> lista1() {
        ArrayList<Aula> lista2 = new ArrayList();
        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(fileAula));
            lista2 = (ArrayList<Aula>) obj.readObject();
            obj.close();

        } catch (Exception e) {
            e.getMessage();
        }
        return lista2;

    }

    public ArrayList<Aluno> todosPresentes() {
        String caminho = System.getenv("APPDATA") + File.separator + "Meu Trabalho";
        File directorio = new File(caminho);
        File fileAluno = new File(caminho + File.separator + "Dados de Aluno.bin");
        ArrayList<Aluno> lista2 = new ArrayList();
        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(fileAluno));
            lista2 = (ArrayList<Aluno>) obj.readObject();
            //registar presencas
            for (int i = 0; i < lista2.size(); i++) {
                lista2.get(i).setPresenca("Presente");
            }
            obj.close();

        } catch (Exception e) {
            e.getMessage();
        }
        return lista2;

    }

    public void atribuirFalta(int numAluno, Aluno a) {

        ArrayList<Aluno> lista = (ArrayList<Aluno>) listaAlunos().clone();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getNumAluno() == numAluno) {
                a.setNumAluno(lista.get(i).getNumAluno());
                a.setNome(lista.get(i).getNome());
                a.setPresenca("Ausente");
                lista.remove(i);
                lista.add(a);
            }
        }
        ArrayList<Aluno> listaAlunos = (ArrayList<Aluno>) lista.clone();
    }

    public void atribuirpresenca(int numAluno, Aluno a) {

        ArrayList<Aluno> lista = (ArrayList<Aluno>) listaAlunos().clone();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getNumAluno() == numAluno) {
                a.setNumAluno(lista.get(i).getNumAluno());
                a.setNome(lista.get(i).getNome());
                a.setPresenca("Presente");
                lista.remove(i);
                lista.add(a);
            }
        }
        ArrayList<Aluno> listaAlunos = (ArrayList<Aluno>) lista.clone();
    }

    public ArrayList<Aluno> todosAusentes() {

        String caminho = System.getenv("APPDATA") + File.separator + "Meu Trabalho";
        File directorio = new File(caminho);
        File fileAluno = new File(caminho + File.separator + "Dados de Aluno.bin");

        ArrayList<Aluno> lista2 = new ArrayList();

        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(fileAluno));
            lista2 = (ArrayList<Aluno>) obj.readObject();

            //registar presencas
            for (int i = 0; i < lista2.size(); i++) {
                controlAluno.atribuirFalta(controlAluno.lista1().get(i).getNumAluno(), controlAluno.lista1().get(i));
                lista2.get(i).setPresenca("Ausente");
            }
            obj.close();

        } catch (Exception e) {
            e.getMessage();
        }
        return lista2;

    }

    public ArrayList<Aluno> listaAlunos() {

        String caminho = System.getenv("APPDATA") + File.separator + "Meu Trabalho";
        File directorio = new File(caminho);
        File fileAluno = new File(caminho + File.separator + "Dados de Aluno.bin");

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

   

}
