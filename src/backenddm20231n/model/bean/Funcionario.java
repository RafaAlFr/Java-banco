/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.bean;

/**
 *
 * @author Rafael
 */
public class Funcionario {
    private int id_funcionario;
    private int salario;
    private String turno;
    private String cargo;

    public Funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public Funcionario(String cargo) {
        this.cargo = cargo;
    }

    public Funcionario(int id_funcionario, int salario, String turno, String cargo) {
        this.id_funcionario = id_funcionario;
        this.salario = salario;
        this.turno = turno;
        this.cargo = cargo;
    }

    public Funcionario(int salario, String turno, String cargo) {
        this.salario = salario;
        this.turno = turno;
        this.cargo = cargo;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    @Override
    public String toString() {
        return "funcionario{" + "id_funcionario=" + id_funcionario + ", salario=" + salario + ", turno=" + turno + ", cargo=" + cargo + '}';
    }
    
    
}
