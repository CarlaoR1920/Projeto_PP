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
public class ListaEfeitos implements Serializable {

    //atributos
    ArrayList<String> efeitos;

    //construtor

    /**
     * Método contrutor de uma a ListaEfeitos.
     */
    public ListaEfeitos() {
        efeitos = new ArrayList<>();
    }

    //seletores

    /**
     *
     * @return ArrayList
     *  Método que retorna o arrayList de efeitos secundários.
     */
    public ArrayList getEfeitos() {
        return efeitos;
    }

    //modificadores

    /**
     *
     * @param lista que substitui o ArrayList de efeitos por outro.
     */
    public void setEfeitos(ArrayList lista) {
        this.efeitos = lista;
    }

    //metodos

    /**
     *
     * @param efeito 
     * Método que adiciona um efeito ao ArrayList de efeitos.
     */
    public void adicionarEfeito(String efeito) {
        if (efeitos.contains(efeito)) {
            System.out.println("Esse efeito já se encontra na lista");

        } else {
            efeitos.add(efeito);
        }
    }

    /**
     *
     * @param efeito
     * Método que remova um efeito ao ArrayList de efeitos.
     */
    public void removerEfeito(String efeito) {
        if (efeitos.contains(efeito)) {
            efeitos.remove(efeito);

        } else {
            System.out.println("O efeito não se encontra na lista");
        }
    }

    /**
     *
     * @param efeito
     * @return boolean 
     * Método que verifica se o efeito recebido já consta no ArrayList de efeitos.
     */
    public boolean existeEfeito(String efeito) { //ver se nao e necessario if e return true/false
        return efeitos.contains(efeito);
    }

    /**
     *
     * @param i
     * @return String
     * Método que retorna um efeito consoante o parametro recebido que servirá de indice.
     */
    public String getEfeito(int i) {
        return efeitos.get(i);
    }

}
