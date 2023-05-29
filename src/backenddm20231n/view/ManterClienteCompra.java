/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.view;



import backenddm20231n.controller.ControllerClienteCompra;
import backenddm20231n.model.bean.ClienteCompra;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Rafael
 */
public class ManterClienteCompra {
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
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("IDCLIENTE"));
        int idCompra = Integer.parseInt(JOptionPane.showInputDialog("IDCOMPRA"));
        String observacao = JOptionPane.showInputDialog("OBSERVACAO");
        ClienteCompra clicomEnt = new ClienteCompra(idCliente,idCompra,observacao);
        ControllerClienteCompra contClicom = new ControllerClienteCompra();
        ClienteCompra clicomSaida = contClicom.inserir(clicomEnt);
        JOptionPane.showMessageDialog(null,clicomSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("IdCliente"));
        int idCompra = Integer.parseInt(JOptionPane.showInputDialog("IdCompra"));
        String observacao = JOptionPane.showInputDialog("OBSERVACAO");
        ClienteCompra clicomEnt = new ClienteCompra(id,idCliente,idCompra,observacao);
        ControllerClienteCompra contClicom = new ControllerClienteCompra();
        ClienteCompra clicomSaida = contClicom.alterar(clicomEnt);
        JOptionPane.showMessageDialog(null,clicomSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ClienteCompra clicomEnt = new ClienteCompra(id);
        ControllerClienteCompra contClicom = new ControllerClienteCompra();
        ClienteCompra clicomSaida = contClicom.buscar(clicomEnt);
        JOptionPane.showMessageDialog(null,clicomSaida.toString());
        JOptionPane.showMessageDialog(null,clicomSaida.getCli().toString());
        JOptionPane.showMessageDialog(null,clicomSaida.getCom().toString());

    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ClienteCompra clicomEnt = new ClienteCompra(id);
        ControllerClienteCompra contClicom = new ControllerClienteCompra();
        ClienteCompra clicomSaida = contClicom.excluir(clicomEnt);
        JOptionPane.showMessageDialog(null,clicomSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String observacao = JOptionPane.showInputDialog("OBSERVACAO");
        ClienteCompra clicomEnt = new ClienteCompra(observacao);
        ControllerClienteCompra contClicom = new ControllerClienteCompra();
        List<ClienteCompra> listaClienteCompra = contClicom.listar(clicomEnt);
        for (ClienteCompra clicomSaida : listaClienteCompra) {
            JOptionPane.showMessageDialog(null,clicomSaida.toString());
            JOptionPane.showMessageDialog(null,clicomSaida.getCli().toString());
            JOptionPane.showMessageDialog(null,clicomSaida.getCom().toString());
        }
    }
}
