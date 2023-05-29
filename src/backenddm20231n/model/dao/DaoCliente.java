/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.Cliente;
import backenddm20231n.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class DaoCliente {

private final Connection c;
    
    public DaoCliente() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Cliente excluir(Cliente cliEnt) throws SQLException{
        String sql = "delete from cliente WHERE id_cliente = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,cliEnt.getId_cliente());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return cliEnt;
    }
    
    public Cliente buscar(Cliente cliEnt) throws SQLException{
        String sql = "select * from cliente WHERE id_cliente = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,cliEnt.getId_cliente());
            // executa
            ResultSet rs = stmt.executeQuery();
            Cliente cliSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                cliSaida = new Cliente(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return cliSaida;
   }

    public Cliente inserir(Cliente cliEnt) throws SQLException{
        String sql = "insert into cliente" + " (cpf, cupom_desconto)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,cliEnt.getCpf());
        stmt.setString(2,cliEnt.getCupom_desconto());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id_cliente = rs.getInt(1);
            cliEnt.setId_cliente(id_cliente);
        }
        stmt.close();
        return cliEnt;
    }

    public Cliente alterar(Cliente cliEnt) throws SQLException{
        String sql = "UPDATE cliente SET cpf = ?, cupom_desconto = ? WHERE id_cliente = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,cliEnt.getCpf());
        stmt.setString(2,cliEnt.getCupom_desconto());
        stmt.setInt(3,cliEnt.getId_cliente());

        // executa
        stmt.execute();
        stmt.close();
        return cliEnt;
    }

   public List<Cliente> listar(Cliente cliEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Cliente> listaclis = new ArrayList<>();
        
        String sql = "select * from cliente where cpf like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + cliEnt.getCpf() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Cliente cli = new Cliente(
                rs.getInt(1),
                rs.getInt(2),
                rs.getString(3)
            );
            // adiciona o usu à lista de usus
            listaclis.add(cli);
        }
        
        rs.close();
        stmt.close();
        return listaclis;
   
   }

    
}
