/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerFuncionario;
import backenddm20231n.model.bean.Funcionario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManterFuncionario {

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
        int salario = Integer.parseInt(JOptionPane.showInputDialog("SALARIO"));
        String turno = JOptionPane.showInputDialog("TURNO");
        String cargo = JOptionPane.showInputDialog("CARGO");
        Funcionario funEnt = new Funcionario(salario,turno,cargo);
        ControllerFuncionario contFun = new ControllerFuncionario();
        Funcionario funSaida = contFun.inserir(funEnt);
        JOptionPane.showMessageDialog(null,funSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id_funcionario = Integer.parseInt(JOptionPane.showInputDialog("ID_FUNCIONARIO"));
        int salario = Integer.parseInt(JOptionPane.showInputDialog("SALARIO"));
        String turno = JOptionPane.showInputDialog("TURNO");
        String cargo = JOptionPane.showInputDialog("CARGO");
        Funcionario funEnt = new Funcionario(id_funcionario,salario,turno,cargo);
        ControllerFuncionario contFun = new ControllerFuncionario();
        Funcionario funSaida = contFun.alterar(funEnt);
        JOptionPane.showMessageDialog(null,funSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id_funcionario = Integer.parseInt(JOptionPane.showInputDialog("ID_FUNCIONARIO"));
        Funcionario funEnt = new Funcionario(id_funcionario);
        ControllerFuncionario contFun = new ControllerFuncionario();
        Funcionario funSaida = contFun.buscar(funEnt);
        JOptionPane.showMessageDialog(null,funSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id_funcionario = Integer.parseInt(JOptionPane.showInputDialog("ID_FUNCIONARIO"));
        Funcionario funEnt = new Funcionario(id_funcionario);
        ControllerFuncionario contFun = new ControllerFuncionario();
        Funcionario funSaida = contFun.excluir(funEnt);
        JOptionPane.showMessageDialog(null,funSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String cargo = JOptionPane.showInputDialog("cargo");
        Funcionario funEnt = new Funcionario(cargo);
        ControllerFuncionario contFun = new ControllerFuncionario();
        List<Funcionario> listaFuncionario = contFun.listar(funEnt);
        for (Funcionario funSaida : listaFuncionario) {
            JOptionPane.showMessageDialog(null,funSaida.toString());
        }
    }


    
}
