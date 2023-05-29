/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerCliente;
import backenddm20231n.model.bean.Cliente;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterCliente {

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
        int cpf = Integer.parseInt(JOptionPane.showInputDialog("CPF"));
        String cupom_desconto = JOptionPane.showInputDialog("CUPOM_DESCONTO");
        Cliente cliEnt = new Cliente(cpf,cupom_desconto);
        ControllerCliente contCli = new ControllerCliente();
        Cliente cliSaida = contCli.inserir(cliEnt);
        JOptionPane.showMessageDialog(null,cliSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id_cliente = Integer.parseInt(JOptionPane.showInputDialog("ID_CLIENTE"));
        int cpf = Integer.parseInt(JOptionPane.showInputDialog("CPF"));
        String cupom_desconto = JOptionPane.showInputDialog("CUPOM_DESCONTO");
        Cliente cliEnt = new Cliente(id_cliente,cpf,cupom_desconto);
        ControllerCliente contCli = new ControllerCliente();
        Cliente cliSaida = contCli.alterar(cliEnt);
        JOptionPane.showMessageDialog(null,cliSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id_cliente = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Cliente cliEnt = new Cliente(id_cliente);
        ControllerCliente contCli = new ControllerCliente();
        Cliente cliSaida = contCli.buscar(cliEnt);
        JOptionPane.showMessageDialog(null,cliSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id_cliente = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Cliente cliEnt = new Cliente(id_cliente);
        ControllerCliente contCli = new ControllerCliente();
        Cliente cliSaida = contCli.excluir(cliEnt);
        JOptionPane.showMessageDialog(null,cliSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        int cpf = Integer.parseInt(JOptionPane.showInputDialog("CPF"));
        Cliente cliEnt = new Cliente(cpf);
        ControllerCliente contCli = new ControllerCliente();
        List<Cliente> listaCliente = contCli.listar(cliEnt);
        for (Cliente cliSaida : listaCliente) {
            JOptionPane.showMessageDialog(null,cliSaida.toString());
        }
    }


    
}
