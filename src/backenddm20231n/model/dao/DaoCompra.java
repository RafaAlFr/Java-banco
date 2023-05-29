/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.Compra;
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
public class DaoCompra {

private final Connection c;
    
    public DaoCompra() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Compra excluir(Compra comEnt) throws SQLException{
        String sql = "delete from compra WHERE id_compra = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,comEnt.getId_compra());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return comEnt;
    }
    
    public Compra buscar(Compra comEnt) throws SQLException{
        String sql = "select * from compra WHERE id_compra = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,comEnt.getId_compra());
            // executa
            ResultSet rs = stmt.executeQuery();
            Compra comSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                comSaida = new Compra(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return comSaida;
   }

    public Compra inserir(Compra comEnt) throws SQLException{
        String sql = "insert into compra" + " (pagamento, recibo)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,comEnt.getPagamento());
        stmt.setString(2,comEnt.getRecibo());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id_compra = rs.getInt(1);
            comEnt.setId_compra(id_compra);
        }
        stmt.close();
        return comEnt;
    }

    public Compra alterar(Compra comEnt) throws SQLException{
        String sql = "UPDATE compra SET pagamento = ?, recibo = ? WHERE id_compra = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,comEnt.getPagamento());
        stmt.setString(2,comEnt.getRecibo());
        stmt.setInt(3,comEnt.getId_compra());

        // executa
        stmt.execute();
        stmt.close();
        return comEnt;
    }

   public List<Compra> listar(Compra comEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Compra> listacoms = new ArrayList<>();
        
        String sql = "select * from compra where recibo like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + comEnt.getRecibo() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Compra com = new Compra(
                rs.getInt(1),
                rs.getInt(2),
                rs.getString(3)
            );
            // adiciona o usu à lista de usus
            listacoms.add(com);
        }
        
        rs.close();
        stmt.close();
        return listacoms;
   
   }

    
}
