/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.bean;

/**
 *
 * @author Rafael
 */
public class Mercadoria {
    private int id_mercadoria;
    private String mercadoria;
    private int quantidade_estoque;
    private int valor;
    private String fornecedor;
    private String recibo_safra;

    public Mercadoria(int id_mercadoria) {
        this.id_mercadoria = id_mercadoria;
    }

    public Mercadoria(String mercadoria) {
        this.mercadoria = mercadoria;
    }

    public Mercadoria(int id_mercadoria, String mercadoria, int quantidade_estoque, int valor, String fornecedor, String recibo_safra) {
        this.id_mercadoria = id_mercadoria;
        this.mercadoria = mercadoria;
        this.quantidade_estoque = quantidade_estoque;
        this.valor = valor;
        this.fornecedor = fornecedor;
        this.recibo_safra = recibo_safra;
    }

    public Mercadoria(String mercadoria, int quantidade_estoque, int valor, String fornecedor, String recibo_safra) {
        this.mercadoria = mercadoria;
        this.quantidade_estoque = quantidade_estoque;
        this.valor = valor;
        this.fornecedor = fornecedor;
        this.recibo_safra = recibo_safra;
    }

    
    public int getId_mercadoria() {
        return id_mercadoria;
    }

    public void setId_mercadoria(int id_mercadoria) {
        this.id_mercadoria = id_mercadoria;
    }

    public String getMercadoria() {
        return mercadoria;
    }

    public void setMercadoria(String mercadoria) {
        this.mercadoria = mercadoria;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getRecibo_safra() {
        return recibo_safra;
    }

    public void setRecibo_safra(String recibo_safra) {
        this.recibo_safra = recibo_safra;
    }

    @Override
    public String toString() {
        return "Mercadoria{" + "id_mercadoria=" + id_mercadoria + ", mercadoria=" + mercadoria + ", quantidade_estoque=" + quantidade_estoque + ", valor=" + valor + ", fornecedor=" + fornecedor + ", recibo_safra=" + recibo_safra + '}';
    }

  
    
}
