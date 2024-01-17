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
public class Administrador extends Utilizador implements Serializable
{
    

	
	
	

    /**
     * Construtor de uma instância Administrador
     * @param nome corresponde ao nome do administrador
     * @param username corresponde username do administrador
     * @param password corresponde á password do administrador
     * @param email corresponde ao email do administrador
     */
	public Administrador(String nome, String username, String password, String email)
        {
            super (nome, username, password, email);
        }
}

	
