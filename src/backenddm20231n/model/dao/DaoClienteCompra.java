/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.ClienteCompra;
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
 * @author Rafael
 */
public class DaoClienteCompra {
    private final Connection c;
    
    public DaoClienteCompra() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public ClienteCompra excluir(ClienteCompra clicomEnt) throws SQLException{
        String sql = "delete from clientecompra WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,clicomEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return clicomEnt;
    }
    
    public ClienteCompra buscar(ClienteCompra clicomEnt) throws SQLException{
        String sql = "select * from clientecompra WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,clicomEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            ClienteCompra clicomSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                clicomSaida = new ClienteCompra(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return clicomSaida;
   }

    public ClienteCompra inserir(ClienteCompra clicomEnt) throws SQLException{
        String sql = "insert into clientecompra" + " (idCliente, idCompra, observacao)" + " values (?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,clicomEnt.getIdCliente());
        stmt.setInt(2,clicomEnt.getIdCompra());
        stmt.setString(3,clicomEnt.getObservacao());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            clicomEnt.setId(id);
        }
        stmt.close();
        return clicomEnt;
    }

    public ClienteCompra alterar(ClienteCompra clicomEnt) throws SQLException{
        String sql = "UPDATE clientecompra SET idCliente = ?, idCompra = ?, observacao = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,clicomEnt.getIdCliente());
        stmt.setInt(2,clicomEnt.getIdCompra());
        stmt.setString(3,clicomEnt.getObservacao());
        stmt.setInt(4,clicomEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return clicomEnt;
    }

   public List<ClienteCompra> listar(ClienteCompra clicomEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<ClienteCompra> peslogs = new ArrayList<>();
        
        String sql = "select * from clientecompra where observacao like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + clicomEnt.getObservacao()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            ClienteCompra peslog = new ClienteCompra(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4));
            // adiciona o usu à lista de usus
            peslogs.add(peslog);
        }
        
        rs.close();
        stmt.close();
        return peslogs;
   
   }

}
