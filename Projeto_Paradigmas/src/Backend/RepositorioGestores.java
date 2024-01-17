/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import Backend.Gestor;
import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author josep
 */






public class RepositorioGestores implements Serializable
{
    
    private ArrayList<Gestor> listaGestores;

    /**
     * Método construtor de uma instancia de um Repositorio de Gestores.
     */
    public RepositorioGestores() {
        listaGestores = new ArrayList<>();
                
    }
    
   

   

    /**
     *
     * @param lista
     * Método que substitui um ArrayList<Gestor> por outro.
     */
    public void setLista(ArrayList<Gestor> lista) {
        listaGestores = lista;
    }

    /**
     *
     * @param gestor
     * Método que adciona um gestor ao ArrayList<Gestor>.
     */
    public void adicionarGestor(Gestor gestor){
        listaGestores.add(gestor);
    }

    /**
     *
     * @param gestor
     * Método que remove um gestor ao ArrayList<Gestor>.
     */
    public void removerGestor(Gestor gestor){
         listaGestores.remove(gestor);

    }

    /**
     *
     * @return int
     * Método que retorna o tamanho de um ArrayList<Gestor>.
     */
    public int getTotalGestores(){

         return listaGestores.size();
     }

    /**
     *
     * @param username
     * @return boolean
     * Método que verifica se existe gestor no repositorio de gestores com o mesmo username passado no parametro.
     */
    public boolean existeGestor(String username) {
        for (Gestor u : listaGestores) {
            if (u != null && u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     *
     * @param nome
     * @return boolean
     *  Método que verifica se existe gestor no repositorio de gestores com o mesmo nome passado no parametro.
     */
    public boolean existeGestorNome(String nome) {
        for (Gestor u : listaGestores) {
            if (u != null && u.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param username
     * @return Gestor
     * Método que verifica se existe gestor no repositorio de gestores com o mesmo username passado no parametro e retorna o gestor.
     */
    public Gestor getGestor(String username) {

        for (Gestor u : listaGestores) {
            if (u != null && u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    /**
     *
     * @param nome
     * @return Gestor
     * Método que verifica se existe gestor no repositorio de gestores com o mesmo nome passado no parametro e retorna o gestor.
     */
    public Gestor getGestorNome(String nome) {

        for (Gestor u : listaGestores) {
            if (u != null && u.getNome().equals(nome)) {
                return u;
            }
        }
        return null;
    }
    
    /**
     *
     */
    public class GestorNaoExistenteException extends Exception {

        /**
         *
         */
        public GestorNaoExistenteException() { }

        /**
         *
         * @param message
         */
        public GestorNaoExistenteException(String message) {
            super(message);
        }
    }
    
    /**
     *
     * @return int
     * Método que retorna o tamanho de um repositorio de gestores.
     */
    public int size() {
        return listaGestores.size();
    }

    /**
     *
     * @return ArrayList<Gestor>
     * Método que retorna um ArrayList<Gestor>.
     */
    public ArrayList<Gestor> todos() {
        return listaGestores;
    }
}



    

