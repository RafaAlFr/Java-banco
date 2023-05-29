/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.bean;

/**
 *
 * @author Rafael
 */
public class Pessoa {
    private int id_pessoa;
    private String nome;
    private int idade;
    private String endereco;
    private int telefone;

    public Pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(int id_pessoa, String nome, int idade, String endereco, int telefone) {
        this.id_pessoa = id_pessoa;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Pessoa(String nome, int idade, String endereco, int telefone) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id_pessoa=" + id_pessoa + ", nome=" + nome + ", idade=" + idade + ", endereco=" + endereco + ", telefone=" + telefone + '}';
    }

    
    
    
}
