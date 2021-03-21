/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Administrador;
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
public class ControlAdministrador {
    String caminho = System.getenv("APPDATA") + File.separator + "Amal Trabalho de PO" +File.separator+"Administrador";
    File directorio = new File(caminho);
    File fileAdmin = new File(caminho + File.separator + "Dados de Administrador.bin");

    ArrayList<Administrador> lista = new ArrayList();
    
    //CRUDE

    public void criar() throws IOException {

        if (!directorio.exists()) {
            directorio.mkdir();
            System.out.println("Directorio criado");
        } else {
            System.out.println("Directorio existe");
        }
        if (!fileAdmin.exists()) {
            fileAdmin.createNewFile();
            System.out.println("file de Administrador criado com sucesso");
            escrever(lista);
        } else {
            System.out.println("ficheiro existe");
        }

    }

    public void registar(Administrador a) {
        lista = (ArrayList<Administrador>) lista1().clone();
        lista.add(a);
        escrever(lista);
        JOptionPane.showMessageDialog(null, "Professor Registado com sucesso");
    }

    public void editar(String usuario, Administrador a) {

        lista = (ArrayList<Administrador>) lista1().clone();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getNomeUsuario().equalsIgnoreCase(usuario)) {
                a.setNome(lista.get(i).getNome());
                a.setGenero(lista.get(i).getGenero());
                a.setDataNascimento(lista.get(i).getDataNascimento());
                a.setNomeUsuario(lista.get(i).getNomeUsuario());
                a.setSenhaUsuario(lista.get(i).getSenhaUsuario());
                a.setEmail(lista.get(i).getEmail());
                a.setContacto(lista.get(i).getContacto());
                lista.remove(i);
                lista.add(a);
            }
        }
        escrever(lista);
        JOptionPane.showMessageDialog(null, "Professor Editado com sucesso");
    }

    public ArrayList<Administrador> pesquisar(String nome) {

        lista = (ArrayList<Administrador>) lista1().clone();
        ArrayList<Administrador> lista2 = new ArrayList();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getNome().startsWith(nome)) {

                lista2.add(lista.get(i));
            }
        }
        return lista2;
    }
    
    public void eliminar(String usuario) {

        lista = (ArrayList<Administrador>) lista1().clone();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNomeUsuario().equalsIgnoreCase(usuario)) {
                lista.remove(i);
            }

        }

        escrever(lista);
        JOptionPane.showMessageDialog(null, "Professor Eliminado com sucesso");
    }

    public void escrever(ArrayList<Administrador> lista) {
        try {
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(fileAdmin));
            obj.writeObject(lista);
            obj.close();
            System.out.println("Professor Salvo com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getMessage();
        }
    }

    public ArrayList<Administrador> lista1() {
        ArrayList<Administrador> lista2 = new ArrayList();
        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(fileAdmin));
            lista2 = (ArrayList<Administrador>) obj.readObject();
            obj.close();

        } catch (Exception e) {
            e.getMessage();
        }
        return lista2;

    }
    
    //outos
    
     public boolean usuarioExiste(Administrador p) {
        lista = (ArrayList<Administrador>) lista1().clone();

        for (int i = 0; i < lista.size(); i++) {
            if (p.getNomeUsuario().equalsIgnoreCase(lista.get(i).getNomeUsuario())) {
                return true;
            }
        }

        return false;
    } //Validacao para que nao haja 2 professoes ou mais com mesmo nome de usuario
}
