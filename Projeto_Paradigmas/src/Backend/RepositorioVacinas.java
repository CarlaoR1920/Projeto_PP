/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import Backend.*;
import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author josep
 */
public class RepositorioVacinas implements Serializable
{
    
//Atributos
    private ArrayList<Vacina> vacinas;
    
//Construtor

    /**
     * Método Construtor de uma instância de  RepositorioVacinas.
     */
    public RepositorioVacinas()
            {
                vacinas = new ArrayList<Vacina>();
            }
    
    /**
     *
     * @param vacina
     * Método para adicinar ao ArrayList<Vacina> uma vacina.
     */
    public void adicionarVacinas(Vacina vacina)
    {
        if (!vacinas.contains(vacina))
        {
          vacinas.add(vacina); 
        }
        else
        {
            System.out.println("Esta vacina já existe no centro vacinação.");
        }
    }
    
    /**
     *
     * @param vacina
     * Método para remover ao ArrayList<Vacina> uma vacina.
     */
    public void remover(Vacina vacina)
    {
        if(!vacinas.contains(vacina))
        {
            System.out.println("Esta vacina já não existe no sistema");
        }
        else
        {
            vacinas.remove(vacina);
        }
            
    }
    
    /**
     *
     * @param vacina
     * @return boolean
     * Método que permite verificar se existe vacina no Repositorio de Vacinas.
     */
    public boolean existir(Vacina vacina)
    {
        if(!vacinas.contains(vacina))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
         
    /**
     *
     * @param vacina
     * @return Vacina
     * Método que verifica so repositorio de vacinas contêm a vacina passada como parâmetro , caso exista retorna-a.
     */
    public Vacina getVacina(Vacina vacina)
            {
               if(vacinas.contains(vacina))
               {
                   return vacina;
               }
                else
               {
                   return null;
               }
            }
    
    /**
     *
     * @param nome
     * @return Vacina
     * Método que retorna a vacina com o nome passado nos parametros existente no repositorio de vacinas.
     */
    public Vacina getVacina(String nome) {
        for (Vacina u : vacinas) {
            if (u != null && u.getNome().equals(nome)) {
                return u;
            }
        }
        return null;
    }
    
    /**
     *
     * @return int
     * Método que retorna o tamanho de um ArrayList<Vacina>.
     */
    public int size() {
        return vacinas.size();
    }
    
    /**
     *
     * @return ArrayList<Vacina>.
     * Método que retorna um ArrayList<Vacina> .
     */
    public ArrayList<Vacina> todos() {
        return vacinas;
    }
            
     
  

   /* //verificar se a vacina tem alguma restrição em comum com alguma doença do utente
    private boolean verDoenças(Vacina vacina, Utente utente) 
    {
        return !vacina.doencasRestritas.existeDoenca(utente.getDoencas().toString());
    }

    //verificar se a vacina pode ser administrada consoante a idade
    private boolean verIdadeVacina(Vacina vacina, Utente utente) {
        if (utente.CalcularIdade() >vacina.idadeMinima && utente.CalcularIdade() < vacina.idadeMaxima) {
            return true;
        }
        return false;

    }

    //verificar se o utente já tomou alguma dose
    private boolean verSeExistePrimeiraToma(Utente utente) {
        return utente.getVacina() != null;
    }

    //caso o utente ainda não tenha tomado a vacina, vai verificar os parametros todos

    /**
     *
     * @param utente
     * @return
     */
   /* public Vacina VacinaMelhor(Utente utente) {
        for (Vacina vacina : vacinas) 
        {
            if (verDoenças(vacina, utente) && verIdadeVacina(vacina, utente) && !verSeExistePrimeiraToma(utente)) {
                return vacina;
            }

            if (verSeExistePrimeiraToma(utente)) {
                return utente.getVacina();
            }

        }

        return null;
    }*/
}
    

    
    

