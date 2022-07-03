/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class Produto {
    private int id;
    private String nome;
    private String unidadeDeMedida;
    private Date datacadastro;
    
    public Produto(){
        
    }

    public Produto(int id, String nome, String unidadeDeMedida) {
        this.id = id;
        this.nome = nome;
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public Produto(int id, String nome, String unidadeDeMedida, Date datacadastro) {
        this.id = id;
        this.nome = nome;
        this.unidadeDeMedida = unidadeDeMedida;
        this.datacadastro = datacadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public void setUnidadeDeMedida(String unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }
    
    
}
