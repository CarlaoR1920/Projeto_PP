/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.io.Serializable;

import Backend.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.swing.RowFilter.Entry;

/**
 *
 * @author josep
 */
public class Marcacao implements Serializable {

    //ATRIBUTOS
    private HashMap<LocalDateTime, ArrayList<Utente>> marcacoes;

    //Construtor

    /**
     * Método construtor de uma instância da Marcacao.
     */
    public Marcacao() {
        marcacoes = new HashMap<>();
    }

    /**
     *
     * @param data corresponde á data que pretende agendar.
     * @param utente corresponde ao respetivo utente que pretende agendar para determinada data.
     * Método que verifica se exite o ArrayList de utentes para aquela data é nulo, caso seja, criamos um novo ArrayList e adicionamos o utente,e por fim,
     * adicionamos ao HashMap a data e o determinado utente que está guardado no ArrayList para aquela data.
     */
    public void agendarMarcacao(LocalDateTime data, Utente utente) {
        ArrayList<Utente> agendamentos = marcacoes.get(data);
        if (agendamentos == null) {
            agendamentos = new ArrayList<>();
            agendamentos.add(utente);
            marcacoes.put(data, agendamentos);

        /*} else if (!agendamentos.contains(utente)) {
            agendamentos.add(utente);

        }*/
    }
    }

    /**
     *
     * @param data corresponde á data que se pretende cancelar.
     * Método que permite cancelar uma marcação para determinada data , isto é verifica se o HashMap marcacações é diferente de nulo e se nas marcações
     * já consta esta data, caso isto aconteça, remove a marcação do utente.
     */
    public void cancelarMarcacao(LocalDateTime data) {
        if (marcacoes != null && marcacoes.containsKey(data)) {
            marcacoes.remove(data);
        }

    }

    //Dá a lista de utentes com marcação em determinada data.

    /**
     *
     * @param data corresponde á data de marcação de um determinado utente. 
     * @return ArrayList<Utente>
     * Método que permite verificar o utente que contêm marcação para aquela data e hora.
     */
    public ArrayList<Utente> obterMarcacoesPorDia(LocalDateTime data) {
        return marcacoes.get(data);
    }

   



    /**
     *
     * @param data
     * @return boolean
     * Método que permite verificar se já existe marcação para aquela data e hora.
     */
    public boolean verificarMarcacao(LocalDateTime data) {
        return marcacoes.containsKey(data);
    }

    /**
     *
     * @param utente
     * @return boolean.
     * Método que permite verificar se existe determinado utente no HashMap marcações.
     */
    public boolean verificarMarcacaoUtente(Utente utente) {
        return marcacoes.containsValue(utente);
    }

   
    /**
     *
     * @return HashMap<LocalDateTime, ArrayList<Utente>>
     * Método que retorna o HashMap marcações.
     */
    public HashMap<LocalDateTime, ArrayList<Utente>> getMarcacoes() {
        return marcacoes;
    }

    /**
     *
     * @param u
     * @return LocalDateTime
     * 
     */
    public LocalDateTime getHoraUtente(ArrayList<Utente> u) {
        for (Map.Entry<LocalDateTime, ArrayList<Utente>> e : marcacoes.entrySet()) {
            if (e.getValue().equals(u)) {
                return e.getKey();
            }
        }
        return null;

    }

    /**
     *
     * @return ArrayList<LocalDateTime>;
     * Método que permite obter o conjunto de todos os horarios / ArrayList<LocalDateTime>  de todas as marcações dos utentes.
     */
    public ArrayList<LocalDateTime> todosKeys() {
        ArrayList<LocalDateTime> hora = new ArrayList<>();

        for (LocalDateTime horario : marcacoes.keySet()) {
            hora.add(horario);
        }
        return hora;
    }

    /**
     *
     * @return ArrayList<Utente> 
     * Método que permite obter ArrayList<Utente> que têm marcação, ou seja, que contêm um horário.
     */
    public ArrayList<Utente> todosValues() {
        ArrayList<Utente> utente = new ArrayList<Utente>();

        for (LocalDateTime hora : marcacoes.keySet()) {
            ArrayList<Utente> utentes = marcacoes.get(hora);
            for (Utente u : utentes) {
                utente.add(u);
            }
        }
        return utente;
    }

    /**
     *
     * @return int
     * Método que permite obter a tamanho do HashMap marcacoes.
     */
    public int size() {
        return marcacoes.size();
    }

    /**
     *
     * @return ArrayList<LocalDateTime>
     * Método que permite obter o ArrayList<LocalDateTime> , ou seja, todos os horarios de marcação para amanhã.
     * 
     */
    public ArrayList<LocalDateTime> todosKeysTomorrow() {
        ArrayList<LocalDateTime> datas = new ArrayList<>();

        LocalDateTime hoje = LocalDateTime.now();
        LocalDateTime amanha = hoje.plusDays(1);
        for (LocalDateTime agenda : marcacoes.keySet()) {
            LocalDate dia = agenda.toLocalDate();
            LocalDate amanhaData = amanha.toLocalDate();
            if (dia.isEqual(amanhaData)) {
                datas.add(agenda);
            }
        }
        return datas;
    }

    /**
     *
     * @return ArrayList<Utente>
     * Método que permite obter todos os utentes com marcação para amanhã.
     */
    public ArrayList<Utente> todosValuesTomorrow() {
        ArrayList<Utente> utente = new ArrayList<>();
        LocalDateTime hoje = LocalDateTime.now();
        LocalDateTime amanha = hoje.plusDays(1);

        for (LocalDateTime hora : marcacoes.keySet()) {
            LocalDate dia = hora.toLocalDate();
            LocalDate amanhaData = amanha.toLocalDate();
            if (dia.isEqual(amanhaData)) {
                ArrayList<Utente> utentes = marcacoes.get(hora);
                for (Utente u : utentes) {
                    utente.add(u);
                }
            }
        }
        return utente;
    }
    
    /**
     *
     * @return ArrayList<LocalDateTime>.
     * Método que permite obter todos os horários de utentes com marcação , a qual não compareceram.
     */
    public ArrayList<LocalDateTime> todosKeysFaltaram()
{
    ArrayList<LocalDateTime> hora = new ArrayList<>();
     LocalDateTime hoje = LocalDateTime.now();

        for (LocalDateTime horario : marcacoes.keySet()) {
            if(horario.isBefore(hoje))
            {
                hora.add(horario);
            }
        }
           return hora; 
        }

    /**
     *
     * @return ArrayList<Utente>
     * Método que permite obter todos os utentes com marcação , a qual não compareceram.
     */
    public ArrayList<Utente> todosValuesFaltaram() {
        ArrayList<Utente> utente = new ArrayList<Utente>();
        LocalDateTime hoje = LocalDateTime.now();
         for (LocalDateTime hora : marcacoes.keySet()) {
            if (hora.isBefore(hoje))
            {
            ArrayList<Utente> utentes = marcacoes.get(hora);
            for (Utente u : utentes) {
                utente.add(u);
            }
        }
       
    }
    return utente;    
}
 
}





       