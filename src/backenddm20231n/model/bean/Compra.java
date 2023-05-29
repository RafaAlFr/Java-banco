/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.bean;

/**
 *
 * @author Rafael
 */
public class Compra {
    private int id_compra;
    private int pagamento;
    private String recibo;

    public Compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public Compra(String recibo) {
        this.recibo = recibo;
    }
    

    public Compra(int id_compra, int pagamento, String recibo) {
        this.id_compra = id_compra;
        this.pagamento = pagamento;
        this.recibo = recibo;
    }

    public Compra(int pagamento, String recibo) {
        this.pagamento = pagamento;
        this.recibo = recibo;
    }
    

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getPagamento() {
        return pagamento;
    }

    public void setPagamento(int pagamento) {
        this.pagamento = pagamento;
    }

    public String getRecibo() {
        return recibo;
    }

    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    @Override
    public String toString() {
        return "Compra{" + "id_compra=" + id_compra + ", pagamento=" + pagamento + ", recibo=" + recibo + '}';
    }
    
    
    
}
