/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerMercadoria;
import backenddm20231n.model.bean.Mercadoria;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterMercadoria {

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opcao inválida");
        }
    }

    private static void inserir() throws SQLException, ClassNotFoundException {
        String mercadoria = JOptionPane.showInputDialog("MERCADORIA");
        int quantidade_estoque = Integer.parseInt(JOptionPane.showInputDialog("QUANTIDADE_ESTOQUE"));
        int valor = Integer.parseInt(JOptionPane.showInputDialog("VALOR"));
        String fornecedor = JOptionPane.showInputDialog("FORNECEDOR");
        String recibo_safra = JOptionPane.showInputDialog("RECIBO_SAFRA");
        Mercadoria merEnt = new Mercadoria(mercadoria,quantidade_estoque,valor,fornecedor,recibo_safra);
        ControllerMercadoria contMer = new ControllerMercadoria();
        Mercadoria merSaida = contMer.inserir(merEnt);
        JOptionPane.showMessageDialog(null,merSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id_mercadoria = Integer.parseInt(JOptionPane.showInputDialog("ID_PESSOA"));
        String mercadoria = JOptionPane.showInputDialog("MERCADORIA");
        int quantidade_estoque = Integer.parseInt(JOptionPane.showInputDialog("QUANTIDADE_ESTOQUE"));
        int valor = Integer.parseInt(JOptionPane.showInputDialog("VALOR"));
        String fornecedor = JOptionPane.showInputDialog("FORNECEDOR");
        String recibo_safra = JOptionPane.showInputDialog("RECIBO_SAFRA");
        Mercadoria merEnt = new Mercadoria(id_mercadoria,mercadoria,quantidade_estoque,valor,fornecedor,recibo_safra);
        ControllerMercadoria contMer = new ControllerMercadoria();
        Mercadoria merSaida = contMer.alterar(merEnt);
        JOptionPane.showMessageDialog(null,merSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id_mercadoria = Integer.parseInt(JOptionPane.showInputDialog("ID_MERCADORIA"));
        Mercadoria merEnt = new Mercadoria(id_mercadoria);
        ControllerMercadoria contMer = new ControllerMercadoria();
        Mercadoria merSaida = contMer.buscar(merEnt);
        JOptionPane.showMessageDialog(null,merSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id_mercadoria = Integer.parseInt(JOptionPane.showInputDialog("ID_MERCADORIA"));
        Mercadoria merEnt = new Mercadoria(id_mercadoria);
        ControllerMercadoria contMer = new ControllerMercadoria();
        Mercadoria merSaida = contMer.excluir(merEnt);
        JOptionPane.showMessageDialog(null,merSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String mercadoria = JOptionPane.showInputDialog("Mercadoria");
        Mercadoria merEnt = new Mercadoria(mercadoria);
        ControllerMercadoria contMer = new ControllerMercadoria();
        List<Mercadoria> listaMercadoria = contMer.listar(merEnt);
        for (Mercadoria merSaida : listaMercadoria) {
            JOptionPane.showMessageDialog(null,merSaida.toString());
        }
    }


    
}
