/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Cliente;
import backenddm20231n.model.dao.DaoCliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class ControllerCliente {

    DaoCliente daoCli;
    
    public Cliente inserir(Cliente cliEnt) throws SQLException, ClassNotFoundException {
        daoCli = new DaoCliente();
        Cliente cliSaida = daoCli.inserir(cliEnt);
        return cliSaida;
    }

    public Cliente alterar(Cliente cliEnt) throws SQLException, ClassNotFoundException {
        daoCli = new DaoCliente();
        Cliente cliSaida = daoCli.alterar(cliEnt);
        return cliSaida;
    }

    public Cliente buscar(Cliente cliEnt) throws SQLException, ClassNotFoundException {
        daoCli = new DaoCliente();
        Cliente cliSaida = daoCli.buscar(cliEnt);
        return cliSaida;
    }

    public Cliente excluir(Cliente cliEnt) throws SQLException, ClassNotFoundException {
        daoCli = new DaoCliente();
        Cliente cliSaida = daoCli.excluir(cliEnt);
        return cliSaida;
    }

    public List<Cliente> listar(Cliente cliEnt) throws SQLException, ClassNotFoundException {
        daoCli = new DaoCliente();
        List<Cliente> listaCliente = daoCli.listar(cliEnt);
        return listaCliente;


    }
    
}
