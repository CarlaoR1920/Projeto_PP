/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import java.io.Serializable;
/**
 *
 * @author josep
 */
import java.util.ArrayList;

/**
 *
 * @author josep
 */
public class RepositorioUtentes implements Serializable
{

    private ArrayList<Utente> listaUtentes;

    /**
     * Método construtor de uma instância de um RepositorioUtentes.
     */
    public RepositorioUtentes() {
        listaUtentes = new ArrayList<>();
    }

    /**
     *
     * @return ArrayList<Utente>
     * Método que retorna um ArrayList de Utentes 
     */
    public ArrayList<Utente> getLista() {
        return listaUtentes;
    }

    /**
     *
     * @param lista
     * Método que substitui a listaUtentes pela lista.
     */
    public void setLista(ArrayList<Utente> lista) {
        this.listaUtentes = lista;
    }

    /**
     *
     * @param utente
     * Método que adiciona um utente ao repositorio de utentes.
     */
    public void adicionarUtente(Utente utente) {
        listaUtentes.add(utente);
    }

    /**
     *
     * @param utente
     *  Método que remove um utente do repositorio de utentes.
     */
    public void removerUtente(Utente utente) {

        listaUtentes.remove(utente);

    }

    /**
     *
     * @return Int 
     * Método que retorna o tamanho do ArrayList de Utentes.
     */
    public int getTotalUtentes() {

        return listaUtentes.size();
    }

    /**
     *
     * @param username
     * @return boolean
     * método que verifica se o Utente existe no repositorio de Utentes.
     */
    public boolean existeUtente(String username) {
        for (Utente u : listaUtentes) {
            if (u != null && u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param username
     * @return Utente
     * Método que verifica se o utente existe no repositorio de utentes através do parâmetro username passado na função
     */
    public Utente getUtente(String username) {

        for (Utente u : listaUtentes) {
            if (u != null && u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }
    
    /**
     *
     * @param nSns
     * @return Utente
     * Método que retorna o Utente que existe no repositorio de utentes através do numero de Sns que é passado como parâmetro.
     */
    public Utente getUtente(int nSns)
      {
        for (Utente u : listaUtentes) {
            if (u != null && u.getNumUtente() == nSns) {
                
                return u;
            }
        }
        return null;
    }
    
    /**
     *
     * @param nSns
     * @return boolean
     * Método que verifica se o Utente existe no repositorio de Utentes através do numero de Sns passado como parâmetro.
     */
    public boolean verificarExisteUtente(int nSns)
    {
        for (Utente u : listaUtentes)
        {
            if (u.getNumUtente() == nSns)
            {
                return true;
            }
        
        }
       return false;
}

    /**
     *
     * @param centro
     * @return ArrayList<Utente> 
     * Método que devolve um ArrayList de Utentes onde contêm todos os Utentes do Centro passado como parâmetro. 
     */
    public ArrayList<Utente> utentePorCentro(CentroVacinacao centro) {
        ArrayList<Utente> utentes = new ArrayList<>();
        for (Utente u : listaUtentes) {
            if (u.getCentroVac() == centro) {
               utentes.add(u);
            }

        }
        return utentes;
    }
     
     
}
