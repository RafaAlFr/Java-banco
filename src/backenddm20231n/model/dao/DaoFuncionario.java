/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.Funcionario;
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
public class DaoFuncionario {

private final Connection c;
    
    public DaoFuncionario() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Funcionario excluir(Funcionario funEnt) throws SQLException{
        String sql = "delete from funcionario WHERE id_funcionario = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,funEnt.getId_funcionario());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return funEnt;
    }
    
    public Funcionario buscar(Funcionario funEnt) throws SQLException{
        String sql = "select * from funcionario WHERE id_funcionario = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,funEnt.getId_funcionario());
            // executa
            ResultSet rs = stmt.executeQuery();
            Funcionario funSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                funSaida = new Funcionario(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return funSaida;
   }

    public Funcionario inserir(Funcionario funEnt) throws SQLException{
        String sql = "insert into funcionario" + " (salario, turno, cargo)" + " values (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,funEnt.getSalario());
        stmt.setString(2,funEnt.getTurno());
        stmt.setString(3,funEnt.getCargo());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id_funcionario = rs.getInt(1);
            funEnt.setId_funcionario(id_funcionario);
        }
        stmt.close();
        return funEnt;
    }

    public Funcionario alterar(Funcionario funEnt) throws SQLException{
        String sql = "UPDATE funcionario SET salario = ?, turno = ?, cargo = ? WHERE id_funcionario = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,funEnt.getSalario());
        stmt.setString(2,funEnt.getTurno());
        stmt.setString(3,funEnt.getCargo());
        stmt.setInt(4,funEnt.getId_funcionario());

        // executa
        stmt.execute();
        stmt.close();
        return funEnt;
    }

   public List<Funcionario> listar(Funcionario funEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Funcionario> listafuns = new ArrayList<>();
        
        String sql = "select * from funcionario where cargo like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + funEnt.getCargo() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Funcionario fun = new Funcionario(
                rs.getInt(1),
                rs.getInt(2),
                rs.getString(3),
                rs.getString(4)
            );
            // adiciona o usu à lista de usus
            listafuns.add(fun);
        }
        
        rs.close();
        stmt.close();
        return listafuns;
   
   }

    
}
