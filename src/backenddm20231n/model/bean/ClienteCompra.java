/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.bean;

/**
 *
 * @author Rafael
 */
public class ClienteCompra {
    private int id;
    private int idCliente;
    private int idCompra;
    private String observacao;
    private Cliente cli;
    private Compra com;

    public ClienteCompra(int id) {
        this.id = id;
    }

    public ClienteCompra(String observacao) {
        this.observacao = observacao;
    }

    public ClienteCompra(int id, int idCliente, int idCompra, String observacao) {
        this.id = id;
        this.idCliente = idCliente;
        this.idCompra = idCompra;
        this.observacao = observacao;
    }

    public ClienteCompra(int idCliente, int idCompra, String observacao) {
        this.idCliente = idCliente;
        this.idCompra = idCompra;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Compra getCom() {
        return com;
    }

    public void setCom(Compra com) {
        this.com = com;
    }

    @Override
    public String toString() {
        return "ClienteCompra{" + "id=" + id + ", idCliente=" + idCliente + ", idCompra=" + idCompra + ", observacao=" + observacao + '}';
    }
    
    
}
