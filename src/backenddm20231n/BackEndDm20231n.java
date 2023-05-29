/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n;

import backenddm20231n.view.ManterCliente;
import backenddm20231n.view.ManterClienteCompra;
import backenddm20231n.view.ManterPessoa;
import backenddm20231n.view.ManterFuncionario;
import backenddm20231n.view.ManterMercadoria;
import backenddm20231n.view.ManterCompra;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class BackEndDm20231n {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String msg = " 0 - Sair \n 1 - Pessoas \n 2 - Clinetes \n 3 - Funcionarios \n 4 - Mercadorias \n 5 - Compras \n";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                ManterPessoa.menu();
                break;
            case 2:
                ManterCliente.menu();
                break;
            case 3:
                ManterFuncionario.menu();
                break;
            case 4:
                ManterMercadoria.menu();
                break;
            case 5:
                ManterCompra.menu();
                break;
            case 6:
                ManterClienteCompra.menu();
            break;

            default:
                System.out.println("Opção inválido");
        }
    }
    
}
