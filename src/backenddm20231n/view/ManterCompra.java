/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerCompra;
import backenddm20231n.model.bean.Compra;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterCompra {

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
        int pagamento = Integer.parseInt(JOptionPane.showInputDialog("PAGAMENTO"));
        String recibo = JOptionPane.showInputDialog("RECIBO");
        Compra comEnt = new Compra(pagamento,recibo);
        ControllerCompra contCom = new ControllerCompra();
        Compra comSaida = contCom.inserir(comEnt);
        JOptionPane.showMessageDialog(null,comSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id_compra = Integer.parseInt(JOptionPane.showInputDialog("ID_COMPRA"));
        int pagamento = Integer.parseInt(JOptionPane.showInputDialog("PAGAMENTO"));
        String recibo = JOptionPane.showInputDialog("RECIBO");
        Compra comEnt = new Compra(id_compra,pagamento,recibo);
        ControllerCompra contCom = new ControllerCompra();
        Compra comSaida = contCom.alterar(comEnt);
        JOptionPane.showMessageDialog(null,comSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id_compra = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Compra comEnt = new Compra(id_compra);
        ControllerCompra contCom = new ControllerCompra();
        Compra comSaida = contCom.buscar(comEnt);
        JOptionPane.showMessageDialog(null,comSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id_compra = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Compra comEnt = new Compra(id_compra);
        ControllerCompra contCom = new ControllerCompra();
        Compra comSaida = contCom.excluir(comEnt);
        JOptionPane.showMessageDialog(null,comSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String recibo = JOptionPane.showInputDialog("RECIBO");
        Compra comEnt = new Compra(recibo);
        ControllerCompra contCom = new ControllerCompra();
        List<Compra> listaCompra = contCom.listar(comEnt);
        for (Compra comSaida : listaCompra) {
            JOptionPane.showMessageDialog(null,comSaida.toString());
        }
    }


    
}
