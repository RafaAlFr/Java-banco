/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.bean;

/**
 *
 * @author Rafael
 */
public class Cliente {
    private int id_cliente;
    private int cpf;
    private String cupom_desconto;

    public Cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    

    public Cliente(int id_cliente, int cpf, String cupom_desconto) {
        this.id_cliente = id_cliente;
        this.cpf = cpf;
        this.cupom_desconto = cupom_desconto;
    }

    public Cliente(int cpf, String cupom_desconto) {
        this.cpf = cpf;
        this.cupom_desconto = cupom_desconto;
    }
    
    

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getCupom_desconto() {
        return cupom_desconto;
    }

    public void setCupom_desconto(String cupom_desconto) {
        this.cupom_desconto = cupom_desconto;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", cpf=" + cpf + ", cupom_desconto=" + cupom_desconto + '}';
    }
    
    
}
