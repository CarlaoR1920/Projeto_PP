/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.HashMap;
import Backend.*;
import java.util.ArrayList;
import Backend.Gestor;
import Backend.CentroVacinacao;
import java.io.Serializable;

/**
 *
 * @author josep
 */
public class repositorioCentroVacinacao implements Serializable {

    //Atributos
    HashMap<String, CentroVacinacao> centros;

    /**
     * Método construtor de uma instância de um repositorioCentroVacinacao.
     */
    public repositorioCentroVacinacao() {
        centros = new HashMap<>();

    }

    /**
     *
     * @param centro
     * Método que permite adicionar ao repositorioCentroVacinacao o centro que é passado como parâmetro.
     */
    public void adicionarCentro(CentroVacinacao centro) {
        String codigoCentro = centro.getCodigo();
        CentroVacinacao centroVac = centros.get(codigoCentro);
        if (centroVac == null) // se não houver neste centro de vac neste cod. fazemos isto.
        {
            centros.put(codigoCentro, centro);
        } else {
            System.out.println("Este centro já existe no sistema");
        }
    }

    /**
     *
     * @param centro
     * Método que permite remover no repositorioCentroVacinacao o centro que é passado como parâmetro.
     */
    public void remover(CentroVacinacao centro) {

        if (centros.containsValue(centro)) {
            centros.remove(centro);
        } else {
            System.out.println("Este centro não existe no sistema");
        }
    }
    
    /**
     *
     * @param centro
     * @return boolean
     * Método que verifica se o centro que é passado como parâmetro existe
     */
    public boolean existir(CentroVacinacao centro) {
        String codigoCentro = centro.getCodigo();
        return centros.containsKey(codigoCentro);

    }
    
    /**
     *
     * @param gestor
     * @return CentroVacinacao
     * Método que retorna o centro de vacinacao do gestor que é passado como parâmetro 
     */
    public CentroVacinacao procurarCentro(Gestor gestor)
    {
        ArrayList<CentroVacinacao> centroVac = new ArrayList<>();
        for (CentroVacinacao center : centros.values())
        {
            centroVac.add(center);
        }
        for (CentroVacinacao centro : centroVac)
        {
            if (centro.getGestor() == null)
            {
                return null;
            }
            if (centro.getGestor().equals(gestor))
                return centro;
        }
       return null;
    }

    /**
     *
     * @return int 
     * Método que retorna o tamanho do  HashMap<String, CentroVacinacao> 
     */
    public int size() {
        return centros.size();
    }

    /**
     *
     * @return ArrayList<CentroVacinacao>
     * Método que retorna um ArrayList com todos os centros de vacinacao que estão no repositorioCentroVacinacao.
     */
    public ArrayList<CentroVacinacao> todos() {
        return new ArrayList<>(centros.values());
    }
     
    /**
     *
     * @param codigo
     * Método que permite remover um centro do repositorioCentroVacincao.
     */
    public void removerCentros(String codigo){
        centros.remove(codigo);
    }

    /**
     *
     */
    public class CentroNaoExistenteException extends Exception {

        /**
         *
         */
        public CentroNaoExistenteException() { }

        /**
         *
         * @param message
         */
        public CentroNaoExistenteException(String message) {
            super(message);
        }
    }

    /**
     *
     */
    public class CentroDuplicadoException extends Exception {

        /**
         *
         */
        public CentroDuplicadoException() { }

        /**
         *
         * @param message
         */
        public CentroDuplicadoException(String message) {
            super(message);
        }
    }
    
    /**
     *
     * @param codigo
     * @return CentroVacincao
     * @throws CentroNaoExistenteException
     * Método que permite obter o centro de vacinacao do repositorioCentroVacinacao através do codigo que é passado como parâmetro.
     */
    public CentroVacinacao getCentro(String codigo) throws CentroNaoExistenteException {
      if (centros.containsKey(codigo)){
       return centros.get(codigo);
      }else{
          throw new CentroNaoExistenteException("O Centro já existe na lista");
        }
    }
}

