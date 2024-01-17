    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.time.LocalDate;
import java.time.Period;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author josep
 */
public class Utente extends Utilizador implements Serializable {
    //Atributos

    private int numUtente;
    private LocalDate data_nasc;
    private int contacto;
    private RepositorioDoencas doencas;
    private String morada;
    private String localidade;
    private CentroVacinacao centroVac;
    private LocalDate data_adminVac;
    private Vacina vacina;
    private int tomasUtente; //Para garantir que ele toma as vezes necessárias a vacina.

    /**
     * Construtor de uma instância de um Utente
     * @param username corresponde ao nome do Utente
     * @param password corresponde á password do Utente
     * @param nome corresponde ao nome do Utente
     * @param numUtente corresponde ao numero do Utente
     * @param data_nasc corresponde á data de nascimento do Utente
     * @param contacto corresponde ao contacto do utente
     * @param doencas corresponde ás doencas do Utente
     * @param email corresponde ao email do Utente
     * @param morada corresponde á morada do Utente
     * @param localidade corresponde á localidade do Utente
     * @param centroVac corresponde ao centro de vacinção do Utente
     * @param data_adminVac corresponde á data de administração da vacina no Utente
     * @param vacina corresponde á vacina do utente
     */
    public Utente(String username, String password, String nome, int numUtente, LocalDate data_nasc, int contacto, RepositorioDoencas doencas, String email, String morada, String localidade, CentroVacinacao centroVac, LocalDate data_adminVac, Vacina vacina) {
        super(username, password, nome, email);

        this.numUtente = numUtente;
        this.data_nasc = data_nasc;
        this.contacto = contacto;
        this.localidade = localidade;
        this.morada = morada;
        this.centroVac = centroVac;
        this.data_adminVac = data_adminVac;
        this.vacina = vacina;
        tomasUtente = 0;
        this.doencas = doencas;

    }

    /**
     *
     */
    public Utente() {
    }

    //modificadores

    /**
     *
     * @return int que corresponde ao numero de utente.
     */
    public int getNumUtente() {
        return numUtente;
    }

    /**
     *
     * @return LocalDate que corresponde á data de nascimento do utente.
     */
    public LocalDate getData_Nasc() {
        return data_nasc;
    }

    /**
     *
     * @return int que corresponde ao contacto do utente.
     */
    public int getContacto() {
        return contacto;
    }


    /**
     *
     * @return RespositorioDoencas que corresponde a um ArrayList de doencas / conjunto de doenças do utente.
     */
    public RepositorioDoencas getDoencas() {
        return doencas;
    }

    /**
     *
     * @return String que corresponde á morada do utente.
     */
    public String getMorada() {
        return morada;
    }

    /**
     *
     * @return String corresponde á localidade do utente.
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     *
     * @return CentroVacinacao corresponde ao centro de vacinação do utente.
     */
    public CentroVacinacao getCentroVac() {
        return centroVac;
    }

    /**
     * 
     * @return LocalDate que corresponde á data de administração da vacina no utente.
     */
    public LocalDate getData_admin() {
        return data_adminVac;
    }

    /**
     *
     * @return vacina que corresponde á vacina que é dada ao utente.
     */
    public Vacina getVacina() {
        return vacina;
    }

    /**
     *
     * @return int que corresponde ás tomas do utente.
     */
    public int getNumTomas() {
        return tomasUtente;
    }

//Seletores

    /**
     *
     * @param num susbstitui o número do utente.
     */
    public void setNumUtente(int num) {
        numUtente = num;
    }

    /**
     *
     * @param novoContacto substitui o contacto do utente.
     */
    public void setContacto(int novoContacto) {
        contacto = novoContacto;
    }

    /**
     *
     * @param data_nasc substitui a data de nascimento do utente.
     */
    public void setData_nasc(LocalDate novaDataNasc) {
        data_nasc = novaDataNasc;
    }

    /**
     *
     * @param novasDoencas substitui as doencas do utente.
     */
    public void setDoencas(RepositorioDoencas novasDoencas) {
        doencas = novasDoencas;
    }

    /**
     *
     * @param morada substitui a morada do utente.
     */
    public void setMorada(String novaMorada) {
        morada = novaMorada;
    }

    /**
     *
     * @param localidade substitui a localidade do utente.
     */
    public void setLocalidade(String novaLocalidade) {
        localidade = novaLocalidade;
    }

    /**
     *
     * @param novoCentroVac substitui o centro de vacinacao do utente.
     */
    public void setCentroVac(CentroVacinacao novoCentroVac) {
        centroVac = novoCentroVac;
    }

    /**
     *
     * @param data_adminVac substitui a data de administração do utente.
     */
    public void setData_adminVac(LocalDate novaDataAdminVac) {
        data_adminVac = novaDataAdminVac;
    }

    /**
     *
     * @param vacina substitui a vacina do utente.
     */
    public void setVacina(Vacina novaVacina) {
        vacina = novaVacina;
    }

    /**
     *
     * @param tomasUtente substitui as tomas do utente.
     */
    public void setNumTomas(int novasTomasUtente) {
        this.tomasUtente = novasTomasUtente;
    }

    /**
     *
     * @return int que corresponde á idade do utente.
     */
    public int CalcularIdade() {  //calcula a idade através da diferença entre a data de hoje e a data de nascimento
        LocalDate hoje = LocalDate.now();
        int idade = Period.between(data_nasc, hoje).getYears();
        return idade;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Utente{" + "numUtente=" + numUtente + ", data_nasc=" + data_nasc + ", contacto=" + contacto + ", doencas=" + doencas + ", morada=" + morada + ", localidade=" + localidade + ", centroVac=" + centroVac + ", data_adminVac=" + data_adminVac + ", vacina=" + vacina + ", tomasUtente=" + tomasUtente + '}';
    }

}
