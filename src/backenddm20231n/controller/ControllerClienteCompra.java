/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Cliente;
import backenddm20231n.model.bean.Compra;
import backenddm20231n.model.bean.ClienteCompra;
import backenddm20231n.model.dao.DaoClienteCompra;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Rafael
 */
public class ControllerClienteCompra {
    
    ControllerCliente contCli;
    ControllerCompra contCom;
    DaoClienteCompra daoClicom;
    
    public ClienteCompra inserir(ClienteCompra clicomEnt) throws SQLException, ClassNotFoundException {
        daoClicom = new DaoClienteCompra();
        clicomEnt = daoClicom.inserir(clicomEnt);
        return clicomEnt;
    }

    public ClienteCompra alterar(ClienteCompra clicomEnt) throws SQLException, ClassNotFoundException {
        daoClicom = new DaoClienteCompra();
        clicomEnt = daoClicom.alterar(clicomEnt);
        return clicomEnt;
    }

    public List<ClienteCompra> listar(ClienteCompra clicomEnt) throws SQLException, ClassNotFoundException {
        daoClicom = new DaoClienteCompra();
        List<ClienteCompra> listaclicomRetornoAux = daoClicom.listar(clicomEnt);
        List<ClienteCompra> listaclicomRetorno = new ArrayList<>();
               
        for(ClienteCompra clicom : listaclicomRetornoAux) {        
            listaclicomRetorno.add(buscar(clicom));
        }

        return listaclicomRetorno;
    }

    public ClienteCompra excluir(ClienteCompra clicomEnt) throws SQLException, ClassNotFoundException {
        daoClicom = new DaoClienteCompra();
        clicomEnt = daoClicom.excluir(clicomEnt);
        return clicomEnt;
    }

    public ClienteCompra buscar(ClienteCompra clicomEnt) throws SQLException, ClassNotFoundException {

        daoClicom = new DaoClienteCompra();
        ClienteCompra clicomSaida = daoClicom.buscar(clicomEnt);

        Cliente cliEnt = new Cliente(clicomSaida.getIdCliente());
        contCli = new ControllerCliente();
        clicomSaida.setCli(contCli.buscar(cliEnt));
        
        Compra com = new Compra(clicomSaida.getIdCompra());
        contCom = new ControllerCompra();
        clicomSaida.setCom(contCom.buscar(com));

        return clicomSaida;
    }
   
}
