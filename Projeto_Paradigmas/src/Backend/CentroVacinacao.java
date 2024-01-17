/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Backend.*;
import java.time.LocalDate;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author josep
 */
public class CentroVacinacao implements Serializable {
    //Atributos

    private String codigo;
    private int numPostos;
    private String morada;
    private String localidade;
    private Stock stock;
    private Marcacao marcacoes;
    private int numMaxVacDia;
    private Gestor gestor;
    private RepositorioVacinas vacinas; //Tipos de vacinas
    private ListaEfeitos listaEfeitos;

    //Construtor

    /**
     *
     * @param codigo
     * @param numPostos
     * @param localidade
     * @param morada
     * @param numMaxVacDia
     * @param gestor
     * @param vacinas
     * @param numVacDia
     * @param marcacoes
     * @param listaEfeitos
     */
    public void CentroVacinacao(String codigo, int numPostos, String localidade, String morada, int numMaxVacDia, Gestor gestor, RepositorioVacinas vacinas, int numVacDia, Marcacao marcacoes, ListaEfeitos listaEfeitos) {

        this.codigo = codigo;
        this.numPostos = numPostos;
        this.localidade = localidade;
        this.morada = morada;
        this.numMaxVacDia = numMaxVacDia;
        this.gestor = gestor;
        this.vacinas = vacinas;
        this.marcacoes = marcacoes;
        this.listaEfeitos = listaEfeitos;

    }
//modificadores

    /**
     *
     * @return String
     * O método devolve o código do centro de vacinação 
     */
    public String getCodigo() {
        return codigo;

    }

    /**
     *
     * @return Int
     * O método devolve o número de postos de um Centro
     */
    public int getNumPostos() {
        return numPostos;
    }

    /**
     *
     * @return String 
     * O método devolve a localidade do Centro de Vacinação
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     *
     * @return String
     * O método devolve a morada do Centro de Vacinação
     */
    public String getMorada() {
        return morada;

    }

    /**
     *
     * @return Int
     * O método devolve o número máximo de vacinas administradas por dia
     */
    public int getNumMaxVacDia() {
        return numMaxVacDia;
    }

    /**
     *
     * @return Gestor
     * O método devolve o gestor do Centro de vacinação
     */
    public Gestor getGestor() {
        return gestor;
    }

    /**
     *
     * @return Stock
     * O método devolve um HashMap das vacinas com as suas respetivas quantidades no centro de vacinação
     */
    public Stock getStock() {
        return stock;
    }

    /**
     *
     * @return Marcação 
     * O método devolve todas as marcações para este centro
     */
    public Marcacao getMarcacoes() {
        return marcacoes;
    }

    /**
     *
     * @return repositorioVacinas 
     * O método vai devolver as vacinas existentes no centro de vacinação
     */
    public RepositorioVacinas getVacinas() {
        return vacinas;
    }
    
    /**
     *
     * @return ListaEfeitos 
     * O método devolve todos os efeitos que foram registados após os utentes serem vacinados no respetivo centro de vacinação
     */
    public ListaEfeitos getListaEfeitos()
    {
        return listaEfeitos;
    }

//Seletores

    /**
     *
     * @param novoCodigo
     * substitui o código do centro de vacinação pelo novoCodigo 
     */
    public void setCodigo(String novoCodigo) {
        codigo = novoCodigo;
    }

    /**
     *
     * @param novoNumPostos
     * Substitui o numero de postos do Centro pelo novoNumpostos
     */
    public void setNumPostos(int novoNumPostos) {
        numPostos = novoNumPostos;
    }

    /**
     *
     * @param novaLocalidade
     * Substitui a localidade do Centro pela novaLocalidade
     */
    public void setLocalidade(String novaLocalidade) {
        localidade = novaLocalidade;
    }

    /**
     *
     * @param novaMorada
     * Substitui a morada do centro pela novaMorada
     */
    public void setMorada(String novaMorada) {
        morada = novaMorada;
    }

    /**
     *
     * @param novaNumMaxVacDia
     * Substitui o numero maximo de vacinas por dia de um centro pelo novaNumMaxVacDia
     */
    public void setNumMaxVacDia(int novaNumMaxVacDia) {
        numMaxVacDia = novaNumMaxVacDia;
    }

    /**
     *
     * @param novoGestor
     * Substitui o gestor do Centro pelo novoGestor
     */
    public void setGestor(Gestor novoGestor) {
        gestor = novoGestor;
    }

    /**
     *
     * @param stock
     * Substitui o stock do centro pelo stock
     */
    public void setStock(Stock stock) {
        this.stock = stock;
    }

    /**
     *
     * @param marcacoes
     * Substitui as marcações do centro pelas marcacoes
     */
    public void setMarcacoes(Marcacao marcacoes) {
        this.marcacoes = marcacoes;
    }

    /**
     *
     * @param vacinas
     * Substitui as vacinas do Centro pelas vacinas
     */
    public void setVacinas(RepositorioVacinas vacinas) {
        this.vacinas = vacinas;
    }

    /**
     *
     * @param listaEfeitos
     * Substitui a lista de efeitos do centro pela listaEfeitos
     */
    public void setListaEfeitos(ListaEfeitos listaEfeitos)
    {
       this.listaEfeitos = listaEfeitos; 
    }

  
    }



