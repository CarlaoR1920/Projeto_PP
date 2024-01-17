/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author josep
 */
public class RepositorioDoencas implements Serializable
{

    //Atributos
    ArrayList<String> doencas;

    //Construtor

    /**
     * Método construtor de um RepositorioDoencas.
     */
    public RepositorioDoencas() {
        doencas = new ArrayList<>();
    }

    /**
     *
     * @return ArrayList<String> 
     * Método devolve um Repositorio de doenças
     */
    public ArrayList<String> getDoencas() {
        return doencas;
    }

    /**
     *
     * @param doenca 
     * Método que adiciona doenças ao repositorio de doenças.
     */
    public void adicionarDoencas(String doenca) {
        if (doencas.contains(doenca)) {
            System.out.println("A doença já se encontra no sistema.");
        } else {
            doencas.add(doenca);
        }

    }

    /**
     *
     * @param doenca
     * Método que permite remover doenças do repositorio de doenças.
     */
    public void removerDoencas(String doenca) {
        if (doencas.contains(doenca)) {
            doencas.remove(doenca);

        } else {
            System.out.println("A doenca já não existe no sistema.");
        }
    }

    /**
     *
     * @param doenca
     * @return boolean
     * Método que vai verificar se a doença se encontra no repositorio de doenças.
     */
    public boolean existeDoenca(String doenca) {
        if (doencas.contains(doenca)) {
            return true;
        } else {
            return false;
        }
    }
        
    /**
     * Método que vai percorrer o ArrayList de doenças e fazer print de cada doença.
     */
    public void mostrarDoencas()
    {
        System.out.println("As doenças do utente são: ");
        for(String doenca : doencas)
        {
            System.out.println(doenca);
    }

    }
}
