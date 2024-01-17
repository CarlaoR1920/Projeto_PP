/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author josep
 */
public class Sistema implements Serializable {

    private RepositorioUtilizadores utilizadores;
    private Utilizador utilizadorLigado;
    private repositorioCentroVacinacao centrosVacinacao;
    private RepositorioDoencas doencas;
    private RepositorioGestores gestores;
    private RepositorioUtentes utentes;
    private RepositorioVacinas vacinas;
    private ListaEfeitos listaEfeitos;

    /**
     * Método construtor de uma instância do sistema.
     */
    public Sistema() {
        utilizadores = new RepositorioUtilizadores();
        centrosVacinacao = new repositorioCentroVacinacao();
        doencas = new RepositorioDoencas();
        gestores = new RepositorioGestores();
        utentes = new RepositorioUtentes();
        vacinas = new RepositorioVacinas();
        listaEfeitos = new ListaEfeitos();

    }

    /**
     *
     * @return RepositorioUtilizadores 
     * Método que retorna os utilizadores.
     */
    public RepositorioUtilizadores getListaUtilizadores() {
        return utilizadores;
    }

    /**
     *
     * @return repositorioCentroVacinacao.
     * Método que retorna um Repositorio de centros de vacinacao.
     */
    public repositorioCentroVacinacao getListaCentros() {
        return centrosVacinacao;
    }

    /**
     *
     * @return RepositorioDoencas
     * Método que retorna um repositorio de doencas.
     */
    public RepositorioDoencas getListaDoencas() {
        return doencas;
    }

    /**
     *
     * @return RepositorioGestores
     * Método que retorna um repositorio de gestores.
     */
    public RepositorioGestores getListaGestores() {
        return gestores;
    }

    /**
     *
     * @return RepositorioUtentes
     * Método que returna um repositorio de utentes.
     */
    public RepositorioUtentes getListaUtentes() {
        return utentes;
    }

    /**
     *
     * @return RepositorioVacinas
     * Método que retorna um repositorio de vacinas.
     */
    public RepositorioVacinas getListaVacinas() {
        return vacinas;
    }

    /**
     *
     * @return
     */
    public ListaEfeitos getListaEfeitos() {
        return listaEfeitos;
    }

    /**
     *
     * @param username
     * @param password
     * @return boolean
     * Método responsável por verificar as credenciais do utilizador.
     */
    public boolean autenticarUtilizador(String username, String password) {
        if (utilizadores.existeUtilizador(username)) {
            try {
                Utilizador u = utilizadores.getUtilizador(username);
                if (u.getPassword().equals(password)) {
                    utilizadorLigado = u;
                    return true;
                }
            } catch (Exception e) {
            }
        } else if (utentes.existeUtente(username)) {
            try {
                Utente u = utentes.getUtente(username);
                if (u.getPassword().equals(password)) {
                    utilizadorLigado = u;
                    return true;
                }
            } catch (Exception e) {
            }
        } else if (gestores.existeGestor(username)) {
            try {
                Gestor u = gestores.getGestor(username);
                if (u.getPassword().equals(password)) {
                    utilizadorLigado = u;
                    return true;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    /**
     *
     * @return Utilizador
     * Método que retorna o utilizador conectado ao sistema.
     */
    public Utilizador getUtilizadorLigado() {
        return utilizadorLigado;
    }

    /**
     * Método que inicializa o sistema com determinados objetos.
     */
    public void inicializar() {

        utilizadores.adicionar(new Administrador("admin", "admin", "1234", "Aministrador"));

        Vacina vacina = new Vacina();
        vacina.setNome("AstraZeneca");
        vacina.setCodigo("Astra2");
        vacina.setFabricante("Astrazeneca");
        vacina.setDoseIndividual(150);
        vacina.setTomas(1);
        vacinas.adicionarVacinas(vacina);
        Vacina vac = new Vacina();
        vac.setNome("Pfizer");
        vac.setCodigo("Pfz12");
        vac.setFabricante("Pfizer");
        vac.setDoseIndividual(100);
        vac.setTomas(2);
        vacinas.adicionarVacinas(vac);
        
        Utente u = new Utente();
        u.setNumUtente(123);
        u.setUsername("utente1");
        u.setNome("utente1");
        u.setPassword("1234");
        u.setNumTomas(1);
        u.setVacina(vac);
        
        Utente utente = new Utente();
        utente.setNumUtente(1234);
        utente.setUsername("utente2");
        utente.setPassword("1234");
        utente.setNome("utente2");
        utente.setNumTomas(2);
        utente.setNumUtente(23);
        utente.setVacina(vac);
        utentes.adicionarUtente(utente);
        
        
        Gestor gestor = new Gestor();
        gestor.setUsername("gestor");
        gestor.setPassword("1234");
        gestor.setNome("gestor");
        gestores.adicionarGestor(gestor);
        
        LocalDateTime dataMarcacao = LocalDateTime.of(2021, 06, 05, 10, 15);
        Marcacao marcacaoTemp = new Marcacao();
        marcacaoTemp.agendarMarcacao(dataMarcacao, u);
        
        LocalDateTime data1 = LocalDateTime.of(2021, 9, 03, 10, 15);
        Marcacao marcacao = new Marcacao();
        marcacao.agendarMarcacao(data1, utente);
        
        Stock stock = new Stock();
        stock.criar(vac, 20);
        stock.criar(vacina, 40);
        
        CentroVacinacao centro = new CentroVacinacao();
        centro.setCodigo("1022");
        centro.setMorada("avenida dos Aliados");
        centro.setLocalidade("Vila Verde");
        centro.setNumMaxVacDia(155);
        centro.setNumPostos(10);
        centro.setGestor(gestor);
        centro.setMarcacoes(marcacaoTemp);
     
        

        centro.setStock(stock);
        centrosVacinacao.adicionarCentro(centro);
        u.setCentroVac(centro);
        utente.setCentroVac(centro);
        utentes.adicionarUtente(u);
     
        listaEfeitos.adicionarEfeito("dor de barriga");
        listaEfeitos.adicionarEfeito("dor de estomago");
        Gestor gestor1 = new Gestor();
        gestor1.setUsername("david");
        gestor1.setPassword("1234");
        gestor1.setNome("david");
        gestores.adicionarGestor(gestor1);
        
      

    }

    /**
     * Método que termina o sistema quando invocado.
     */
    public void terminar() {
        System.exit(0);
    }

}
