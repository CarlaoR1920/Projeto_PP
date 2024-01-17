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
public class Gestor extends Utilizador implements Serializable 
{

    //construtor

    /**
     * Método construtor de uma instância de Gestor
     * @param nome corresponde ao nome do Gestor.
     * @param username corresponde ao username do Gestor.
     * @param password corresponde à password do Gestor.
     * @param email corresponde ao email do Gestor.
     */
    public Gestor(String nome, String username, String password, String email) {
        super(nome, username, password, email);
    }

    /**
     * Alternatica de método construtor de uma instância de Gestor.
     */
    public Gestor() {

    }
}
