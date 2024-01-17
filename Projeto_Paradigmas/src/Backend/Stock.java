/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import java.time.LocalDateTime;
import java.util.*;
import java.io.Serializable;


/**
 *
 * @author josep
 */
public class Stock implements Serializable {
    //Atributos
    private Map<Vacina, Integer> stock;
       
       
      //Construtor

    /**
     * Método construtor de uma instacia do Stock.
     */
    public Stock()
    {
       stock = new HashMap<Vacina, Integer>();
    }
       
       
       //Métodos

    /**
     *
     * @param vacina
     * @return int
     * Método que permite obter a quantidade de determinada vacina passada no parametro.
     */
    public int TotalVacinas(Vacina vacina)
    {
        return stock.get(vacina);
    }
    
    /**
     *
     * @param vacina
     * @return int
     * Método que retorna o tamanho do HashMap<Vacina, Integer>.
     */
    public int TipoVacinas(Vacina vacina)
    {
        return stock.size();
    }
    
    /**
     *
     * @param vacina
     * @param quantidade
     * Método que permite criar uma nova entrada no HashMap<Vacina, Integer>.
     */
    public void criar(Vacina vacina, int quantidade)
       {
           stock.put(vacina, quantidade);
       }
       
    /**
     *
     * @param vacina
     * @param quantidade
     * Método que permite conforme as condicões criar uma nova entrada no HashMap<Vacina, Integer> ou adicionar quantidade uma entrada.
     */
    public void Atualizar (Vacina vacina, int quantidade) 
          {

        int  stockatual = stock.get(vacina);
        if (stockatual == 0) {

            stock.put(vacina, quantidade); //se o stock for nulo, stock.put adiciona "quantidade" de vacina ao stock
        } 
        else if (stockatual > 0){
            
            stock.put(vacina, stockatual + quantidade); //caso haja reposição de stock, mas hajam unidades, o stock passará a ser o que havia + quantidade
        }
        
        else{
             throw new IllegalArgumentException("não posso ficar com stock negativo");
         }
       }
       
    /**
     *
     * @param vacina
     * @return boolean
     * Método que permite verificar se existe uma determinada vacina no stock.
     */
    public boolean existe(Vacina vacina)
       {
           return stock.containsKey(vacina);
       }
       
    /**
     *
     * @return ArrayList<Vacina> 
     * Método que permite retornar todas as vacinas existentes no stock (ArrayList<Vacina>).
     */
    public ArrayList<Vacina> todosKeys() {
        ArrayList<Vacina> vacinas = new ArrayList<>();

        for (Vacina vacina : stock.keySet()) {
            vacinas.add(vacina);
        }
        return vacinas;
        
        
}

    /**
     *
     * @return ArrayList<Integer>.
     * Método que permite retornar todas as quantidades de todas as vacinas , ou seja, um ArrayList<Integer> .
     */
    public  ArrayList<Integer>  todosValues() 
    {
        ArrayList<Integer> quantidades = new ArrayList<>();

        for (Vacina vacina : stock.keySet()) {
            quantidades.add(stock.get(vacina));
            
        }
        return quantidades;
    }

    /**
     *
     * @return int
     * Método que retorna o tomanho do stock.
     */
    public int size() {
        return stock.size();
    }

}
          
               
       
       
    
    

