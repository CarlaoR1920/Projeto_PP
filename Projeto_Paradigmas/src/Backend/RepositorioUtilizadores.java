/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import Backend.Utilizador;
import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author josep
 */
public class RepositorioUtilizadores implements Serializable
{
    

    private ArrayList<Utilizador> lista;

    /**
     * Método construtor de uma instância de um repositorio de Utilizadores.
     */
    public RepositorioUtilizadores() 
    {
        lista = new ArrayList<>();
    }

 

    /**
     *
     * @param index
     * @return Utilizador
     * Método que devolve o utilizador em determinado indice que é recebido no parametro.
     */
    public Utilizador get(int index) {
        return lista.get(index);
    }

    /**
     *
     * @return ArrayList<Utilizador>
     * Método que retorna o repositorio de utilizadores
     */
    public ArrayList<Utilizador> getListaUtilizador() {
        return lista;
    }

    /**
     *
     * @param lista
     * Método que substitui o repositorio utilizadores pela lista 
     */
    public void setListaUtilizador(ArrayList<Utilizador> lista) {
        this.lista = lista;
    }

    /**
     *
     * @param utilizador
     * Método que adiciona um utilizador ao repositorio de utilizadores
     */
    public void adicionar(Utilizador utilizador) {
        lista.add(utilizador);
    }

    /**
     *
     * @param utilizador
     * Método que remove um Utilizador do repositorio de Utilizadores
     */
    public void remover(Utilizador utilizador) {
        lista.remove(utilizador);
    }

    /**
     *
     * @return Int
     * Método que retorna o tamanho do ArrayList de Utilizadores
     */
    public int getTotalUtilizador() {
        return lista.size();
    }

    /**
     *
     * @param username
     * @return boolean 
     * Método que verifica se o utilizador existe no repositorio de utilizadores através do username que recebe como parâmetro.
     */
    public boolean existeUtilizador(String username) {
        for (Utilizador u : lista) {
            if (u != null && u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param email
     * @return boolean
     * Método que verifica se existe o email do utilizador através do email que recebe como parâmetro.
     */
    public boolean verificarEmail(String email) {
        for (Utilizador u : lista) {
            if (u != null && u.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param username
     * @return Utilizador 
     * Método que retorna um Utilizador através do username que recebe como parâmetro.
     */
    public Utilizador getUtilizador(String username) {
        for (Utilizador u : lista) {
            if (u != null && u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

   
    public class UtilizadorDuplicadoException extends Exception {

        /**
         *
         */
        public UtilizadorDuplicadoException() { }

        /**
         *
         * @param message
         */
        public UtilizadorDuplicadoException(String message) {
            super(message);
        }
    }
}



