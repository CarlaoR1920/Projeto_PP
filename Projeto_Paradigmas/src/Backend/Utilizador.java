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
public class Utilizador implements Serializable{
    //Atributos
    private String nome;
    private String username;
    private String password;
    private String email;
    
    
   

    /**
     * Construtor da instância utilizador
     * @param nome corresponde ao nome do utilizador
     * @param username corresponde ao username do utilizador
     * @param password corresponde á password do utilizador 
     * @param email corresponde ao email do password
     */
    public Utilizador(String nome, String username, String password, String email)
    {
        this.nome=nome;
        this.username=username;
        this.password=password;
        this.email=email;
    }
    public Utilizador()
    {
                
    }
    
    //modificadores

    /**
     * 
     * @return String (nome utilizador).
     */
    public String getNome()
    {
        return nome;
    }
    
    /**
     *
     * @return String (username)
     */
    public String getUsername()
    {
        return username;
    }
    
    /**
     *
     * @return String (password)
     */
    public String getPassword()
    {
        return password;
    }

    /**
     *
     * @return String (Email)
     */
    public String getEmail() 
    {
        
        return email;
    }
    
    
    //Seletores

    /**
     *
     * @param novoNome substituição do nome do utilizador
     */
    public void setNome(String novoNome)
    {
        nome= novoNome;
    }
    
    /**
     *
     * @param novoUsername sustitui o username do utilizador pelo novoUsername
     */
    public void setUsername(String novoUsername)
    {
        username = novoUsername;
    }
    
    /**
     *
     * @param novaPass sustitui a password do utilizador pela novaPass
     */
    public void setPassword(String novaPass)
    {
        password= novaPass;
    }

    /**
     *
     * @param email substitui o email do utilizador pelo novoaEmail do utilizador
     */
    public void setEmail(String novoEmail) {
        this.email = novoEmail;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Utilizador{" + "nome=" + nome + ", username=" + username + ", password=" + password + ", email=" + email + '}';
    }
    
    
}

