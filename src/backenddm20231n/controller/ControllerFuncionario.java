/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Funcionario;
import backenddm20231n.model.dao.DaoFuncionario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class ControllerFuncionario {

    DaoFuncionario daoFun;
    
    public Funcionario inserir(Funcionario funEnt) throws SQLException, ClassNotFoundException {
        daoFun = new DaoFuncionario();
        Funcionario funSaida = daoFun.inserir(funEnt);
        return funSaida;
    }

    public Funcionario alterar(Funcionario funEnt) throws SQLException, ClassNotFoundException {
        daoFun = new DaoFuncionario();
        Funcionario funSaida = daoFun.alterar(funEnt);
        return funSaida;
    }

    public Funcionario buscar(Funcionario funEnt) throws SQLException, ClassNotFoundException {
        daoFun = new DaoFuncionario();
        Funcionario funSaida = daoFun.buscar(funEnt);
        return funSaida;
    }

    public Funcionario excluir(Funcionario funEnt) throws SQLException, ClassNotFoundException {
        daoFun = new DaoFuncionario();
        Funcionario funSaida = daoFun.excluir(funEnt);
        return funSaida;
    }

    public List<Funcionario> listar(Funcionario funEnt) throws SQLException, ClassNotFoundException {
        daoFun = new DaoFuncionario();
        List<Funcionario> listaCliente = daoFun.listar(funEnt);
        return listaCliente;


    }
    
}
