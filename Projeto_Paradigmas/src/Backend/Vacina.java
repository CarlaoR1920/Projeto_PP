/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;
import Backend.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.io.Serializable;

/**
 *
 * @author josep
 */
    
public class Vacina implements Serializable{

    private String nome;
    private String codigo;
    private String fabricante;
    private double doseIndividual;
    private int tomas;
    private int idadeMinima;
    private  int idadeMaxima;
    private ListaEfeitos listaEfeitos;
    private RepositorioDoencas doencasRestritas;
    
    
   /**
     * Método construtor de uma instância da vacina.
     * @param nome corresponde ao nome da vacina.
     * @param codigo corresponde ao código da vacina.
     * @param fabricante corresponde ao fabricante da vacina.
     * @param doseIndividual corresponde á dose de cada vacina.
     * @param tomas  corresponde ao numero de tomas necessárias da vacina.
     * @param idadeMinima corresponde á idade minima do utente para poder tomar a vacina.
     * @param idadeMaxima corresponde á idade minima do utente para poder tomar a vacina.
     * @param listaEfeitos  corresponde á lista de efeitos secundários da vacina.
     * @param doençasRestritas corresponde ás doenças restritas da vacina.
     */
    public Vacina(String nome, String codigo, String fabricante, double doseIndividual, int tomas, int idadeMinima, int idadeMaxima, ListaEfeitos listaEfeitos, RepositorioDoencas doençasRestritas ) {
        this.nome = nome;
        this.codigo = codigo;
        this.fabricante = fabricante;
        this.doseIndividual = doseIndividual;
        this.tomas = tomas;
        this.idadeMinima = idadeMinima;
        this.idadeMaxima = idadeMaxima;
        this.listaEfeitos = listaEfeitos;
        this.doencasRestritas = doençasRestritas;
    }
    
    /**
     * Alternativa de Método construtor de uma instância da vacina.
     */
    public Vacina()
    {
        
    }   
    
    
    
    /**
     *
     * @return String
     * Método que retorna o nome da vacina.
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return String
     * Método que retorna o código da vacina.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @return String
     * Método que retorna o fabricante da vacina.
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     *
     * @return double
     * Método que retorna a doseindividual da vacina.
     */
    public double getDoseIndividual() {
        return doseIndividual;
    }

    /**
     *
     * @return int
     * Método que retorna as tomas da vacina.
     */
    public int getTomas() {
        return tomas;
    }

    /**
     *
     * @return int
     * Método que retorna a idade Mínima que é necessária para tomar a vacina.
     */
    public int getLimiteMinimo() {
        return idadeMinima;
    }

    /**
     *
     * @return int
     * Método que retorna a idade máxima que perimte tomar a vacina
     */
    public int getLimiteMaximo() {
        return idadeMaxima;
    }

    /**
     *
     * @return ListaEfeitos
     * Método que retorna a lista de efeitos secundários após a toma de uma vacina
     */
    public ListaEfeitos getEfeitosSecundarios() {
        return listaEfeitos;
    }

    /**
     *
     * @return RepositorioDoenças
     * Método que retorna a lista de doenças restritas de uma vacina
     */
    public RepositorioDoencas getDoençasRestritas() {
        return doencasRestritas;
    }
    
    /**
     *
     * @param nome
     * Método que substitui o nome da vacina pelo nome.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param codigo
     * Método que substitui o código da vacina pelo código.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @param fabricante
     * Método que substitui o fabricante da vacina pelo fabricante.
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     *
     * @param doseIndividual
     * Método que substitui a dose individual da vacina pela doseIndividual.
     */
    public void setDoseIndividual(double doseIndividual) {
        this.doseIndividual = doseIndividual;
    }

    /**
     *
     * @param tomas
     * Método que substitui as tomas da vacina pelas tomas.
     */
    public void setTomas(int tomas) 
    {
        this.tomas = tomas;
        
    }   

    /**
     *
     * @param idadeMinima
     * Método que substitui a idade mínima da vacina pela idadeMinima.
     */
    public void setIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    /**
     *
     * @param idadeMaxima
     * Método que substitui a idade máxima de uma vacina pela idadeMáxima.
     */
    public void setIdadeMaxima(int idadeMaxima) {
        this.idadeMaxima = idadeMaxima;
    }

    /**
     *
     * @param efeitosSecundarios
     * Método que substitui a lista dos efeitos secundários pelos efeitosSecundários.
     */
    public void setEfeitosSecundarios(ListaEfeitos efeitosSecundarios) {
        this.listaEfeitos = efeitosSecundarios;
    }

    /**
     *
     * @param doencasRestritas
     * Método que substitui as doenças restritas da vacina pelas doençasRestritas.
     */
    public void setDoencasRestritas(RepositorioDoencas doencasRestritas) {
        this.doencasRestritas = doencasRestritas;
    }
    
    
 
      
   
    }