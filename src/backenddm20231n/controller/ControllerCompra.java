/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Compra;
import backenddm20231n.model.dao.DaoCompra;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class ControllerCompra {

    DaoCompra daoCom;
    
    public Compra inserir(Compra comEnt) throws SQLException, ClassNotFoundException {
        daoCom = new DaoCompra();
        Compra comSaida = daoCom.inserir(comEnt);
        return comSaida;
    }

    public Compra alterar(Compra comEnt) throws SQLException, ClassNotFoundException {
        daoCom = new DaoCompra();
        Compra comSaida = daoCom.alterar(comEnt);
        return comSaida;
    }

    public Compra buscar(Compra comEnt) throws SQLException, ClassNotFoundException {
        daoCom = new DaoCompra();
        Compra comSaida = daoCom.buscar(comEnt);
        return comSaida;
    }

    public Compra excluir(Compra comEnt) throws SQLException, ClassNotFoundException {
        daoCom = new DaoCompra();
        Compra comSaida = daoCom.excluir(comEnt);
        return comSaida;
    }

    public List<Compra> listar(Compra comEnt) throws SQLException, ClassNotFoundException {
        daoCom = new DaoCompra();
        List<Compra> listaCompra = daoCom.listar(comEnt);
        return listaCompra;


    }
    
}
