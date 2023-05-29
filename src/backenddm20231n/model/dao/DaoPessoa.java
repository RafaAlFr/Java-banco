/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.Pessoa;
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
public class DaoPessoa {

private final Connection c;
    
    public DaoPessoa() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Pessoa excluir(Pessoa pesEnt) throws SQLException{
        String sql = "delete from pessoas WHERE id_pessoa = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pesEnt.getId_pessoa());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return pesEnt;
    }
    
    public Pessoa buscar(Pessoa pesEnt) throws SQLException{
        String sql = "select * from pessoas WHERE id_pessoa = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,pesEnt.getId_pessoa());
            // executa
            ResultSet rs = stmt.executeQuery();
            Pessoa pesSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                pesSaida = new Pessoa(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getInt(5));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return pesSaida;
   }

    public Pessoa inserir(Pessoa pesEnt) throws SQLException{
        String sql = "insert into pessoas" + " (nome, idade, telefone, endereco)" + " values (?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,pesEnt.getNome());
        stmt.setInt(2,pesEnt.getIdade());
        stmt.setString(3,pesEnt.getEndereco());
        stmt.setInt(4,pesEnt.getTelefone());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id_pessoa = rs.getInt(1);
            pesEnt.setId_pessoa(id_pessoa);
        }
        stmt.close();
        return pesEnt;
    }

    public Pessoa alterar(Pessoa pesEnt) throws SQLException{
        String sql = "UPDATE pessoas SET nome = ?, idade = ?, endereco = ?, telefone = ? WHERE id_pessoa = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,pesEnt.getNome());
        stmt.setInt(2,pesEnt.getIdade());
        stmt.setString(3,pesEnt.getEndereco());
        stmt.setInt(4,pesEnt.getTelefone());
        stmt.setInt(5,pesEnt.getId_pessoa());

        // executa
        stmt.execute();
        stmt.close();
        return pesEnt;
    }

   public List<Pessoa> listar(Pessoa pesEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Pessoa> listapess = new ArrayList<>();
        
        String sql = "select * from pessoas where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + pesEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Pessoa pes = new Pessoa(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getInt(5)
            );
            // adiciona o usu à lista de usus
            listapess.add(pes);
        }
        
        rs.close();
        stmt.close();
        return listapess;
   
   }

    
}
