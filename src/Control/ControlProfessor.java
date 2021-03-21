/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Professor;
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
public class ControlProfessor {

    String caminho = System.getenv("APPDATA") + File.separator + "Amal Trabalho de PO" +File.separator+"Professor";
    File directorio = new File(caminho);
    File fileProf = new File(caminho + File.separator + "Dados de Professor.bin");

    ArrayList<Professor> lista = new ArrayList();
    
    //CRUDE

    public void criar() throws IOException {

        if (!directorio.exists()) {
            directorio.mkdir();
            System.out.println("Directorio criado");
        } else {
            System.out.println("Directorio existe");
        }
        if (!fileProf.exists()) {
            fileProf.createNewFile();
            System.out.println("file de Professor criado com sucesso");
            escrever(lista);
        } else {
            System.out.println("ficheiro existe");
        }

    }

    public void registar(Professor p) {
        lista = (ArrayList<Professor>) lista1().clone();
        lista.add(p);
        escrever(lista);
        JOptionPane.showMessageDialog(null, "Professor Registado com sucesso");
    }

    public void editar(String usuario, Professor p) {

        lista = (ArrayList<Professor>) lista1().clone();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getNomeUsuario().equalsIgnoreCase(usuario)) {
                p.setNome(lista.get(i).getNome());
                p.setGenero(lista.get(i).getGenero());
                p.setDataNascimento(lista.get(i).getDataNascimento());
                p.setNomeUsuario(lista.get(i).getNomeUsuario());
                p.setSenhaUsuario(lista.get(i).getSenhaUsuario());
                p.setEmail(lista.get(i).getEmail());
                p.setContacto(lista.get(i).getContacto());
                p.setCadeira(lista.get(i).getCadeira());
                p.setNivel(lista.get(i).getNivel());
                p.setNivelAcademico(lista.get(i).getNivelAcademico());
                p.setTurma(lista.get(i).getTurma());
                lista.remove(i);
                lista.add(p);
            }
        }
        escrever(lista);
        JOptionPane.showMessageDialog(null, "Professor Editado com sucesso");
    }

    public ArrayList<Professor> pesquisar(String nome) {

        lista = (ArrayList<Professor>) lista1().clone();
        ArrayList<Professor> lista2 = new ArrayList();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getNome().startsWith(nome)) {

                lista2.add(lista.get(i));
            }
        }
        return lista2;
    }
    
    public void eliminar(String usuario) {

        lista = (ArrayList<Professor>) lista1().clone();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNomeUsuario().equalsIgnoreCase(usuario)) {
                lista.remove(i);
            }

        }

        escrever(lista);
        JOptionPane.showMessageDialog(null, "Professor Eliminado com sucesso");
    }

    public void escrever(ArrayList<Professor> lista) {
        try {
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(fileProf));
            obj.writeObject(lista);
            obj.close();
            System.out.println("Professor Salvo com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getMessage();
        }
    }

    public ArrayList<Professor> lista1() {
        ArrayList<Professor> lista2 = new ArrayList();
        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(fileProf));
            lista2 = (ArrayList<Professor>) obj.readObject();
            obj.close();

        } catch (Exception e) {
            e.getMessage();
        }
        return lista2;

    }
    
    //outos
    
     public boolean usuarioExiste(Professor p) {
        lista = (ArrayList<Professor>) lista1().clone();

        for (int i = 0; i < lista.size(); i++) {
            if (p.getNomeUsuario().equalsIgnoreCase(lista.get(i).getNomeUsuario())) {
                return true;
            }
        }

        return false;
    } //Validacao para que nao haja 2 professoes ou mais com mesmo nome de usuario

}
