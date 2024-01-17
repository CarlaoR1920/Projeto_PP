/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.Administrador;
import Backend.CentroVacinacao;
import Backend.Gestor;
import Backend.repositorioCentroVacinacao;
import Backend.RepositorioDoencas;
import Backend.RepositorioUtilizadores;
import Backend.Utente;
import Backend.Sistema;
import Backend.Utilizador;
import Serializacao.Serializacao;
import java.time.LocalDate;

/**
 *
 * @author josep
 */
public class Piloto {

    public static void main(String[] args) {
        Sistema sistema;
        String ficheiroDados = String.format("%s\\utilizadores.data", System.getProperty("user.dir"));
        System.out.println(String.format("Ficheiro de dados: %s.", ficheiroDados));
        Serializacao serializacao = new Serializacao(ficheiroDados);

        if (!serializacao.getFicheiro().exists()) {
            //Cria uma instancia do sistema
            sistema = new Sistema();
            sistema.inicializar();

        } else {
            sistema = serializacao.carregar();
        }

        //Uma vez que a JanelaLogin é modal, este método irá bloquear até que a janela seja fechada.
        //A janela só fecha quando os dados de login são válidos.                
        janelaLogin login = new janelaLogin(sistema, serializacao);
        login.setVisible(true);
    }
}
