/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.Mercadoria;
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
public class DaoMercadoria {

private final Connection c;
    
    public DaoMercadoria() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Mercadoria excluir(Mercadoria merEnt) throws SQLException{
        String sql = "delete from mercadorias WHERE id_mercadoria = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,merEnt.getId_mercadoria());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return merEnt;
    }
    
    public Mercadoria buscar(Mercadoria merEnt) throws SQLException{
        String sql = "select * from mercadorias WHERE id_mercadoria = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,merEnt.getId_mercadoria());
            // executa
            ResultSet rs = stmt.executeQuery();
            Mercadoria merSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                merSaida = new Mercadoria(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return merSaida;
   }

    public Mercadoria inserir(Mercadoria mererEnt) throws SQLException{
        String sql = "insert into mercadorias" + " (mercadoria, quantidade_estoque, valor, fornecedor, recibo_safra)" + " values (?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,mererEnt.getMercadoria());
        stmt.setInt(2,mererEnt.getQuantidade_estoque());
        stmt.setInt(3,mererEnt.getValor());
        stmt.setString(4,mererEnt.getFornecedor());
        stmt.setString(6,mererEnt.getRecibo_safra());


        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id_mercadoria = rs.getInt(1);
            mererEnt.setId_mercadoria(id_mercadoria);
        }
        stmt.close();
        return mererEnt;
    }

    public Mercadoria alterar(Mercadoria mererEnt) throws SQLException{
        String sql = "UPDATE mercadorias SET mercadoria = ?, quantidade_estoque = ?, valor = ?, fornecedor = ?, recibo_safra = ? WHERE id_mercadoria = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,mererEnt.getMercadoria());
        stmt.setInt(2,mererEnt.getQuantidade_estoque());
        stmt.setInt(3,mererEnt.getValor());
        stmt.setString(4,mererEnt.getFornecedor());
        stmt.setString(4,mererEnt.getRecibo_safra());
        stmt.setInt(5,mererEnt.getId_mercadoria());

        // executa
        stmt.execute();
        stmt.close();
        return mererEnt;
    }

   public List<Mercadoria> listar(Mercadoria merEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Mercadoria> listamers = new ArrayList<>();
        
        String sql = "select * from mercadorias where mercadoria like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + merEnt.getMercadoria() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Mercadoria mer = new Mercadoria(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getString(5),
                rs.getString(6)

            );
            // adiciona o usu à lista de usus
            listamers.add(mer);
        }
        
        rs.close();
        stmt.close();
        return listamers;
   
   }

    
}
