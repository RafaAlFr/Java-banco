/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Mercadoria;
import backenddm20231n.model.dao.DaoMercadoria;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class ControllerMercadoria {

    DaoMercadoria daoMer;
    
    public Mercadoria inserir(Mercadoria merEnt) throws SQLException, ClassNotFoundException {
        daoMer = new DaoMercadoria();
        Mercadoria merSaida = daoMer.inserir(merEnt);
        return merSaida;
    }

    public Mercadoria alterar(Mercadoria merEnt) throws SQLException, ClassNotFoundException {
        daoMer = new DaoMercadoria();
        Mercadoria merSaida = daoMer.alterar(merEnt);
        return merSaida;
    }

    public Mercadoria buscar(Mercadoria merEnt) throws SQLException, ClassNotFoundException {
        daoMer = new DaoMercadoria();
        Mercadoria merSaida = daoMer.buscar(merEnt);
        return merSaida;
    }

    public Mercadoria excluir(Mercadoria merEnt) throws SQLException, ClassNotFoundException {
        daoMer = new DaoMercadoria();
        Mercadoria merSaida = daoMer.excluir(merEnt);
        return merSaida;
    }

    public List<Mercadoria> listar(Mercadoria merEnt) throws SQLException, ClassNotFoundException {
        daoMer = new DaoMercadoria();
        List<Mercadoria> listaMercadoria = daoMer.listar(merEnt);
        return listaMercadoria;


    }
    
}
